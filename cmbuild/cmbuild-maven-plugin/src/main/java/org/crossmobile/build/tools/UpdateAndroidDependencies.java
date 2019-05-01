/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, getVersion 2.
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
package org.crossmobile.build.tools;

import org.crossmobile.build.utils.Templates;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.PluginMetaData;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.crossmobile.utils.TextUtils.NL;

public class UpdateAndroidDependencies {

    private static final Set<String> blackList = new HashSet<>(Arrays.asList("cmtheme-", "cmbuild-annproc"));

    public static void execute(File crossmobileGradle, String appId, DependencyItem root) {
        StringBuilder deplist = new StringBuilder();
        apply(root.getPluginMetaData(), deplist);
        apply(root.getCompileOnlyDependencies(false), "compileOnly", deplist);
        apply(root.getCompileAndRuntimeDependencies(false), "implementation", deplist);
        apply(root.getRuntimeOnlyDependencies(false), "runtimeOnly", deplist);
        Log.debug("Android defined plugins:");
        Log.debug(deplist.toString());
        //write String to gradle file
        FileUtils.write(crossmobileGradle, Templates.CROSSMOBILE_GRADLE
                .replace(Templates.APPLICATION_ID, appId)
                .replace(Templates.DEPENDENCIES, deplist.toString()));
    }

    private static void apply(Iterable<PluginMetaData> infos, StringBuilder deplist) {
        infos.forEach(info -> {
            info.getAndroidExtraDependencies().forEach(dep -> {
                String[] parts = dep.split(":");
                add("implementation", parts[0], parts[1], parts[2], parts.length > 3 ? parts[3] : "jar", deplist);
            });
        });
    }

    private static void apply(Iterable<DependencyItem> deps, String scope, StringBuilder out) {
        for (DependencyItem item : deps)
            if (!isBlacklisted(item.getArtifactID()))
                if (item.getType().contains("jar"))
                    add(scope, item.getGroupID(), item.getArtifactID(), item.getVersion(), item.getType(), out);
    }

    private static boolean isBlacklisted(String artifactID) {
        for (String item : blackList)
            if (artifactID.startsWith(item))
                return true;
        return false;
    }

    private static void add(String scope, String groupId, String artifactId, String version, String type, StringBuilder out) {
        out.append("    ").append(scope).append(" '").
                append(groupId).append(":").append(artifactId).append(":").append(version).
                append("jar".equals(type) ? "" : "@" + type).
                append('\'').append(NL);
    }

}
