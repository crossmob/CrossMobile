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
package org.crossmobile.plugin.actions;

import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.bridge.ann.CMLibTarget.BaseTarget;
import org.crossmobile.plugin.reg.PackageRegistry;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.reg.TargetRegistry;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.function.Function;

import static org.crossmobile.utils.FileUtils.copy;

public class CreateBundles {

    public static final BundleResolver bundleResolver = (filename, packg) -> {
        if (filename.endsWith(".class")) {
            String clsname = filename.substring(0, filename.length() - 6);
            int dollar = clsname.indexOf('$');
            if (dollar > 0)
                clsname = clsname.substring(0, dollar);
            if (clsname.isEmpty())
                return new PluginAndTarget(PackageRegistry.getPlugin(packg), PackageRegistry.getTarget(packg));
            else {
                clsname = packageToJavaPackage(packg) + clsname;
                return new PluginAndTarget(PluginRegistry.getPlugin(clsname), TargetRegistry.getTarget(clsname));
            }
        } else
            return new PluginAndTarget(PackageRegistry.getPlugin(packg), PackageRegistry.getTarget(packg));
    };

    public static final BundleResolver noClassResolver = (filename, packg) -> new PluginAndTarget(PackageRegistry.getPlugin(packg),
            filename.endsWith(".class") ? CMLibTarget.SOURCEONLY : PackageRegistry.getTarget(packg));

    public static void bundleFiles(File source, Function<String, File> filedest, BundleResolver resolver, BaseTarget filter) {
        bundleFiles(source, filedest, resolver, filter, false);
    }

    public static void bundleFiles(File source, Function<String, File> filedest, BundleResolver resolver, BaseTarget filter, final boolean shouldInform) {
        bundleFiles(source, filedest, resolver, filter, shouldInform, "", true);
    }

    private static void bundleFiles(File source, Function<String, File> filedest, BundleResolver resolver, BaseTarget filter, final boolean shouldInform, String packg, boolean is_root) {
        if (source.isDirectory()) {
            File[] children = source.listFiles();
            if (children != null && children.length > 0)
                for (File child : children)
                    bundleFiles(child, filedest, resolver, filter, shouldInform, packageToJavaPackage(packg) + (is_root ? "" : source.getName()), false);
        } else if (source.isFile()) {
            PluginAndTarget pt = resolver.resolve(source.getName(), packg);
            if (pt.target == CMLibTarget.UNKNOWN && shouldInform)
                Log.warning("Unable to match file " + source.getAbsolutePath());
            if (pt.target.matches(filter))
                copy(source, getOutput(filedest.apply(pt.plugin), packg, source.getName()));
        }
    }

    private static String packageToJavaPackage(String packg) {
        return packg + (packg.isEmpty() ? "" : ".");
    }

    private static File getOutput(File root, String pkg, String filename) {
        return new File(root, pkg.replace('.', File.separatorChar) + File.separator + filename);
    }

    public interface BundleResolver {

        PluginAndTarget resolve(String filename, String packg);
    }

    public static class PluginAndTarget {

        public final String plugin;
        public final CMLibTarget target;

        public PluginAndTarget(String plugin, CMLibTarget target) {
            this.plugin = plugin;
            this.target = target;
        }
    }
}
