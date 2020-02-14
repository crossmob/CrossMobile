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

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NStructField;
import org.crossmobile.plugin.utils.NameResolver;
import org.crossmobile.utils.Log;
import org.robovm.objc.block.Block4;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.function.Function;
import java.util.regex.Pattern;

import static org.crossmobile.plugin.reg.TypeRegistry.isBlock;
import static org.crossmobile.plugin.utils.Texters.annName;
import static org.crossmobile.utils.CollectionUtils.forEach;
import static org.crossmobile.utils.NamingUtils.execSignature;
import static org.crossmobile.utils.NamingUtils.getClassNameFull;
import static org.crossmobile.utils.ReflectionUtils.getLambdaMethod;
import static org.crossmobile.utils.TextUtils.capitalize;
import static org.crossmobile.utils.TextUtils.plural;

public class FormerTests {

    private static final Pattern STRUCTREF = Pattern.compile("([a-zA-Z_]([a-zA-Z_0-9])*)(\\.([a-zA-Z_]([a-zA-Z_0-9])*))*");


    public static Class<?> testStructField(Class<?> host, String field) throws NoSuchMethodException {
        Block4<String, Class<? extends Annotation>, Function<Method, Class<?>>, StrongReference<Class<?>>, String> test = (type, annotation, typeSupplier, result) -> {
            String methodName = type + capitalize(field);
            Method method;
            try {
                if (result.get() == null) // first time, as getter
                    method = host.getMethod(methodName);
                else    // second time, as setter
                    method = host.getMethod(methodName, result.get());
            } catch (NoSuchMethodException e) {
                String param = result.get() == null
                        ? ""
                        : getClassNameFull(result.get()) + " value";
                return "Unable to find accessor of field '" + field + "' with " + type + "ter named " + methodName + "(" + param + ") in class " + getClassNameFull(host);
            }
            if (method.getAnnotation(annotation) == null)
                return "Method " + method.getName() + "() is not properly annotated with " + annName(annotation) + " in class " + getClassNameFull(host);
            result.set(typeSupplier.apply(method));
            if (!result.get().isPrimitive() && result.get().getAnnotation(CMStruct.class) == null)
                return "Only primitive types or other structs are allowed as members in struct objects, field named " + field + " in class " + getClassNameFull(host) + " is found of type " + getClassNameFull(result.get());
            return null;
        };
        StrongReference<Class<?>> type = new StrongReference<>();
        String error = test.invoke("get", CMGetter.class, Method::getReturnType, type);
        if (error != null)
            throw new NoSuchMethodException(error);
        error = test.invoke("set", CMSetter.class, m -> m.getParameterTypes()[0], type);
        if (error != null)
            throw new NoSuchMethodException(error);
        return type.get();
    }

    public static boolean testConstructorStruct(Constructor cs) {
        boolean correct = true;
        Parameter[] parameters = cs.getParameters();
        if (parameters == null || parameters.length == 0) {
            Log.error("Constructor of " + execSignature(cs) + " doesn't have any parameters");
            return false;
        }
        Class<?> baseClass = cs.getDeclaringClass();
        for (int i = 0; i < parameters.length; i++) {
            Parameter p = parameters[i];
            CMRef ref = p.getAnnotation(CMRef.class);
            if (ref == null) {
                Log.error("Parameter #" + (i + 1) + " of constructor " + execSignature(cs) + " is missing annotation " + annName(CMRef.class));
                correct = false;
            } else if (!STRUCTREF.matcher(ref.value()).matches()) {
                Log.error("Parameter #" + (i + 1) + " of constructor " + execSignature(cs) + " has wrong value for annotation " + annName(CMRef.class) + " ; the correct value has the format var(.var)*");
                correct = false;
            } else {
                String error = isStructReferenceValid(baseClass, ref.value().split("\\."), p.getType(), 0);
                if (error != null) {
                    Log.error("Wrong reference path '" + ref.value() + "' of parameter #" + (i + 1) + " of constructor " + execSignature(cs) + " : " + error);
                    correct = false;
                }
            }
        }
        return correct;
    }

    private static String isStructReferenceValid(Class<?> baseClass, String[] parts, Class<?> lookingForClass, int idx) {
        String fieldName = parts[idx];
        Class<?> fieldType = NStructField.findType(baseClass, fieldName);
        if (fieldType == null)
            return "unable to find accessor methods";
        if ((idx + 1) == parts.length) {
            if (!fieldType.equals(lookingForClass))
                return "field has wrong type, current field type is " + getClassNameFull(fieldType) + " while constructor type is " + getClassNameFull(lookingForClass);
            else
                return null;
        } else if (fieldType.isPrimitive())
            return "field is primitive while reference path denotes a struct, probably the path is too deep";
        else
            return isStructReferenceValid(fieldType, parts, lookingForClass, idx + 1);
    }

