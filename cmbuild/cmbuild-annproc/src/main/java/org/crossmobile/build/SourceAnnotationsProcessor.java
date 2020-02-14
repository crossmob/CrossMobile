/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.tools.StandardLocation;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

import static javax.lang.model.element.ElementKind.PACKAGE;
import static org.crossmobile.build.AnnotationConfig.*;
import static org.crossmobile.build.AnnotationInjection.*;
import static org.crossmobile.build.SourceAnnotationsProcessor.*;

@SupportedAnnotationTypes({IBACTION, IBOUTLET, NATIVECODE, BUILDMODULE})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class SourceAnnotationsProcessor extends AbstractProcessor {

    private static final String SENDER_OBJECT = "java.lang.Object";
    private static final Pattern TARGET_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");

    static final String IBACTION = "org.robovm.objc.annotation.IBAction";
    static final String IBOUTLET = "org.robovm.objc.annotation.IBOutlet";
    static final String NATIVECODE = "org.crossmobile.bridge.ann.NativeCode";
    static final String BUILDMODULE = "org.crossmobile.bridge.ann.BuildModule";

    private static Class<? extends Annotation> IBAction = null;
    private static Class<? extends Annotation> IBOutlet = null;
    private static Class<? extends Annotation> NativeCode = null;
    private static Class<? extends Annotation> BuildModule = null;
    private static Method nativeCodeValue = null;
    private static Method value = null;
    private static Method inMainTarget = null;
    private static Method principalClass = null;

    static {
        try {
            //noinspection unchecked
            IBAction = getAnnClass(IBACTION);
            IBOutlet = getAnnClass(IBOUTLET);
            NativeCode = getAnnClass(NATIVECODE);
            BuildModule = getAnnClass(BUILDMODULE);
            if (NativeCode != null)
                nativeCodeValue = NativeCode.getMethod("value");
            if (BuildModule != null) {
                value = BuildModule.getMethod("value");
                inMainTarget = BuildModule.getMethod("inMainTarget");
                principalClass = BuildModule.getMethod("principalClass");
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException ignored) {
        }
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (inMainTarget == null) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, ": Unable to instantiate CrossMobile annotations");
            return false;
        }
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, " NO WARNING AT ALL");

        Filer filer = processingEnv.getFiler();
        File objcoutdir;
        try {
            objcoutdir = new File(Paths.get(filer.createResource(StandardLocation.CLASS_OUTPUT, "", "testname").toUri()).getParent().getParent().toFile(), ANN_LOCATION);
        } catch (IOException ex) {
            return true;
        }

        Map<String, AnnotationInjection> injections = new HashMap<>();
        for (Element e : roundEnv.getElementsAnnotatedWith(IBAction))
            constructAction(e, injections);
        for (Element e : roundEnv.getElementsAnnotatedWith(IBOutlet))
            constructOutlet(e, injections);
        for (Element e : roundEnv.getElementsAnnotatedWith(NativeCode))
            constructNative(e, injections);
        for (Element e : roundEnv.getElementsAnnotatedWith(BuildModule))
            constructTarget(e, injections);

        generatedOutlets(objcoutdir);
        saveInjections(injections, objcoutdir, filer);
        return true;
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    private void constructAction(Element e, Map<String, AnnotationInjection> injections) {
        ExecutableType t = (ExecutableType) e.asType();
        List<? extends TypeMirror> p = t.getParameterTypes();
        String superName = e.getEnclosingElement().toString();

        // Error checking
        StringBuilder error = new StringBuilder();
        if (p.size() != 1 || (p.size() == 1 && !p.get(0).toString().equals(SENDER_OBJECT)))
            error.append("should have exactly one argument of type ").append(SENDER_OBJECT);
        boolean isStatic = e.getModifiers().contains(Modifier.STATIC);
        boolean isNotPublic = !e.getModifiers().contains(Modifier.PUBLIC);
        boolean isVoid = t.getReturnType().getKind() != TypeKind.VOID;
        if (isStatic || isVoid || isNotPublic) {
            if (error.length() > 0)
                error.append(" and ");
            error.append("should");
            if (isStatic || isNotPublic) {
                error.append(" be");
                if (isStatic)
                    error.append(" non-static");
                if (isNotPublic)
                    error.append(" public");
            }
            if (isVoid) {
                if (isStatic)
                    error.append(" with return type");
                else
                    error.append(" return");
                error.append(" void");
            }
        }
        if (error.length() > 1)
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "@IBAction: " + superName + "." + e.toString() + " " + error.toString());
        else
            getItem(injections, superName).actions.add(e.getSimpleName().toString());
    }

    private void constructOutlet(Element e, Map<String, AnnotationInjection> injections) {
        String superName = e.getEnclosingElement().toString();
        String name = e.getSimpleName().toString();
        String type = e.asType().toString();
        int point = type.lastIndexOf(".");
        if (point < 1)  // Not in default package
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "@IBOutlet: Type of " + superName + "." + name + " should be an object, not in default package");
        else {
            String error = "";
            if (!e.getModifiers().contains(Modifier.PUBLIC))
                error += " public";
            if (e.getModifiers().contains(Modifier.STATIC))
                error += " non-static";
            if (error.length() > 0)
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "@IBOutlet: Item " + superName + "." + name + " should be" + error + " to be accessible");
            else
                getItem(injections, superName).outlets.put(name, type);
        }
    }

    private AnnotationInjection getItem(Map<String, AnnotationInjection> injections, String key) {
        AnnotationInjection current = injections.get(key);
        if (current == null) {
            current = new AnnotationInjection(true);
            injections.put(key, current);
        }
        return current;
    }

    private void constructNative(Element element, Map<String, AnnotationInjection> injections) {
        if (element.asType() instanceof ExecutableType) {
            ExecutableType execType = (ExecutableType) element.asType();
            List<? extends VariableElement> pname = ((ExecutableElement) element).getParameters();
            List<? extends TypeMirror> ptype = execType.getParameterTypes();

            Map<String, String> children = new HashMap<>();
            children.put(METHOD, getMethodSignature(execType, element, ptype, pname));
            try {
                children.put(CODE, (String) nativeCodeValue.invoke(element.getAnnotation(NativeCode)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to parse NativeCode annotation: " + ex.toString());
                return;
            }

            Map<String, Map<String, String>> root = new HashMap<>();
            root.put(getMethodSignature(execType, element, ptype, null), children);
            getItem(injections, element.getEnclosingElement().toString()).nativemethods.put(getMethodSignature(execType, element, ptype, null), children);
        } else
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unknown NativeCode annotation location");
    }

    private String getMethodSignature(ExecutableType execType, Element execElement, List<? extends TypeMirror> ptype, List<? extends VariableElement> pname) {
        StringBuilder out = new StringBuilder();
        out.append(execElement.getModifiers().contains(Modifier.STATIC) ? "+ (" : "- (");
        out.append(getTypeName(execType.getReturnType().toString(), true)).append(") ");
        out.append(execElement.getSimpleName()).append("__");
        for (TypeMirror type : ptype)
            out.append("_").append(getTypeName(type.toString(), false));
        for (int i = 0; i < ptype.size(); i++)
            out.append(" :(").
                    append(getTypeName(ptype.get(i).toString(), true)).
                    append(")").
                    append(pname == null ? ("n" + (i + 1)) : pname.get(i).getSimpleName().toString());
        return out.toString();
    }

    private String getTypeName(String name, boolean asNative) {
        name = name.replace('.', '_');
        if (asNative)
            if (name.contains("_"))
                name += "*";
            else if (name.equals("byte") || name.equals("short") || name.equals("boolean") || name.equals("char"))
                name = "int";
            else if (name.equals("long"))
                name = "JAVA_LONG";
        return name;
    }

    private void constructTarget(Element element, Map<String, AnnotationInjection> injections) {
        try {
            if (element.getEnclosingElement().getKind() != PACKAGE) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, BUILDMODULE + " should not be used in an inner class, found in " + element.asType().toString());
                return;
            }

            StringBuilder dataB = new StringBuilder();
            for (String target : (String[]) value.invoke(element.getAnnotation(BuildModule)))
                if (!TARGET_PATTERN.matcher(target).matches())
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Target " + target + " is not valid");
                else
                    dataB.append(':').append(target);
            String data = dataB.toString();
            if (!data.isEmpty()) {
                AnnotationInjection ann = getItem(injections, element.asType().toString());
                ann.inMainTarget = (boolean) inMainTarget.invoke(element.getAnnotation(BuildModule));
                ann.principalClass = (boolean) principalClass.invoke(element.getAnnotation(BuildModule));
                ann.otherTargets = data.substring(1);
            }
        } catch (Exception e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to retrieve information from annotation " + BUILDMODULE + " for item " + element.asType().toString() + ": " + e.toString());
        }
    }

    private void saveInjections(Map<String, AnnotationInjection> injections, File objcoutdir, Filer filer) {
        if (injections.isEmpty())
            return;
        if (objcoutdir.mkdirs()) ;
        if (!objcoutdir.isDirectory()) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Unable to create directory: " + objcoutdir.getAbsolutePath());
            return;
        }
        saveInjectionsImpl(injections, objcoutdir, null);
        saveInjectionsImpl(injections, null, filer);
    }

    private void saveInjectionsImpl(Map<String, AnnotationInjection> injections, File objcoutdir, Filer filer) {
        for (String key : injections.keySet())
            try {
                AnnotationInjection injection = injections.get(key);
                String flatName = key.replace('.', '_');
                if (objcoutdir != null)
                    injection.serializeForXcode(new OutputStreamWriter(new FileOutputStream(new File(objcoutdir, flatName + OBJECTS_EXT)), StandardCharsets.UTF_8));
                else if (injection.hasOutlets()) {
                    injection.serializeAsSource(key, flatName, filer.createSourceFile(AnnotationConfig.OUTLET_PGK + "." + flatName + "__").openWriter());
                    generatedOutlets.remove(flatName);
                }
            } catch (IOException ex) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, ex.toString());
            }
        for (String key : generatedOutlets.keySet()) {
            try {
                if (filer != null) {
                    String flatName = key.replace('.', '_');
                    new AnnotationInjection(true).serializeAsSource(key, flatName, filer.createSourceFile(AnnotationConfig.OUTLET_PGK + "." + flatName + "__").openWriter());
                }
            } catch (IOException ex) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, ex.toString());
            }
        }

    }

    private void generatedOutlets(File objcoutdir) {
        if (objcoutdir == null || !objcoutdir.exists() || !objcoutdir.isDirectory())
            return;
        File[] files = objcoutdir.listFiles((dir, name) -> name.endsWith(GENERATED_EXT));
        if (files == null)
            return;
        for (File f : files)
            try {
                BufferedReader b = new BufferedReader(new FileReader(f));
                String line;
                while ((line = b.readLine()) != null) {
                    if (line.startsWith(OUTLET)) {
                        String key = f.getName().replace(GENERATED_EXT, "").trim();
                        if (generatedOutlets.containsKey(key))
                            generatedOutlets.get(key).add(line.replace(OUTLET, "").trim());
                        else
                            generatedOutlets.put(key, new HashSet<>(Collections.singletonList(line.replace(OUTLET, "").trim())));
                    }
                }
            } catch (IOException ex) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, ex.toString());
            }
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends Annotation> getAnnClass(String name) throws ClassNotFoundException {
        return (Class<? extends Annotation>) Class.forName(name);
    }
}
