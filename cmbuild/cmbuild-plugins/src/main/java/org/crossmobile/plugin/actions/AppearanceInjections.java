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
package org.crossmobile.plugin.actions;

import javassist.*;
import javassist.bytecode.*;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMReference;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.robovm.objc.annotation.UIAppearanceSelector;
import org.robovm.objc.block.VoidBlock1;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static org.crossmobile.plugin.actions.AppearanceInjections.AnnMetaData.asClass;
import static org.crossmobile.plugin.actions.AppearanceInjections.AnnMetaData.asString;
import static org.crossmobile.utils.FileUtils.Predicates.extensions;
import static org.crossmobile.utils.TextUtils.*;

public class AppearanceInjections {
    private static final String RESULT_ANCHOR = "RESULT_ANCHOR";
    private static final String SOURCE_ANCHOR = "SOURCE_ANCHOR";
    private static final String PARAM_METHOD = "PARAM_METHOD";
    private static final String ISSET_CALLBACK_METHOD = "ISSET_CALLBACK_METHOD";

    private static final String CLASS_SUFFIX = "Appearance";
    private static final String CLASS_FILE_SUFFIX = CLASS_SUFFIX + ".class";

    private static final String APPEARANCE_NATIVE = "+ (instancetype)appearance;";
    private static final String APPEARANCE_CONTAINED_NATIVE = "+ (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;";
    private static final String APPEARANCE_CONTAINED_SIGNATURE = "(Ljava/util/List<Ljava/lang/Class<+Lcrossmobile/ios/uikit/UIAppearanceContainer;>;>;)L" + RESULT_ANCHOR + ";";
    private static final String APPEARANCE_CODE = "return (" + RESULT_ANCHOR + ")org.crossmobile.bind.graphics.AppearanceRegistry.requestAppearance(" + SOURCE_ANCHOR + ".class, " + RESULT_ANCHOR + ".class);";
    private static final String APPEARANCE_CONTAINED_CODE = "return (" + RESULT_ANCHOR + ")org.crossmobile.bind.graphics.AppearanceRegistry.requestAppearance(" + SOURCE_ANCHOR + ".class, $1, " + RESULT_ANCHOR + ".class);";
    private static final String INVOKE_PARAM_CODE = "public void invoke( Object obj) { " + SOURCE_ANCHOR + " val = (" + SOURCE_ANCHOR + ")obj; if (!val." + ISSET_CALLBACK_METHOD + "()) val." + PARAM_METHOD + "(param); }";

    private CtClass NSObjectCt;
    private CtClass UIAppearanceCt;
    private CtClass ListCt;
    private CtClass VoidBlock1Ct;

    private final ClassPool cp;
    private final String rootClassPath;

    private final Map<CtClass, CtClass> appearanceContainers = new TreeMap<>((c1, c2) -> {
        if (c1.equals(c2))
            return 0;
        if (c1.subclassOf(c2))
            return -1;
        if (c2.subclassOf(c1))
            return 1;
        return c1.getName().compareTo(c2.getName());
    });

    public AppearanceInjections(ClassPool cp, String rootClassPath) {
        this.cp = cp;
        this.rootClassPath = rootClassPath;
        try {
            this.NSObjectCt = cp.get(ObjectRegistry.NSObjectClassName);
            this.UIAppearanceCt = cp.get(ObjectRegistry.UIAppearanceClassName);
            this.ListCt = cp.get(List.class.getName());
            this.VoidBlock1Ct = cp.get(VoidBlock1.class.getName());
        } catch (NotFoundException ex) {
            BaseUtils.throwException(ex);
        }
    }

