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
package org.crossmobile.plugin.reg;

import org.crossmobile.bridge.ann.*;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.utils.CustomTypeClasses;
import org.crossmobile.utils.CustomTypeClasses.VoidRef;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.NamingUtils;
import org.crossmobile.utils.ReflectionUtils;
import org.robovm.objc.block.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.crossmobile.plugin.actions.FormerTests.testSelectorClass;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;
import static org.crossmobile.utils.ReflectionUtils.*;
import static org.crossmobile.utils.TextUtils.capitalize;

public class TypeRegistry {

    private static final String VoidRefClassName = NamingUtils.getClassNameSimple(VoidRef.class);
    private static final TypeDef typedef = new TypeDef();
    private static final Class<Method> SELclass = Method.class;
    private static final Set<String> needsCasting = new HashSet<>();

    public static final int VARARG_SIZE_SUPPORT = 20;

    public static final String JCLASS_TO_CLASS_METHOD = "jclass_to_class";
    public static final String JCLASS_TO_STRING_METHOD = "jclass_to_string";
    public static final String JCLASS_TO_CLASS_LIST_METHOD = "jclass_to_class_list";

    static {
        needsCasting.add("CFString");
        needsCasting.add("CFDictionary");
        needsCasting.add("CFSet");
        needsCasting.add("CFError");
        typedef.alias(SELclass, "SEL");
    }

    public static void register(Class cls) {
        if (!Modifier.isPublic(cls.getModifiers()))
            return;
        typedef.add(cls);
    }

    public static void registerDependencies(Class cls) {
        register(cls);
    }

    public static Class getReferencedJavaClass(Class baseClass) {
        return getJavaClass(getClassNameSimple(baseClass));
    }

    public static Class getJavaClass(String type) {
        return getJavaClass(type, 0, false, false, null);
    }

    public static Class getJavaClass(String type, int stars, boolean varargs, boolean array, AtomicInteger referenceCount) {
        if (type.endsWith("Ref")) {
            if (type.equals(VoidRefClassName))
                return VoidRef.class;
            type = type.substring(0, type.length() - 3);
            stars++;
        }
        if (referenceCount != null)
            referenceCount.set(stars);

        Class classType = typedef.get(type);
        if (classType == null)
            classType = ReflectionUtils.getClassForName(type);
        if (classType == null) {
            Log.error("Unable to recognize type " + type);
            return TypeUnknown.class;
        }
        if (varargs) {
            Class varargsClass = getArrayClassOfClass(classType);
            if (varargsClass != null)
                classType = varargsClass;
        }
        if ((classType.isPrimitive() || isStruct(classType)) && stars > 0)
            classType = getArrayClassOfClass(classType);
        return array ? getArrayClassOfClass(classType) : classType;
    }

    public static boolean isCBased(Class<?> s) {
        return isStruct(s) || isCReference(s) || isBundle(s);
    }

    public static boolean isAnyReference(Class<?> a) {
        return isStruct(a) || isReference(a) || isBundle(a);
    }

    public static boolean isObjCBased(Class<?> s) {
        return s.getAnnotation(CMClass.class) != null;
    }

    public static boolean isBundle(Class<?> s) {
        return s.getAnnotation(CMBundle.class) != null;
    }

    public static boolean isStruct(Class<?> s) {
        return s.getAnnotation(CMStruct.class) != null;
    }

    public static boolean isReference(Class<?> s) {
        return s.getAnnotation(CMReference.class) != null;
    }

    public static boolean isCReference(Class<?> s) {
        CMReference ref = s.getAnnotation(CMReference.class);
        return ref != null && ref.proxyOf().equals(Object.class);
    }

    public static boolean isObjCReference(Class<?> s) {
        CMReference ref = s.getAnnotation(CMReference.class);
        return ref != null && !ref.proxyOf().equals(Object.class);
    }

    public static boolean isTarget(Class<?> s) {
        return s.getAnnotation(CMTarget.class) != null;
    }

    public static boolean isBlockTarget(Class<?> s) {
        Method lambdaMethod = getLambdaMethod(s);
        return isTarget(s) && lambdaMethod != null && lambdaMethod.getAnnotation(CMBlock.class) != null;
    }

    public static boolean isSelectorTarget(Class<?> s) {
        return isTarget(s) && getLambdaMethod(s).getAnnotation(CMSelector.class) != null;
    }

    public static boolean isProtocol(Class s) {
        return s.isInterface() && isObjCBased(s);
    }

    public static boolean isJavaWrapped(Class s) {
        if (s == null || s.getPackage() == null)
            return false;
        if (s.equals(VoidRef.class))
            return true;
        return s.getPackage().getName().startsWith("java.");
    }

    public static boolean isBlock(Class s) {
        return Runnable.class.isAssignableFrom(s)
                || Block0.class.isAssignableFrom(s)
                || Block1.class.isAssignableFrom(s)
                || Block2.class.isAssignableFrom(s)
                || Block3.class.isAssignableFrom(s)
                || Block4.class.isAssignableFrom(s)
                || Block5.class.isAssignableFrom(s)
                || Block6.class.isAssignableFrom(s)
                || VoidBlock1.class.isAssignableFrom(s)
                || VoidBlock2.class.isAssignableFrom(s)
                || VoidBlock3.class.isAssignableFrom(s)
                || VoidBlock4.class.isAssignableFrom(s)
                || VoidBlock5.class.isAssignableFrom(s)
                || VoidBlock6.class.isAssignableFrom(s);
    }

