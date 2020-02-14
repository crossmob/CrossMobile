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
package org.crossmobile.build.tools;

import org.crossmobile.utils.JarUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;

public class CopyLibClasses {

    public static final String PLUGIN_SIGNATURE = "cmplugin-";
    public static final String THEME_SIGNATURE = "cmtheme-";
    public static final String ANNOTATION_SIGNATURE = "cmbuild-annproc";

    public static void exec(File classesDir, DependencyItem root) {
        for (DependencyItem dep : root.getRuntimeDependencies(true)) {
            String artifact = dep.getArtifactID();
            if (!artifact.startsWith(PLUGIN_SIGNATURE) && !artifact.startsWith(THEME_SIGNATURE) && !artifact.equals(ANNOTATION_SIGNATURE)) {
                File plugin = dep.getFile();
                if (plugin.isFile()) {
                    Log.debug("Extracting dependency " + plugin.getAbsolutePath());
                    JarUtils.unzipJar(plugin, classesDir, (entry, file) -> !file.exists() || file.lastModified() < entry.getTime());  // Extract only newer files; can't do it yet since retrolambda deletes everything
                } else
                    Log.warning("Dependency not supported: " + plugin.getAbsolutePath());
            }
        }
    }

}
