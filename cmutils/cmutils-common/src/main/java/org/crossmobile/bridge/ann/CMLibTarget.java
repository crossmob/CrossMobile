/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.bridge.ann;

@CMLib(target = CMLibTarget.APIJAVA)
public enum CMLibTarget {
    /**
     * Elements only to appear in source code. Will disappear from all
     * libraries, compile and runtime.
     */
    SOURCEONLY(false, false, false, false, false, false, false, false),
    /**
     * Elements used only at compile time. Will disappear in all runtime
     * libraries.
     */
    BUILDONLY(true, false, false, false, false, false, false, false),
    /**
     * Runtime elements specific for Desktop
     */
    DESKTOP(false, true, false, false, false, false, false, false),
    /**
     * Runtime elements specific for Android
     */
    ANDROID(false, false, true, false, false, false, false, false),
    /**
     * Runtime elements specific for Android, that are also required in plugins
     */
    ANDROID_PLUGIN(false, false, true, false, false, false, false, true),
    /**
     * Java runtime elements, specific for iOS. Does not define native bindings.
     * Not present at compile time.
     */
    IOS(false, false, false, true, false, false, false, false),
    /**
     * Runtime elements specific for UWL
     */
    UWP(false, false, false, false, false, true, false, false),
    /**
     * Runtime elements specific for Desktop
     */
    API_NOUWP(true, true, true, true, true, true, false, false),
    /**
     * Used in Java based targets only.
     */
    JAVA(false, true, true, false, false, false, false, false),
    /**
     * Defines the CrossMobile API. Is used for native bindings.
     */
    API(true, true, true, true, true, true, true, false),
    /**
     * Part of the API, used only as a definition view for other plugins. Will
     * not appear anywhere else at all.
     */
    PLUGIN(false, false, false, false, false, false, false, true),
    /**
     * Part of the CrossMobile API. Is not used for native elements and do not
     * create plugins.
     */
    APIJAVA(true, true, true, true, false, true, false, false),
    /**
     * Elements appear in all runtime environments, but not part of the API.
     */
    RUNTIME(false, true, true, true, false, true, false, false),
    /**
     * Elements appear in all runtime environments, as well as are inherited for
     * plugins, but not existing in compile time.
     */
    RUNTIME_PLUGIN(false, true, true, true, false, true, false, true),
    /**
     * Unknown target, default target for elements. Will launch a warning if an
     * element with this target is found.
     */
    UNKNOWN(false, false, false, false, false, false, false, false);

    public final boolean compile, desktop, android, iosjava, iosnative, uwpjava, uwpnative, builddep;

    CMLibTarget(boolean compile, boolean desktop, boolean android, boolean iosjava, boolean iosnative, boolean uwpjava, boolean uwpnative, boolean builddep) {
        this.compile = compile;
        this.desktop = desktop;
        this.android = android;
        this.iosjava = iosjava;
        this.iosnative = iosnative;
        this.uwpjava = uwpjava;
        this.uwpnative = uwpnative;
        this.builddep = builddep;
        if (compile && builddep)
            throw new RuntimeException("Invalid combination of compile and builddep");
    }

    public boolean matches(BaseTarget filter) {
        switch (filter) {
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
            case BUILDDEP:
                return builddep;
        }
        return false;
    }

    public enum BaseTarget {
        DESKTOP, ANDROID, IOS, UWP, COMPILE, BUILDDEP
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
        if (builddep)
            targets.append(",builddep");
        return targets.length() > 0 ? targets.substring(1) : "";
    }
}