    private static boolean test(Class cls, String type, boolean refrainInterface, boolean requireFinal, boolean refrainConstructors, boolean requirePublicFields, boolean refrainPublicMethods) {
        if (refrainInterface && cls.isInterface()) {
            Log.error(type + " " + getClassNameFull(cls) + " should not be an interface");
            return false;
        }
        if (requireFinal && !Modifier.isFinal(cls.getModifiers())) {
            Log.error(type + " " + getClassNameFull(cls) + " should be final");
            return false;
        }
        if (refrainConstructors) {
            Constructor[] constructors = cls.getConstructors();
            if (constructors != null && constructors.length > 0) {
                Log.error("Found " + constructors.length + " public constructor" + plural(constructors.length) + " in " + type.toLowerCase() + " " + getClassNameFull(cls));
                return false;
            }
        }
        boolean foundFields = testPublicFields(cls);
        if (requirePublicFields && !foundFields) {
            Log.error(type + " " + getClassNameFull(cls) + " does not provide any public fields");
            return false;
        }
        String methods = testPublicMethods(cls);
        if (refrainPublicMethods && methods != null) {
            Log.error(type + " " + getClassNameFull(cls) + " should not provide any public methods, found: " + methods);
            return false;
        }
        return true;
    }

    public static boolean testEnum(Class cls, CMEnum ann) {
        return test(cls, "Enumeration class", true, true, true, true, true);
    }

    public static boolean testStruct(Class cls, CMStruct ann) {
        if (cls.getConstructors().length < 1) {
            Log.error("No public constructors found for struct " + getClassNameFull(cls));
            return false;
        }
        if (cls.getFields().length > 0) {
            Log.error("No public fields are allowed to struct " + getClassNameFull(cls));
            return false;
        }
        int idx = 0;
        for (String name : ann.value()) {
            idx++;
            if (name.isEmpty()) {
                Log.error("Struct member field #" + idx + " in class " + getClassNameFull(cls) + " found empty");
                return false;
            }
            if (name.contains(" ")) {
                Log.error("Struct member field #" + idx + " '" + name + "' in class " + getClassNameFull(cls) + " found containing illegal space character");
                return false;
            }
            try {
                testStructField(cls, name);
            } catch (NoSuchMethodException e) {
                Log.error("Error while parsing struct member field #" + idx + " '" + name + "' in class " + getClassNameFull(cls) + " : " + e.getMessage());
                return false;
            }
        }
        if (idx == 0) {
            Log.error("Struct class " + getClassNameFull(cls) + " does not contain any member fields");
            return false;
        }
        return test(cls, "Struct", true, true, false, false, false);
    }

    public static boolean testBundle(Class cls, CMBundle ann) {
        if (!test(cls, "Bundle class", true, true, true, false, false))
            return false;
        for (Method m : cls.getMethods())
            if (!m.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(m.getModifiers())) {
                Log.error("Bundle class is not compatible with non-static methods, offending method " + execSignature(m));
                return false;
            }
        testPublicFields(cls);
        return true;
    }

    public static boolean testReference(Class<?> cls, CMReference ann) {
        return test(cls, "Reference class", true, false, false, false, false);
    }

