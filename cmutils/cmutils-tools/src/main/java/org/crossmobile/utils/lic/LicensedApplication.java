// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

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