    public void cleanup(File targetClass) {
        AtomicInteger howMany = new AtomicInteger();
        FileUtils.forAllRecursively(targetClass, extensions(CLASS_FILE_SUFFIX), (path, file) -> {
            String fileName = file.getName();
            File other = new File(file.getParentFile(), fileName.substring(0, fileName.length() - CLASS_FILE_SUFFIX.length()) + ".class");
            if (other.exists() && FileUtils.getLastModified(file) < FileUtils.getLastModified(other)) {
                howMany.incrementAndGet();
                if (!file.delete())
                    Log.error("Requested to delete file " + file.getAbsolutePath() + " but unable to do so.");
                else
                    Log.debug("Deleting file " + file.getAbsolutePath());
            }
        });
        Log.info("Removing " + howMany.get() + " file" + plural(howMany.get()));
    }

    public void makeAppearance(Class<?> cls) {
        try {
            try {
                cp.get(cls.getName() + CLASS_SUFFIX); // already exists
                return;
            } catch (NotFoundException ignored) { // Needs creation
            }
            CtClass baseC = cp.get(cls.getName());
            CtClass baseAppearanceC = NSObjectCt;
            for (CtClass c : appearanceContainers.keySet())
                if (baseC.subclassOf(c)) {
                    baseAppearanceC = appearanceContainers.get(c);
                    break;
                }

            CtClass appearanceC = baseAppearanceC;
            for (CtMethod fromM : baseC.getDeclaredMethods())
                if (Modifier.isPublic(fromM.getModifiers()) && fromM.hasAnnotation(UIAppearanceSelector.class)) {
                    if (appearanceC == baseAppearanceC)
                        appearanceC = createAppearanceClass(baseC, baseAppearanceC);
                    String paramName = decapitalize(trim(fromM.getName(), "set"));
                    createContainerHelperMethods(baseC, fromM, paramName);
                    addAppearancePropertyMethod(appearanceC, baseC, fromM, paramName);
                }
            if (appearanceC != baseAppearanceC) {
                appearanceC.writeFile(rootClassPath);
                appearanceC.defrost();
                appearanceContainers.put(baseC, appearanceC);
            }

            createContainerBaseMethods(appearanceC, baseC);
            baseC.writeFile(rootClassPath);
            baseC.defrost();
        } catch (Throwable err) {
            Log.error(err);
            BaseUtils.throwException(err);
        }
    }

    private void createContainerHelperMethods(CtClass baseC, CtMethod fromM, String param) throws Exception {
        String fieldName = getCheckParamField(param);
        CtField paramField = CtField.make("private boolean " + fieldName + " = false;", baseC);
        baseC.addField(paramField);

        String shadowSetterName = getParamSetterMethod(param);
        CtMethod shadow = CtNewMethod.make(fromM.getReturnType(), shadowSetterName, fromM.getParameterTypes(), null, null, baseC);
        shadow.getMethodInfo().setCodeAttribute(fromM.getMethodInfo().getCodeAttribute());
        shadow.setModifiers(Modifier.setPackage(shadow.getModifiers()));
        baseC.addMethod(shadow);
        fromM.setBody("{" + getCheckParamField(param) + " = true; " + shadowSetterName + "($1);}");

        CtMethod issetMethod = CtNewMethod.make(CtClass.booleanType, getCheckParamMethod(param), new CtClass[0], null, null, baseC);
        issetMethod.setModifiers(Modifier.setPackage(issetMethod.getModifiers()));
        issetMethod.setBody("return " + fieldName + ";");
        baseC.addMethod(issetMethod);
    }