    public static boolean testTarget(Class c, CMTarget anTarget) {
        if (!c.isInterface()) {
            Log.error("Target class " + getClassNameFull(c) + " should be an interface");
            return false;
        }
        Method method = getLambdaMethod(c);
        if (method == null) {
            Log.error("Target class " + getClassNameFull(c) + " should be a functional interface");
            return false;
        }
        if (method.getAnnotation(CMSelector.class) == null && method.getAnnotation(CMBlock.class) == null) {
            Log.error("Target method " + execSignature(method) + " should be annotated with one of " + annName(CMSelector.class) + " or " + annName(CMBlock.class));
            return false;
        }
        if (method.getAnnotation(CMBlock.class) != null) {
            if (!isBlock(c)) {
                Log.error("Target class " + getClassNameFull(c) + " with block method " + execSignature(method) + " should extend any block interface");
                return false;
            }

            boolean foundGenerics = false;
            for (Type t : c.getGenericInterfaces())
                if (t instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) t;
                    if (isBlock((pt.getRawType() instanceof Class) ? (Class) pt.getRawType() : Object.class))
                        foundGenerics = true;
                } else if ((t instanceof Class) && Runnable.class.equals(t))
                    foundGenerics = true;
            if (!foundGenerics) {
                Log.error("Target class " + getClassNameFull(c) + " with block method " + execSignature(method) + " should extend a block interface with generics; no generics found");
                return false;
            }
        }
        return true;
    }

    public static boolean testClass(Class cls, CMClass ann) {
        testPublicFields(cls);
        return true;
    }

    public static boolean testSelectorsConsistency(NObject nobj) {
        return testGettersAndSetters(nobj) & NameResolver.resolve(nobj);
    }

    private static boolean testGettersAndSetters(NObject nobj) {
        boolean correct = true;
        for (NSelector selector : nobj.getSelectors()) {
            Executable exec = selector.getJavaExecutable();
            Class returnType = selector.getReturnType().getType();
            if (selector.isSetter() && !exec.getName().equals(selector.getName())) {
                Log.error("Java setter " + exec.getName() + " of class " + exec.getDeclaringClass().getName() + " should be named " + selector.getName() + " ; native code provided: " + selector.getOriginalCode());
                correct = false;
            } else if (selector.isGetter() && !exec.getName().equals(selector.getProperty().getGetter())) {
                // Check if we have a getter on the parent object with different return type, so that we need to change the name
                boolean isCorrect = false;
                try {
                    Class<?> superclass = exec.getDeclaringClass().getSuperclass();
                    Method supermethod = superclass.getMethod(selector.getProperty().getGetter(), exec.getParameterTypes());
                    if (!supermethod.getReturnType().equals(returnType))
                        isCorrect = true;
                } catch (NoSuchMethodException | SecurityException | NullPointerException ex) {
                }
                if (!isCorrect) {
                    Log.error("Java getter " + exec.getName() + " of class " + getClassNameFull(exec.getDeclaringClass()) + " should be named " + selector.getProperty().getGetter() + " ; native code provided: " + selector.getOriginalCode());
                    correct = false;
                }
            }
        }
        return correct;
    }

    public static Class testEnumType(Class en) {
        Field[] fields = en.getFields();
        Class lastType = null;
        for (Field f : fields)
            if (lastType == null)
                lastType = f.getType();
            else if (!lastType.equals(f.getType()))
                return null;
        return lastType;
    }

    /**
     * @param c
     * @return if any public fields were found
     */
    private static boolean testPublicFields(Class c) {
        c.getFields();
        Field[] fields = c.getFields();
        boolean strictSingleType = c.getAnnotation(CMEnum.class) != null;
        Class lastType = null;
        if (fields != null && fields.length > 0) {
            for (Field f : fields)
                if (!Modifier.isStatic(f.getModifiers()) || !Modifier.isFinal(f.getModifiers()))
                    Log.error("Field " + f.getName() + " in class " + getClassNameFull(c) + " should be final and static in order to be public");
                else if (!f.getType().isPrimitive() && !f.getType().equals(String.class))
                    Log.error("Only primitive fields or String class is permitted for public static final fields, field " + f.getName() + " in class " + getClassNameFull(c) + " is of type " + getClassNameFull(f.getType()));
                else if (lastType == null)
                    lastType = f.getType();
                else if (strictSingleType && !lastType.equals(f.getType()))
                    Log.error("Only a single type is allowed for class " + getClassNameFull(c) + ", found " + getClassNameFull(f.getType()) + " while already registered " + getClassNameFull(lastType));
            return true;
        }
        return false;
    }

    public static boolean testMissingJoin(NSelector selector, Executable exec) {
        int sel = 0;
        int join = 0;
        for (NParam p : selector.getParams())
            if (Method.class.equals(p.getNType().getType()))
                sel++;
        for (Parameter p : exec.getParameters())
            if (p.getAnnotation(CMJoinSEL.class) != null)
                join++;
        return sel != join;
    }

    public static String testSelectorClass(Class<?> selectorClass) {
        CMTarget annotation = selectorClass.getAnnotation(CMTarget.class);
        if (annotation == null)
            return "Class " + getClassNameFull(selectorClass) + " is expected to be a selector class. Maybe should be annotated with " + annName(CMTarget.class) + ".";
        for (Method m : selectorClass.getMethods())
            if (Modifier.isAbstract(m.getModifiers()))
                if (m.getAnnotation(CMSelector.class) == null)
                    return "Method  " + execSignature(m) + " is expected to be a selector. Maybe should be annotated with " + annName(CMSelector.class) + ".";
        return null;
    }

    private static String testPublicMethods(Class c) {
        StringBuilder out = new StringBuilder();
        forEach(c.getMethods()).
                setFilter(m -> Modifier.isPublic(m.getModifiers()) && !m.getDeclaringClass().equals(Object.class)).onTail(e -> out.append(", ")).onAny(m -> out.append(execSignature(m))).go();
        return out.length() > 0 ? out.toString() : null;
    }
}
