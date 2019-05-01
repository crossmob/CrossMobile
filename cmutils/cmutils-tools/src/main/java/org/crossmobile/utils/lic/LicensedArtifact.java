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

import org.crossmobile.utils.Dependency;
import org.crossmobile.utils.launcher.Flavour;

public class LicensedArtifact implements Comparable<LicensedArtifact> {

    public final String name;
    public final boolean android;
    public final boolean ios;
    public final boolean desktop;
    private final String displayName;

    public LicensedArtifact(String name, boolean ios, boolean android, boolean desktop) {
        this.name = name;
        this.ios = ios;
        this.android = android;
        this.desktop = desktop;
        Dependency dep = Dependency.findSystemDependency(null, name);
        displayName = dep == null ? null : dep.name;
    }

    public boolean matches(String dependency, Flavour flavour) {
        return name.equals(dependency)
                && (flavour != Flavour.ANDROID || android)
                && (flavour != Flavour.IOS || ios)
                && (flavour != Flavour.DESKTOP || desktop);
    }

    @Override
    public int compareTo(LicensedArtifact o) {
        return getDisplayName().compareTo(o.getDisplayName());
    }

    public String getDisplayName() {
        return displayName == null ? name : displayName;
    }
}