    private void createContainerBaseMethods(CtClass appearanceC, CtClass baseC) throws Exception {
        CtMethod appMethodPlain = CtNewMethod.make(appearanceC, "appearance", new CtClass[0], null, null, baseC);
        appMethodPlain.setModifiers(appMethodPlain.getModifiers() | Modifier.STATIC);
        appMethodPlain.getMethodInfo().addAttribute(getAttribute(CMSelector.class, baseC, asString("value", APPEARANCE_NATIVE)));
        appMethodPlain.setBody(APPEARANCE_CODE.replaceAll(RESULT_ANCHOR, appearanceC.getName()).replaceAll(SOURCE_ANCHOR, baseC.getName()));
        baseC.addMethod(appMethodPlain);

        CtMethod appMethodHierarchy = CtNewMethod.make(appearanceC, "appearanceWhenContainedInInstancesOfClasses", new CtClass[]{ListCt}, null, null, baseC);
        appMethodHierarchy.setModifiers(appMethodHierarchy.getModifiers() | Modifier.STATIC);
        appMethodHierarchy.getMethodInfo().addAttribute(getAttribute(CMSelector.class, baseC, asString("value", APPEARANCE_CONTAINED_NATIVE)));
        setParamAttr(0, CMParamMod.class, appMethodHierarchy, asString("convertWith", "jclass_to_class_list"));
        appMethodHierarchy.getMethodInfo().addAttribute(new SignatureAttribute(appMethodHierarchy.getMethodInfo().getConstPool(), APPEARANCE_CONTAINED_SIGNATURE.replace(RESULT_ANCHOR, appearanceC.getName().replace('.', '/'))));
        appMethodHierarchy.setBody(APPEARANCE_CONTAINED_CODE.replaceAll(RESULT_ANCHOR, appearanceC.getName()).replaceAll(SOURCE_ANCHOR, baseC.getName()));
        baseC.addMethod(appMethodHierarchy);
    }

    private CtClass createAppearanceClass(CtClass baseC, CtClass parentC) throws CannotCompileException {
        CtClass appearanceC = cp.makeClass(baseC.getName() + CLASS_SUFFIX, parentC);
        appearanceC.setInterfaces(new CtClass[]{UIAppearanceCt});
        CtConstructor constructor = CtNewConstructor.defaultConstructor(appearanceC);
        constructor.setModifiers(Modifier.setPackage(constructor.getModifiers()));
        appearanceC.addConstructor(constructor);
        appearanceC.getClassFile().addAttribute(getAttribute(CMReference.class, appearanceC, asClass("proxyOf", baseC)));
        return appearanceC;
    }

    private CtClass addAppearancePropertyMethod(CtClass appearanceC, CtClass baseC, CtMethod fromM, String paramName) throws Exception {
        CtClass paramClass = createParamClass(appearanceC, baseC, fromM, paramName);
        paramClass.writeFile(rootClassPath);

        CtMethod toM = CtNewMethod.make(fromM.getReturnType(), fromM.getName(), fromM.getParameterTypes(), null, null, appearanceC);
        toM.setBody("org.crossmobile.bind.graphics.AppearanceRegistry.registerValue(this, \"" + paramName + "\", new " + paramClass.getName() + "($1));");
        copyAnnotation(CMSelector.class, fromM, toM);
        copyAnnotation(CMSetter.class, fromM, toM);
        appearanceC.addMethod(toM);
        return appearanceC;
    }

    private CtClass createParamClass(CtClass appearanceC, CtClass baseC, CtMethod fromM, String paramName) throws Exception {
        String paramType = fromM.getParameterTypes()[0].getName();

        CtClass paramClass = appearanceC.makeNestedClass(capitalize(paramName), true);
        paramClass.setInterfaces(new CtClass[]{VoidBlock1Ct});
        paramClass.setModifiers(Modifier.setPackage(paramClass.getModifiers()));
        paramClass.addField(CtField.make("private " + paramType + " param;", paramClass));

        CtConstructor paramConstructor = CtNewConstructor.make(fromM.getParameterTypes(), null, null, paramClass);
        paramConstructor.setBody("this.param = $1;");
        paramClass.addConstructor(paramConstructor);

        CtMethod paramMethod = CtNewMethod.make(INVOKE_PARAM_CODE.replaceAll(SOURCE_ANCHOR, baseC.getName()).replaceAll(PARAM_METHOD, getParamSetterMethod(paramName)).replaceAll(ISSET_CALLBACK_METHOD, getCheckParamMethod(paramName)), paramClass);
        paramClass.addMethod(paramMethod);

        return paramClass;
    }

