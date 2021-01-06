/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

@CMLib(target = CMLibTarget.APIJAVA)
public enum CMLibTarget {
    /**
     * Elements only to appear in source code. Will disappear from all
     * libraries, compile and runtime.
     */
    SOURCEONLY(false, false, false, false, false, false, false),
    /**
     * Elements used only at compile time. Will disappear in all runtime
     * libraries.
     */
    BUILDONLY(true, false, false, false, false, false, false),
    /**
     * Runtime elements specific for Desktop
     */
    DESKTOP(false, true, false, false, false, false, false),
    /**
     * Runtime elements specific for Android
     */
    ANDROID(false, false, true, false, false, false, false),
    /**
     * Java runtime elements, specific for iOS. Does not define native bindings.
     * Not present at compile time.
     */
    IOS(false, false, false, true, false, false, false),
    /**
     * Runtime elements specific for UWL
     */
    UWP(false, false, false, false, false, true, false),
    /**
     * Runtime elements specific for Desktop
     */
    API_NOUWP(true, true, true, true, true, true, false),
    /**
     * Used in Java based targets only.
     */
    JAVA(false, true, true, false, false, false, false),
    /**
     * Defines the CrossMobile API. Is used for native bindings.
     */
    API(true, true, true, true, true, true, true),
    /**
     * Part of the CrossMobile API. Is not used for native elements and do not
     * create plugins.
     */
    APIJAVA(true, true, true, true, false, true, false),
    /**
     * Elements appear in all runtime environments, but not part of the API.
     */
    RUNTIME(false, true, true, true, false, true, false),
    /**
     * Unknown target, default target for elements. Will launch a warning if an
     * element with this target is found.
     */
    UNKNOWN(false, false, false, false, false, false, false);

    public final boolean compile, desktop, android, iosjava, iosnative, uwpjava, uwpnative;

    CMLibTarget(boolean compile, boolean desktop, boolean android, boolean iosjava, boolean iosnative, boolean uwpjava, boolean uwpnative) {
        this.compile = compile;
        this.desktop = desktop;
        this.android = android;
        this.iosjava = iosjava;
        this.iosnative = iosnative;
        this.uwpjava = uwpjava;
        this.uwpnative = uwpnative;
    }

    public boolean matches(BaseTarget filter) {
        switch (filter) {
            case ALL:
                return true;
            case DESKTOP:
                return desktop;
            case ANDROID:
                return android;
            case IOS:
                return iosjava;
            case UWP:
                return uwpjava;
            case COMPILE:
                return compile;
        }
        return false;
    }

    public enum BaseTarget {
        DESKTOP, ANDROID, IOS, UWP, COMPILE, ALL
    }

    public String listTargets() {
        StringBuilder targets = new StringBuilder();
        if (compile)
            targets.append(",compile");
        if (desktop)
            targets.append(",desktop");
        if (android)
            targets.append(",android");
        if (iosjava)
            targets.append(",iosjava");
        if (iosnative)
            targets.append(",iosnative");
        if (uwpjava)
            targets.append(",uwpjava");
        if (uwpnative)
            targets.append(",uwpnative");
        return targets.length() > 0 ? targets.substring(1) : "";
    }
}
