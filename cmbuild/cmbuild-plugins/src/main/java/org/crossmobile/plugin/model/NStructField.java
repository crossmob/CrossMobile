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
package org.crossmobile.plugin.model;

import org.crossmobile.bridge.ann.CMStruct;
import org.crossmobile.utils.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import static org.crossmobile.utils.NamingUtils.*;
import static org.crossmobile.utils.TextUtils.capitalize;

public class NStructField {
    public final String name;
    public final String objc_name;
    public final Class<?> type;
    public final Method getter;
    public final Method setter;
    public final int index;

    private NStructField(String name, Class<?> type, Method getter, Method setter, int index) {
        this.name = name;
        this.type = type;
        this.getter = getter;
        this.setter = setter;
        this.objc_name = name + "_" + toObjC(type);
        this.index = index;
    }

    public static Collection<NStructField> find(Class<?> host) {
        CMStruct ann = host.getAnnotation(CMStruct.class);
        if (ann == null)
            return null;
        Collection<NStructField> result = new ArrayList<>();
        int idx = 0;
        for (String fieldName : ann.value()) {
            String capitalized = capitalize(fieldName);
            try {
                Method get = host.getMethod("get" + capitalized);
                Class<?> fieldType = get.getReturnType();
                Method set = host.getMethod("set" + capitalized, get.getReturnType());
                result.add(new NStructField(fieldName, fieldType, get, set, idx));
                idx++;
            } catch (NoSuchMethodException e) {
                Log.error("Unable to properly initialize struct member " + fieldName + " in class " + getClassNameFull(host));
            }
        }
        return result;
    }

    public static Class<?> findType(Class<?> host, String fieldName) {
        try {
            Method method = host.getMethod("get" + capitalize(fieldName));
            return method == null ? null : method.getReturnType();
        } catch (Exception e) {
            return null;
        }
    }
}
