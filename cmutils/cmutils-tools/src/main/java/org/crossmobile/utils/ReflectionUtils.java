/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.CustomTypeClasses.VoidRef;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class ReflectionUtils {

    private static ExtClassLoader cl = new ExtClassLoader();

    public static void resetClassLoader() {
        cl = new ExtClassLoader();
    }

    @SuppressWarnings("UseSpecificCatch")
    public static Method findMethod(Class<?> cls, String methodName, Class<?>... params) {
        while (cls != null) {
            try {
                Method m = cls.getDeclaredMethod(methodName, params);
                m.setAccessible(true);
                return m;
            } catch (Exception ignored) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    // Added "null" since it is not considered a reserved word
    private static final Collection<String> reservedWords = new HashSet<>(Arrays.asList("abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while", "null"));

    public static Class<?> appearsInParent(Executable exec) {
        Class<?> givenClass = exec.getDeclaringClass();
        String execName = exec.getName();
        Class<?>[] params = exec.getParameterTypes();
        for (Class<?> interf : givenClass.getInterfaces())
            try {
                if (interf.getMethod(execName, params) != null)
                    return checkParentHierarchy(interf, execName, params);
            } catch (NoSuchMethodException | SecurityException ignored) {
            }
        return checkParentHierarchy(givenClass, execName, params);
    }

    private static Class<?> checkParentHierarchy(Class<?> base, String execName, Class<?>... paramtype) {
        Class<?> current = base;
        try {
            while ((current = current.getSuperclass()) != null && current.getMethod(execName, paramtype) != null)
                base = current;
        } catch (NoSuchMethodException | SecurityException ignored) {
        }
        return base;
    }

    public static boolean appearsFirstIn(Executable exec, Class<?> bottomClass) {
        Class<?> thisClass = exec.getDeclaringClass();
        if (!bottomClass.isInterface() && !bottomClass.equals(thisClass))
            return false;
        if (Modifier.isStatic(exec.getModifiers()))
            return true;
        try {
            Class<?> superclass = thisClass.getSuperclass();
            return superclass == null || superclass.getMethod(exec.getName(), exec.getParameterTypes()) == null;
        } catch (NoSuchMethodException | SecurityException ex) {
            return true;
        }
    }

    public static <A extends Annotation> A getAnnotation(Executable exec, Class<A> annClass) {
        Class<?> base = exec.getDeclaringClass();
        for (Class<?> interf : base.getInterfaces()) {
            A ann = getAnnotationRecursively(interf, annClass, exec.getName(), exec.getParameterTypes());
            if (ann != null)
                return ann;
        }
        return getAnnotationRecursively(exec.getDeclaringClass(), annClass, exec.getName(), exec.getParameterTypes());
    }

    public static <A extends Annotation> A getAnnotationRecursively(Class<?> baseClass, Class<A> annClass, String methodName, Class<?>[] methodParams) {
        A ann = null;
        while (ann == null && baseClass != null)
            try {
                ann = baseClass.getMethod(methodName, methodParams).getAnnotation(annClass);
                baseClass = baseClass.getSuperclass();
            } catch (NoSuchMethodException | SecurityException ex) {
                break;
            }
        return ann;
    }

    public static Class<?> getTypeOfParameter(Parameter param) {
        Type type = param.getParameterizedType();
        if (!(type instanceof ParameterizedType))
            return null;
        Type[] typeArgs = ((ParameterizedType) type).getActualTypeArguments();
        return typeArgs == null || typeArgs.length == 0 ? null
                : getClass(typeArgs[0]);
    }

    @SuppressWarnings("DuplicateCondition")
    public static Class<?> getClass(Type type) {
        if (type instanceof Class<?>)
            return (Class<?>) type;
        else if (type instanceof ParameterizedType)
            return getClass(((ParameterizedType) type).getRawType());
        else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            Class<?> componentClass = getClass(componentType);
            if (componentClass != null)
                return Array.newInstance(componentClass, 0).getClass();
            else
                return null;
        } else
            return null;
    }

    public static Method getLambdaMethod(Class<?> interf) {
        if (!interf.isInterface())
            return null;
        Method result = null;
        for (Method m : interf.getMethods())
            if (!m.isDefault())
                if (result != null)
                    return null;
                else
                    result = m;
        return result;
    }

    public static Constructor<?> getParentConstructor(Constructor<?> cs) {
        if (cs == null)
            return null;
        Class<?> cls = cs.getDeclaringClass().getSuperclass();
        while (cls != null) {
            try {
                return cls.getConstructor(cs.getParameterTypes());
            } catch (NoSuchMethodException | SecurityException ignored) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Class<?> getArrayClassOfClass(Class<?> classType) {
        if (classType == null)
            return null;
        if (classType.isArray())
            try {
                return Class.forName("[" + classType.getName(), false, cl);
            } catch (ClassNotFoundException ex) {
                Log.error("Unable to instantiate array class-type from array class " + classType.getName());
                return null;
            }
        if (classType.isPrimitive())
            switch (classType.getName()) {
                case "boolean":
                    return boolean[].class;
                case "byte":
                    return byte[].class;
                case "short":
                    return short[].class;
                case "int":
                    return int[].class;
                case "long":
                    return long[].class;
                case "float":
                    return float[].class;
                case "double":
                    return double[].class;
                case "char":
                    return char[].class;
                case "void":
                    return VoidRef.class;
                default:
                    Log.error("Unable to instantiate primitive class-type from array of object " + classType.getName());
                    return null;
            }
        else
            try {
                return Class.forName("[L" + classType.getName() + ";", false, cl);
            } catch (ClassNotFoundException ex) {
                Log.error("Unable to instantiate class-type from array of object " + classType.getName());
                return null;
            }
    }

    public static Class<?> getClassForName(String type) {
        switch (type) {
            case "boolean":
                return boolean.class;
            case "byte":
                return byte.class;
            case "short":
                return short.class;
            case "int":
                return int.class;
            case "long":
                return long.class;
            case "float":
                return float.class;
            case "double":
                return double.class;
            case "char":
                return char.class;
            case "void":
                return void.class;
            default:
                if (type.startsWith("java"))
                    try {
                        return Class.forName(type, false, cl);
                    } catch (ClassNotFoundException ignore) {
                    }
                try {
                    return Class.forName("java.lang." + type, false, cl);
                } catch (ClassNotFoundException ignore) {
                }
                try {
                    return Class.forName("java.util." + type, false, cl);
                } catch (ClassNotFoundException ignore) {
                }
                try {
                    return Class.forName(type.replace('_', '.'), false, cl);
                } catch (ClassNotFoundException ignore) {
                }
                return null;
        }
    }

    public static Class<?> getBareClass(Class<?> baseClass) {
        while (baseClass.isArray())
            baseClass = baseClass.getComponentType();
        return baseClass;
    }

    public static boolean isReservedWord(String word) {
        return reservedWords.contains(word);
    }

    public static int getArrayDimensions(Class<?> cls) {
        int counter = 0;
        while (cls.isArray()) {
            counter++;
            cls = cls.getComponentType();
        }
        return counter;
    }

    @SuppressWarnings("UseSpecificCatch")
    public static Package getParentPackage(Package pkg) {
        String cname = pkg.getName();
        Package found;
        while (true) {
            int dot = cname.lastIndexOf('.');
            if (dot < 0)
                return null;
            cname = cname.substring(0, dot);
            found = cl.getPackage(cname);
            if (found != null)
                return found;
        }
    }

    public static Package findPackage(Package base, Class<? extends Annotation> annClass) {
        do {
            if (base.getAnnotation(annClass) != null)
                return base;
            base = getParentPackage(base);
        } while (base != null);
        return null;
    }

    public static Class<?> getTopClass(Class<?> cls) {
        Class<?> current = cls;
        if (cls.isLocalClass())
            while (current != null) {
                cls = current;
                current = current.getEnclosingClass();
            }
        else {
            try {
                if (cls.isMemberClass())
                    while (current != null) {
                        cls = current;
                        current = current.getDeclaringClass();
                    }
            } catch (Throwable ignored) {
            }
        }
        return cls;
    }

    public static ClassPool getClassPool(Iterable<File> jarfiles) {
        ClassPool cp = ClassPool.getDefault();
        if (jarfiles != null)
            for (File file : jarfiles)
                try {
                    cp.appendPathList(file.getAbsolutePath());
                } catch (NotFoundException ignored) {
                }
        return cp;
    }

    public static CtClass getCtClass(ClassPool cp, String className) {
        try {
            return cp.get(className);
        } catch (NotFoundException e) {
            BaseUtils.throwException(e);
            throw new RuntimeException(e);  // will never come here
        }
    }

    public static Collection<CtClass> getInheritedClasses(CtClass cls) {
        Collection<CtClass> inherited = new ArrayList<>();
        CtClass superClass = getSuperClass(cls);
        if (superClass != null)
            inherited.add(superClass);
        try {
            inherited.addAll(Arrays.asList(cls.getInterfaces()));
        } catch (NotFoundException ignored) {
        }
        return inherited;
    }

    public static CtClass getSuperClass(CtClass cls) {
        try {
            return cls.getSuperclass();
        } catch (NotFoundException e) {
            return null;
        }
    }

    public static Class<?> getTopLevelClass(Class<?> cls) {
        Class<?> enclosingClass = cls.getEnclosingClass();
        return enclosingClass == null ? cls : getTopClass(enclosingClass);
    }

    public static ExtClassLoader getClassLoader() {
        return cl;
    }

    public static final class ExtClassLoader extends java.net.URLClassLoader {
        private ExtClassLoader() {
            super(new URL[0], ExtClassLoader.class.getClassLoader());
        }

        @Override
        public void addURL(URL url) {
            super.addURL(url);
        }

        @Override
        public Package getPackage(String name) {
            return super.getPackage(name);
        }
    }
}
