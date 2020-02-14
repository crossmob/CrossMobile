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

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.NamingUtils;
import org.crossmobile.utils.ReflectionUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class TargetRegistry {

    private static final Map<String, CMLibTarget> targets = new LinkedHashMap<>();

    public static CMLibTarget register(Class<?> cls) {
        String name = cls.getName();
        CMLibTarget target;
        CMLib library = cls.getAnnotation(CMLib.class);
        if (library != null && library.target() != CMLibTarget.UNKNOWN)
            target = library.target();
        else {
            cls = ReflectionUtils.getTopClass(cls);
            library = cls.getAnnotation(CMLib.class);
            if (library != null && library.target() != CMLibTarget.UNKNOWN)
                target = library.target();
            else
                target = PackageRegistry.getTarget(cls.getPackage().getName());
        }
        if (target == CMLibTarget.UNKNOWN)
            Log.error("Unable to locate target of class " + name);
        targets.put(name, target);
        return target;
    }

    public static CMLibTarget getTarget(String cls) {
        return getTarget(cls, false);
    }

    public static CMLibTarget getTarget(String cls, boolean silently) {
        CMLibTarget target = targets.get(cls);
        if (target != null)
            return target;
        target = PackageRegistry.getTarget(NamingUtils.getPackageName(cls));
        if (target != null)
            return target;
        if (!silently)
            Log.error("Unable to locate registered target of class " + cls);
        return null;
    }
}
