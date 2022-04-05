/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.prefs;

public enum LaunchTarget {
    iOS, Swing, Android,

    PACKAGE,

    Netbeans, IntelliJ_IDEA, VS_Code, Android_Studio, Xcode, VStudio;

    private final String tname;

    LaunchTarget() {
        tname = name().toLowerCase();
    }

    public static LaunchTarget find(String target) {
        if (target != null) {
            target = target.toLowerCase();
            for (LaunchTarget candidate : LaunchTarget.values())
                if (target.equals(candidate.tname()))
                    return candidate;
        }
        return Swing;
    }

    public static boolean profilesSupportDebugging(String profiles) {
        return profiles != null && profiles.contains(Swing.tname());
    }

    public String tname() {
        return tname;
    }

    public String prettyName() {
        return name().replace('_', ' ');
    }
}
