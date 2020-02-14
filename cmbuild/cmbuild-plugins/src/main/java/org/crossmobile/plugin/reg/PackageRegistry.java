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
import org.crossmobile.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

import static org.crossmobile.bridge.ann.CMLibTarget.UNKNOWN;

public class PackageRegistry {

    private static final Map<String, PackageDefaults> registry = new HashMap<>();

    public static void register(Package pkg) {
        register(pkg, true);
    }

    public static void registerDependencies(Package pkg) {
        register(pkg, false);
    }

    private static void register(Package pkg, boolean requireAllInfo) {
        String pkgName = pkg.getName();
        PackageDefaults def = registry.get(pkgName);
        if (def == null) {
            String pluginName = "";
            CMLibTarget target = UNKNOWN;
            while (pkg != null) {
                pkg = ReflectionUtils.findPackage(pkg, CMLib.class);
                if (pkg != null) {
                    CMLib ann = pkg.getAnnotation(CMLib.class);
                    if (ann != null) {
                        if (pluginName.isEmpty())
                            pluginName = ann.name();
                        if (target == UNKNOWN)
                            target = ann.target();
                    }
                    if (!pluginName.isEmpty() && target != UNKNOWN)
                        pkg = null;
                    else
                        pkg = ReflectionUtils.getParentPackage(pkg);
                }
            }

            if (pluginName.isEmpty() && target == UNKNOWN) {
                if (requireAllInfo)
                    Log.error("Unable to locate default plugin and target for package " + pkgName);
            } else {
                if (target == UNKNOWN)
                    Log.error("Unable to locate default target for package " + pkgName);
                else if (pluginName.isEmpty())
                    Log.error("Unable to locate default plugin for package " + pkgName);
            }
            registry.put(pkgName, new PackageDefaults(pluginName, target));
        }
    }

    public static void register(String pkgName, String pluginName, String target) {
        if (pkgName == null || pkgName.trim().isEmpty()) {
            Log.error("Package name is a required field");
            return;
        }
        if (pluginName == null || pluginName.trim().isEmpty()) {
            Log.error("Plugin is a required field");
            return;
        }
        if (target == null || target.trim().isEmpty()) {
            Log.error("Target is a required field");
            return;
        }
        CMLibTarget libtargt;
        try {
            libtargt = CMLibTarget.valueOf(target.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            Log.error("Unknown target: " + target);
            return;
        }
        if (!PluginRegistry.pluginExists(pluginName)) {
            Log.error("Plugin " + pluginName + " is not defined");
            return;
        }
        if (registry.containsKey(pkgName)) {
            Log.error("Package " + pkgName + " already defined");
            return;
        }
        registry.put(pkgName, new PackageDefaults(pluginName, libtargt));
    }

    public static String getPlugin(String pkg) {
        PackageDefaults defs = getPackageDefaults(pkg);
        return defs == null ? "" : defs.plugin;
    }

    public static CMLibTarget getTarget(String pkg) {
        PackageDefaults defs = getPackageDefaults(pkg);
        return defs == null ? UNKNOWN : defs.target;
    }

    private static PackageDefaults getPackageDefaults(String pkg) {
        while (pkg != null) {
            PackageDefaults defs = registry.get(pkg);
            if (defs != null)
                return defs;
            if (pkg.isEmpty())
                pkg = null;
            else {
                int dot = pkg.lastIndexOf('.');
                if (dot >= 0)
                    pkg = pkg.substring(0, dot);
                else
                    pkg = "";
            }
        }
        return null;
    }
}