    public static boolean isSelector(Class<?> cls) {
        return SELclass.equals(cls);
    }

    public static String getObjCTypeRef(Class cls) {
        String base = getClassNameSimple(cls);
        if (isStruct(cls))
            return base;
        else if (isObjCReference(cls))
            return "id";
        else if (isCBased(cls))
            return base + "Ref";
        else
            return base;
    }

    public static boolean isStructReference(Class<?> objcType, Class<?> javaType) {
        if (getArrayDimensions(objcType) == 1 && getArrayDimensions(javaType) == 0) {
            objcType = objcType.getComponentType();
            if (objcType.equals(javaType) && isStruct(objcType))
                return true;
        }
        return false;
    }

    public static boolean isAssignableFrom(Class<?> objcClass, Class<?> javaClass, String locationErrorMessage) {
        if (objcClass.isAssignableFrom(javaClass))
            return true;
        if (objcClass.isPrimitive() && getJavaBoxed(objcClass).isAssignableFrom(javaClass)) // boxed primitives
            return true;
        if (getArrayDimensions(objcClass) > 2) {
            if (locationErrorMessage != null)
                Log.error("Array dimension of native parameter should not exceed 2, caused by: " + locationErrorMessage);
            return false;
        }
        if (getArrayDimensions(javaClass) > 2) {
            if (locationErrorMessage != null)
                Log.error("Array dimension of java parameter should not exceed 2, caused by: " + locationErrorMessage);
            return false;
        }
        while (objcClass.isArray() && javaClass.isArray()) {
            objcClass = objcClass.getComponentType();
            javaClass = javaClass.getComponentType();
        }
        if (objcClass.equals(char[].class) && javaClass.equals(String.class))
            return true;
        if (objcClass.equals(VoidRef.class) && (javaClass.equals(Object.class) || javaClass.equals(byte[].class)))
            return true;
        if (objcClass.equals(SELclass)) {
            String error = testSelectorClass(javaClass);
            if (error != null) {
                if (locationErrorMessage != null)
                    Log.error(error + " Caused by: " + locationErrorMessage);
                return false;
            } else
                return true;
        }
        //With the information given it is impossible to actually check
        if (objcClass.equals(CustomTypeClasses.Instance.class))
            return true;
        if (locationErrorMessage != null)
            Log.error(locationErrorMessage);
        return false;
    }

    public static Class blockType(int inputCount, boolean voidOutput) {
        if (voidOutput)
            switch (inputCount) {
                case 0:
                    return Runnable.class;
                case 1:
                    return VoidBlock1.class;
                case 2:
                    return VoidBlock2.class;
                case 3:
                    return VoidBlock3.class;
                case 4:
                    return VoidBlock4.class;
                case 5:
                    return VoidBlock5.class;
                case 6:
                    return VoidBlock6.class;
            }
        else
            switch (inputCount) {
                case 0:
                    return Block0.class;
                case 1:
                    return Block1.class;
                case 2:
                    return Block2.class;
                case 3:
                    return Block3.class;
                case 4:
                    return Block4.class;
                case 5:
                    return Block5.class;
                case 6:
                    return Block6.class;
            }
        return TypeUnknown.class;
    }

    public static boolean isBlockParameterSupported(NSelector sel) {
        if (sel.getContainer().isProtocol())
            return true;
        for (NParam param : sel.getParams())
            if (isBlockTarget(param.getNType().getType()) || isBlock(param.getNType().getType()))
                return false;
        return true;
    }

    public static String getObjCUnboxed(Class<?> primitiveClass) {
        if (boolean.class.equals(primitiveClass))
            return "Bool";
        else if (long.class.equals(primitiveClass))
            return "LongLong";
        else if (char.class.equals(primitiveClass))
            return "UnsignedShort";
        return capitalize(primitiveClass.getName());
    }

    public static Class getJavaBoxed(Class<?> primitiveClass) {
        if (primitiveClass == null || !primitiveClass.isPrimitive())
            return primitiveClass;
        if (int.class.equals(primitiveClass))
            return Integer.class;
        else if (boolean.class.equals(primitiveClass))
            return Boolean.class;
        else if (byte.class.equals(primitiveClass))
            return Byte.class;
        else if (short.class.equals(primitiveClass))
            return Short.class;
        else if (long.class.equals(primitiveClass))
            return Long.class;
        else if (float.class.equals(primitiveClass))
            return Float.class;
        else if (double.class.equals(primitiveClass))
            return Double.class;
        return primitiveClass;
    }

    public static String getCastingIfNeeded(String nativeType) {
        nativeType = nativeType.replace('*', ' ').trim();
        if (nativeType.endsWith("Ref"))
            nativeType = nativeType.substring(0, nativeType.length() - 3);
        if (needsCasting.contains(nativeType))
            return "(__bridge " + getClassNameSimple(typedef.get(nativeType)) + "*)";
        return "";
    }
}
