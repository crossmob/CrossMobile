/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.utils;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;

public class NamingUtils {

    public static String getClassNameBare(Class cls) {
        while (cls.isArray())
            cls = cls.getComponentType();
        return cls.getName();
    }

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
        String name = getClassNameBare(cls);
        int dot = name.lastIndexOf('.');
        return dot >= 0 ? name.substring(dot + 1) : name;
    }

    public static String execSignature(Executable exec) {
        return execSignature(exec, true);
    }

    public static String execSignature(Executable exec, boolean fullname) {
        StringBuilder out = new StringBuilder();
        if (fullname)
            out.append(getClassNameBare(exec.getDeclaringClass())).append(".");
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
}
