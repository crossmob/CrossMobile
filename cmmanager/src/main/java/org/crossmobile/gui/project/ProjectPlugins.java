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
package org.crossmobile.gui.project;

import org.crossmobile.gui.parameters.MultiEntryParameter.SingleEntry;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.gui.utils.Paths.HomeReference;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.ParamList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public List<PluginEntry> getPlugins() {
        return new ArrayList<>(plugins);
    }

    public String getAbsolutePaths() {
        StringBuilder out = new StringBuilder();
        for (PluginEntry entry : plugins)
            out.append(Paths.getPath(entry.pathName, HomeReference.PROP_TO_ABS)).append(File.pathSeparator);
        return out.length() > 0 ? out.toString().substring(0, out.length() - File.pathSeparator.length()) : "";
    }

    public static final class PluginEntry extends SingleEntry implements Comparable<PluginEntry> {

        private final String pathName;
        private final File path;
        int id = 1;

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
            if (obj == null || !(obj instanceof PluginEntry))
                return false;
            final PluginEntry other = (PluginEntry) obj;
            return this.path == other.path || (this.path != null && this.path.equals(other.path));
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
