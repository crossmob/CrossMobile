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
package org.crossmobile.plugin.utils;

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.reg.TypeRegistry;
import org.crossmobile.plugin.reg.TypeUnknown;
import org.crossmobile.utils.CustomTypeClasses;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.*;

import static org.crossmobile.utils.CollectionUtils.forEach;
import static org.crossmobile.utils.NamingUtils.*;
import static org.crossmobile.utils.TextUtils.capitalize;

public class Texters {

    public static void outProtocols(Streamer out, Collection<NObject> parentProtocols) throws IOException {
        out.append("<");
        forEach(parentProtocols).onTail(p -> out.append(",")).onAny(p -> out.append(toObjC(p.getType()))).go();
        out.append(">");
    }

    public static String toObjCType(Class<?> type) {
        if (type.isArray())
            return "XMLVMArray*";
        if (type.isPrimitive())
            if (boolean.class.equals(type))
                return "BOOL";
            else if (long.class.equals(type))
                return "JAVA_LONG";
        if (type.equals(Object.class))
            return "id";
        if (type.equals(String.class))
            return "NSString*";
        if (type.equals(List.class))
            return "NSArray*";
        if (type.equals(Set.class))
            return "NSSet*";
        if (type.equals(Map.class))
            return "NSDictionary*";
        if (type.equals(CustomTypeClasses.VoidRef.class))
            return "void*";
        String typeName = TypeRegistry.isObjCBased(type) ? toObjC(getClassNameSimple(type)) : toObjC(type);
        if (type.isInterface())
            typeName = "id<" + typeName + ">";
        else if (!type.isPrimitive())
            typeName += "*";
        return typeName;
    }

    public static String toObjCTypeForLibDef(Class<?> type) {
        if (type.isArray())
            return "XMLVMArray*";
        if (type.isPrimitive())
            if (boolean.class.equals(type))
                return "BOOL";
            else if (long.class.equals(type))
                return "JAVA_LONG";
        if (type.equals(Object.class))
            return "id";
        if (type.equals(String.class))
            return "NSString*";
        if (type.equals(List.class))
            return "NSArray*";
        if (type.equals(Set.class))
            return "NSSet*";
        if (type.equals(Map.class))
            return "NSDictionary*";
        String typeName = toObjC(type);
        return typeName;
    }

    public static String annName(Class<? extends Annotation> ann) {
        return "@" + getClassNameSimple(ann);
    }

    public static String typesafeClassName(Class cls) {
        return cls.equals(TypeUnknown.class) ? "<unknown>" : getClassNameFull(cls);
    }

    public static String methodObjCName(Executable m) {
        StringBuilder out = new StringBuilder();
        if (m instanceof Constructor)
            out.append("__init_").append(toObjC(m.getDeclaringClass()));
        else
            out.append(m.getName());
        out.append("__");
        Parameter[] params = m.getParameters();
        for (Parameter p : params)
            out.append("_").append(toObjC(getClassNameFull(p.getType())));
        return out.toString();
    }

    public static String selectorSignature(NSelector sel) {
        StringBuilder out = new StringBuilder(sel.getName());
        for (NParam param : sel.getParams())
            out.append(param.getName()).append(":");
        return out.toString();
    }

    public static String paramHash(NSelector sel) {
        StringBuilder out = new StringBuilder();
        for (NParam param : sel.getParams())
            out.append("|").append(getClassNameFull(param.getNType().getType()));
        return out.toString();
    }

    public static List<String> getNameParts(NSelector sel) {
        List<String> parts = new ArrayList<>();
        parts.add(sel.getName());
        for (NParam param : sel.getParams())
            if (!param.getName().isEmpty())
                if (param.isTransferName())
                    parts.set(parts.size() - 1, parts.get(parts.size() - 1) + capitalize(param.getName()));
                else
                    parts.add(param.getName());
        return parts;
    }

    public static String lastPackage(String packageName) {
        int where = packageName.lastIndexOf('.');
        return where >= 0 ? packageName.substring(where + 1) : packageName;
    }

    public static String getMetaClassNameReference(NObject obj) {
        return getClassNameSimple(obj.getType()) + "Meta$CMCache";
    }

    public static String getClassNameReference(NObject obj) {
        return getClassNameSimple(obj.getType()) + "Meta$CMCache";
    }

    public static String getSelectorSignature(NSelector selector) {
        return execSignature(selector.getJavaExecutable(), false);
    }
}
