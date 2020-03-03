// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

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
