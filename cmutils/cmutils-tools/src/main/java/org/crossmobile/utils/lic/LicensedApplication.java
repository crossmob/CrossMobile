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

import java.util.Collection;
import java.util.TreeSet;

public class LicensedApplication implements Comparable<LicensedApplication>{

    public final String appId;
    private final Collection<LicensedArtifact> artifacts = new TreeSet<>();

    public LicensedApplication(String appId) {
        this.appId = appId;
    }

    public void addArtifact(LicensedArtifact artifact) {
        artifacts.add(artifact);
    }

    public boolean matches(String id, String dependency, Flavour flavour) {
        if ("*".equals(this.appId) || this.appId.equals(id))
            for (LicensedArtifact art : artifacts)
                if (art.matches(dependency, flavour))
                    return true;
        return false;
    }

    public Iterable<LicensedArtifact> getArtifacts() {
        return artifacts;
    }

    @Override
    public int compareTo(LicensedApplication o) {
        return appId.compareTo(o.appId);
    }
}
