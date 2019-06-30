/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.utils;

import javassist.ClassPool;
import javassist.NotFoundException;
import org.crossmobile.utils.CustomTypeClasses.VoidRef;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class ReflectionUtils {

    private static ClassLoader cl = ReflectionUtils.class.getClassLoader();
    private static Method getPackage = findMethod(cl.getClass(), "getPackage", String.class);

    public static void setClassLoader(ClassLoader cl) {
        ReflectionUtils.cl = cl;
        getPackage = findMethod(cl.getClass(), "getPackage", String.class);
    }

    @SuppressWarnings("UseSpecificCatch")
    public static Method findMethod(Class<?> cls, String methodName, Class<?>... params) {
        while (cls != null) {
            try {
                Method m = cls.getDeclaredMethod(methodName, params);
                m.setAccessible(true);
                return m;
            } catch (Exception ex) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    // Added "null" since it is not considered a reserved word
    private static final Collection<String> reservedWords = new HashSet<>(Arrays.asList("abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while", "null"));

    public static Class<?> appearsInParent(Executable exec) {
        Class givenClass = exec.getDeclaringClass();
        String execName = exec.getName();
        Class<?>[] params = exec.getParameterTypes();
        for (Class<?> interf : givenClass.getInterfaces())
            try {
                if (interf.getMethod(execName, params) != null)
                    return checkParentHierarchy(interf, execName, params);
            } catch (NoSuchMethodException | SecurityException ex) {
            }
        return checkParentHierarchy(givenClass, execName, params);
    }

    private static Class<?> checkParentHierarchy(Class base, String execName, Class<?>... paramtype) {
        Class current = base;
        try {
            while ((current = current.getSuperclass()) != null && current.getMethod(execName, paramtype) != null)
                base = current;
        } catch (NoSuchMethodException | SecurityException ex) {
        }
        return base;
    }

    public static boolean appearsFirstIn(Executable exec, Class bottomClass) {
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
        for (Class interf : base.getInterfaces()) {
            A ann = getAnnotationRecursively(interf, annClass, exec.getName(), exec.getParameterTypes());
            if (ann != null)
                return ann;
        }
        return getAnnotationRecursively(exec.getDeclaringClass(), annClass, exec.getName(), exec.getParameterTypes());
    }

    public static <A extends Annotation> A getAnnotationRecursively(Class<?> baseClass, Class<A> annClass, String methodName, Class[] methodParams) {
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

    public static Method getLambdaMethod(Class interf) {
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

    public static Constructor getParentConstructor(Constructor cs) {
        if (cs == null)
            return null;
        Class cls = cs.getDeclaringClass().getSuperclass();
        while (cls != null) {
            try {
                return cls.getConstructor(cs.getParameterTypes());
            } catch (NoSuchMethodException | SecurityException ex) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Class getArrayClassOfClass(Class classType) {
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

    public static Class getClassForName(String type) {
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

    public static Method createMethod(Class<?> declaringClass, String name, Class[] paramTypes, Class returnType) {
        return createMethod(declaringClass, name, paramTypes, declaringClass, null, 0, 0, "", null, null, null);
    }

    public static Method createMethod(Class<?> declaringClass, String name, Class<?>[] parameterTypes, Class<?> returnType, Class<?>[] checkedExceptions, int modifiers, int slot, String signature, byte[] annotations, byte[] parameterAnnotations, byte[] annotationDefault) {
        if (annotations == null)
            annotations = new byte[]{};
        if (parameterAnnotations == null)
            parameterAnnotations = new byte[]{};
        if (annotationDefault == null)
            annotationDefault = new byte[]{};
        try {
            Constructor<Method> constr = Method.class.getDeclaredConstructor(Class.class, String.class, Class[].class, Class.class, Class[].class, int.class, int.class, String.class, byte[].class, byte[].class, byte[].class);
            constr.setAccessible(true);
            return constr.newInstance(declaringClass, name, parameterTypes, returnType, checkedExceptions, modifiers, slot, signature, annotations, parameterAnnotations, annotationDefault);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Log.error("Unable to create method");
            return null;
        }

    }

    public static Parameter createParam(Executable executable, int index) {
        return createParam(null, 0, executable, index);
    }

    public static Parameter createParam(String name, int modifiers, Executable executable, int index) {
        try {
            if (name == null || name.isEmpty())
                name = "arg" + index;
            Constructor<Parameter> constr = Parameter.class.getDeclaredConstructor(String.class, int.class, Executable.class, int.class);
            constr.setAccessible(true);
            return constr.newInstance(name, modifiers, executable, index);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Log.error("Unable to create parameter", ex);
            return null;
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static Package getParentPackage(Package pkg) {
        String cname = pkg.getName();
        Package found;
        while (cname != null) {
            int dot = cname.lastIndexOf('.');
            if (dot < 0)
                return null;
            cname = cname.substring(0, dot);
            if (getPackage == null)
                found = Package.getPackage(cname);
            else
                try {
                    found = (Package) getPackage.invoke(cl, cname);
                } catch (Exception ex) {
                    found = null;
                }
            if (found != null)
                return found;
        }
        return null;
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
        else if (cls.isMemberClass())
            while (current != null) {
                cls = current;
                current = current.getDeclaringClass();
            }
        return cls;
    }

    public static ClassPool getClassPool(Iterable<File> jarfiles) {
        ClassPool cp = ClassPool.getDefault();
        if (jarfiles != null)
            for (File file : jarfiles)
                try {
                    cp.appendPathList(file.getAbsolutePath());
                } catch (NotFoundException ex) {
                }
        return cp;
    }

    public static Class<?> getTopLevelClass(Class<?> cls) {
        Class<?> enclosingClass = cls.getEnclosingClass();
        return enclosingClass == null ? cls : getTopClass(enclosingClass);
    }
}