    private <T extends java.lang.annotation.Annotation> boolean copyAnnotation(Class<T> annotationClass, CtMethod srcMethod, CtMethod destMethod) {
        if (srcMethod.hasAnnotation(annotationClass)) {
            try {
                Object annotation = srcMethod.getAnnotation(annotationClass);
                if (annotation != null) {
                    String value = (String) annotationClass.getMethod("value").invoke(annotation);
                    destMethod.getMethodInfo().addAttribute(getAttribute(annotationClass, destMethod.getDeclaringClass(), asString("value", value)));
                    return true;
                }
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
            }
        }
        return false;
    }

    private AttributeInfo getAttribute(Class<? extends java.lang.annotation.Annotation> annotationClass, CtClass container, AnnMetaData... metaData) {
        ClassFile classFile = container.getClassFile();
        ConstPool constpool = classFile.getConstPool();
        AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
        attr.addAnnotation(getAnnotation(annotationClass, constpool, metaData));
        return attr;
    }

    private void setParamAttr(int idx, Class<? extends java.lang.annotation.Annotation> annotationClass, CtMethod method, AnnMetaData... metaData) {
        ConstPool cp = method.getMethodInfo().getConstPool();
        ParameterAnnotationsAttribute paramAttribute = (ParameterAnnotationsAttribute) method.getMethodInfo().getAttribute(ParameterAnnotationsAttribute.visibleTag); // or inVisibleTag
        if (paramAttribute == null)
            paramAttribute = new ParameterAnnotationsAttribute(cp, ParameterAnnotationsAttribute.visibleTag);

        Annotation annotation = getAnnotation(annotationClass, cp, metaData);

        Annotation[][] paramsAnn = paramAttribute.getAnnotations();
        try {
            if (paramsAnn == null || paramsAnn.length != method.getParameterTypes().length)
                paramsAnn = new Annotation[method.getParameterTypes().length][];
        } catch (NotFoundException ex) {
            BaseUtils.throwException(ex);
            return;
        }

        // gather and shift old annotations
        Annotation[] oldParamAnn = paramsAnn[idx];
        Annotation[] newParamAnn = oldParamAnn == null || oldParamAnn.length == 0
                ? new Annotation[1]
                : Arrays.copyOf(oldParamAnn, oldParamAnn.length + 1);
        newParamAnn[oldParamAnn == null ? 0 : oldParamAnn.length] = annotation;

        paramsAnn[idx] = newParamAnn;
        paramAttribute.setAnnotations(paramsAnn);
        method.getMethodInfo().addAttribute(paramAttribute);
    }

    private Annotation getAnnotation(Class<?> annotationClass, ConstPool constpool, AnnMetaData... metaData) {
        Annotation annotation = new Annotation(annotationClass.getName(), constpool);
        for (AnnMetaData meta : metaData)
            annotation.addMemberValue(meta.name, meta.valueConstructor.apply(constpool));
        return annotation;
    }

    private String getCheckParamMethod(String param) {
        return "_isSet" + capitalize(param);
    }

    private String getCheckParamField(String param) {
        return "_appearance" + capitalize(param);
    }

    private String getParamSetterMethod(String param) {
        return "_appearanceSet" + capitalize(param);
    }

    static class AnnMetaData {
        final String name;
        final Function<ConstPool, ? extends MemberValue> valueConstructor;

        private AnnMetaData(String name, Function<ConstPool, ? extends MemberValue> valueConstructor) {
            this.name = name;
            this.valueConstructor = valueConstructor;
        }

        public static AnnMetaData asClass(String name, CtClass classType) {
            return new AnnMetaData(name, cp -> new ClassMemberValue(classType.getName(), cp));
        }

        public static AnnMetaData asString(String name, String value) {
            return new AnnMetaData(name, cp -> new StringMemberValue(value, cp));
        }
    }
}
