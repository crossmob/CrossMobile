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
package org.crossmobile.utils.lic;

import org.crossmobile.utils.launcher.Flavour;
import org.crossmobile.utils.plugin.DependencyItem;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import static org.crossmobile.utils.Dependency.findSystemDependency;
import static org.crossmobile.utils.lic.LicenseManager.getRegistered;

public class LicencedItems {

    public static void checkLicense(DependencyItem root, String appid, Flavour flavour) {
        Collection<LicensedApplication> licensed = getRegistered();
        Collection<String> unlicensed = new TreeSet<>();
        cleanup(licensed, unlicensed, appid, flavour, root.getCompiletimeDependencies(true).iterator());
        cleanup(licensed, unlicensed, appid, flavour, root.getRuntimeDependencies(true).iterator());

        if (!unlicensed.isEmpty()) {
            StringBuilder out = new StringBuilder();
            out.append("Due to licensing, these dependencies cannot be resolved:");
            for (String artifactId : unlicensed)
                out.append(" '").append(findSystemDependency(null, artifactId)).append("',");
            throw new RuntimeException(out.toString().substring(0, out.length() - 1));
        }
    }

    private static void cleanup(Collection<LicensedApplication> licensed, Collection<String> unlicensed, String appId, Flavour flavour, Iterator<DependencyItem> ct) {
        while (ct.hasNext()) {
            String artifact = ct.next().getArtifactID();
            if (artifact.startsWith("cmplugin-cm") && !artifact.equals("cmplugin-cmioslayer")) {
                boolean match = false;
                for (LicensedApplication lid : licensed)
                    if (lid.matches(appId, artifact, flavour)) {
                        match = true;
                        break;
                    }
                if (!match)
                    unlicensed.add(artifact);
            }
        }
    }
}
