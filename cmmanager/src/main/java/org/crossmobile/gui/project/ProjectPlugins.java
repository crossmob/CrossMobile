/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.gui.project;

import org.crossmobile.gui.parameters.MultiEntryParameter.SingleEntry;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.gui.utils.Paths.HomeReference;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.ParamList;

import java.io.File;
import java.util.*;

public class ProjectPlugins {

    private static final String CLASSPATH_KEY = "javac.classpath";
    private final Set<PluginEntry> plugins = new TreeSet<>();

    public ProjectPlugins(ParamList params) {
        updatePluginReferences(params.dereferenceProperty(CLASSPATH_KEY));
    }

    private void updatePluginReferences(String classpath) {
        if (classpath == null)  // For new projects
            return;
        List<String> list = FileUtils.getFileItemList(classpath);
        for (String item : list)
            if (!item.endsWith("cmioslayer.jar")
                    && !item.endsWith("android.jar")
                    && !item.endsWith("google-play-services.jar")
                    && !item.endsWith("android-support-v4.jar"))
                addPlugin(Paths.getPath(item, HomeReference.PROPERTY_STYLE));
    }

    public PluginEntry addPlugin(String filename) {
        PluginEntry entry = new PluginEntry(filename);
        return plugins.add(entry) ? entry : null;
    }

    public void removePlugin(PluginEntry plugin) {
        plugins.remove(plugin);
    }

    public static final class PluginEntry extends SingleEntry implements Comparable<PluginEntry> {

        public final String pathName;
        public final File path;

        private PluginEntry(String path) {
            int lastSlash = path.lastIndexOf("/");
            setValue(lastSlash >= 0 ? path.substring(lastSlash + 1) : path);
            this.pathName = path;
            this.path = new File(pathName);
        }

        @Override
        public String getVisualTag() {
            return path.getName() + "  [" + Paths.getPathSimple(path.getParentFile()) + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PluginEntry))
                return false;
            final PluginEntry other = (PluginEntry) obj;
            return Objects.equals(this.path, other.path);
        }

        @Override
        public int hashCode() {
            return 115 + (this.path != null ? this.path.hashCode() : 0);
        }

        @Override
        public int compareTo(PluginEntry o) {
            int res = getValue().compareTo(o.getValue());
            if (res == 0)
                res = this.pathName.compareTo(o.pathName);
            return res;
        }
    }
}
