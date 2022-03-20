/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /*
 * Based on ideas found here:
 * http://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime
 */
public class GenericsUtils {

    public static Class typeDigging(Type givenType) {
        if (givenType instanceof Class)
            return (Class) givenType;
        else if (givenType instanceof ParameterizedType)
            for (Type ptype : ((ParameterizedType) givenType).getActualTypeArguments()) {
                Class deeperType = typeDigging(ptype);
                if (deeperType != null)
                    return deeperType;
            }
        else if (givenType instanceof TypeVariable)
            for (AnnotatedType antype : ((TypeVariable) givenType).getAnnotatedBounds()) {
                Class deeperType = typeDigging(antype.getType());
                if (deeperType != null)
                    return deeperType;
            }
        else
            Log.error("Not supported Type: " + givenType.getClass().getName());
        return null;
    }

    public static Class getTypeArgument(Type type) {
        if (!(type instanceof ParameterizedType))
            return null;
        return typeDigging(type);
    }

    public static Class getTypeArgument(Field field) {
        return getTypeArgument(field.getGenericType());
    }

    public static Class getTypeArgument(Parameter param) {
        return getTypeArgument(param.getParameterizedType());
    }

    public static Class<?> getClass(Type type) {
        if (type instanceof Class)
            return (Class) type;
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

    public static <T> Class<?> getTypeArgument(Class<T> baseClass, Class<? extends T> childClass, int index) {
        List<Class<?>> typeArguments = getTypeArguments(baseClass, childClass);
        return typeArguments == null || typeArguments.isEmpty() || Object.class.equals(typeArguments.get(index)) ? null : typeArguments.get(index);
    }

    /**
     * Get the actual type arguments a child class has used to extend a generic
     * base class.
     *
     * @param <T>        The class type of the base class
     * @param baseClass  the base class
     * @param childClass the child class
     * @return a list of the raw classes for the actual type arguments.
     */
    public static <T> List<Class<?>> getTypeArguments(Class<T> baseClass, Class<? extends T> childClass) {
        Map<Type, Type> resolvedTypes = new HashMap<>();
        Type type = childClass;
        // start walking up the inheritance hierarchy until we hit baseClass
        while (!getClass(type).equals(baseClass))
            if (type instanceof Class)
                // there is no useful information for us in raw types, so just keep going.
                type = ((Class) type).getGenericSuperclass();
            else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<?> rawType = (Class) parameterizedType.getRawType();

                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++)
                    resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);

                if (!rawType.equals(baseClass))
                    type = rawType.getGenericSuperclass();
            }

        // finally, for each actual type argument provided to baseClass, determine (if possible)
        // the raw class for that type argument.
        Type[] actualTypeArguments;
        if (type instanceof Class)
            actualTypeArguments = ((Class) type).getTypeParameters();
        else
            actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        List<Class<?>> typeArgumentsAsClasses = new ArrayList<>();
        // resolve types by chasing down type variables.
        for (Type baseType : actualTypeArguments) {
            while (resolvedTypes.containsKey(baseType))
                baseType = resolvedTypes.get(baseType);
            typeArgumentsAsClasses.add(getClass(baseType));
        }
        return typeArgumentsAsClasses;
    }

}
