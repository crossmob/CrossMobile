/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;

import static org.crossmobile.utils.ReflectionUtils.getBareClass;

public class NamingUtils {

    public static String getClassNameFull(CtClass cls) {
        StringBuilder array = new StringBuilder();
        try {
            while (cls.isArray()) {
                array.append("[]");
                cls = cls.getComponentType();
            }
        } catch (NotFoundException ex) {
        }
        return cls == null ? null : cls.getName() + array.toString();
    }

    public static String getClassNameFull(Class cls) {
        StringBuilder array = new StringBuilder();
        while (cls.isArray()) {
            array.append("[]");
            cls = cls.getComponentType();
        }
        return cls.getName() + array.toString();
    }

    public static String getClassNameSimple(Class cls) {
        String name = getBareClass(cls).getName();
        int dot = name.lastIndexOf('.');
        return dot >= 0 ? name.substring(dot + 1) : name;
    }

    public static String execSignature(Executable exec) {
        return execSignature(exec, true);
    }

    public static String execSignature(Executable exec, boolean fullname) {
        StringBuilder out = new StringBuilder();
        if (fullname)
            out.append(getBareClass(exec.getDeclaringClass()).getName()).append(".");
        if (Constructor.class.isAssignableFrom(exec.getClass()))
            out.append(getClassNameSimple(exec.getDeclaringClass()));
        else
            out.append(exec.getName());
        out.append("(");
        Class<?>[] types = exec.getParameterTypes();
        for (int i = 0; i < types.length; i++) {
            if (i != 0)
                out.append(",");
            out.append(getClassNameFull(types[i]));
        }
        out.append(")");
        return out.toString();
    }

    public static String execSignature(CtMethod exec) {
        try {
            StringBuilder out = new StringBuilder();
            out.append(exec.getName());
            out.append("(");
            CtClass[] types = exec.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                if (i != 0)
                    out.append(",");
                String classname = getClassNameFull(types[i]);
                if (classname == null)
                    return null;
                out.append(classname);
            }
            out.append(")");
            return out.toString();
        } catch (NotFoundException ex) {
            return "";
        }
    }

    public static String getPackageName(String clsname) {
        if (clsname == null)
            return null;
        int lastDot = clsname.lastIndexOf('.');
        return lastDot > 0 ? clsname.substring(0, lastDot) : "";
    }

    public static String toObjC(String javaName) {
        return javaName.replace('.', '_').replaceAll("\\[\\]", "_ARRAYTYPE");
    }

    public static String toObjC(Class<?> cls) {
        return toObjC(getBareClass(cls).getName());
    }
}
