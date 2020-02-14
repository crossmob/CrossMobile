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

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.utils.ReflectionUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ObjectRegistry {

    public static final String NSObjectClassName = "crossmobile.ios.foundation.NSObject";
    public static final String CFTypeClassName = "crossmobile.ios.foundation.CFType";
    public static final String UIAppearanceClassName = "crossmobile.ios.uikit.UIAppearance";
    private static final Map<Class, NObject> objects = new TreeMap<>(Comparator.comparing(Class::getName));
    private static Class<?> NSObjectClass;
    private static Class<?> UIAppearanceClass;
    private static Class<?> CFTypeClass;

    public static void register(NObject nobj) {
        objects.put(nobj.getType(), nobj);
    }

    public static NObject retrieve(Class objClass) {
        return objClass == null ? null : objects.get(objClass);
    }

    public static Iterable<NObject> retrieveAll() {
        return objects.values();
    }

    public static Class<?> getNSObject() {
        return NSObjectClass = getClassNamed(NSObjectClass, NSObjectClassName);
    }

    public static Class<?> getCFType() {
        return CFTypeClass = getClassNamed(CFTypeClass, CFTypeClassName);
    }

    public static boolean isUIAppearanceClass(Class<?> classToCheck) {
        return (UIAppearanceClass = getClassNamed(UIAppearanceClass, UIAppearanceClassName)).isAssignableFrom(classToCheck);
    }

    public static boolean contains(String className) {
        for (Class aClass : objects.keySet())
            if (aClass.getName().equals(className))
                return true;
        return false;
    }

    private static Class<?> getClassNamed(Class<?> cached, String className) {
        if (cached == null && (cached = ReflectionUtils.getClassForName(className)) == null)
            throw new RuntimeException("Unable to locate class " + className + " in classpath");
        return cached;
    }
}
