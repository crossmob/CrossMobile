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
package org.crossmobile.gui.utils;

public enum Profile {
    DEBUG, XRAY(Paths.getXRayPath() != null), RELEASE, OBFUSCATE;
    private boolean valid;

    Profile() {
        this(true);
    }

    Profile(boolean valid) {
        this.valid = valid;
    }

    public static Profile safeValueOf(String launchType) {
        if (launchType == null)
            return null;
        launchType = launchType.toUpperCase();
        try {
            return Profile.valueOf(launchType);
        } catch (IllegalArgumentException e) {
            return DEBUG;
        }
    }

    public boolean isRelease() {
        return this == RELEASE || this == OBFUSCATE;
    }

    public boolean isDebug() {
        return this == DEBUG || this == XRAY;
    }

    public boolean isValid() {
        return valid;
    }
}
