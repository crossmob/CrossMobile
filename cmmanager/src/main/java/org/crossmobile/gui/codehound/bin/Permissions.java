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
package org.crossmobile.gui.codehound.bin;

public enum Permissions {

    CAMERA("CAMERA", "Require Camera", "images/camera", new String[]{"crossmobile.ios.uikit.UIImagePickerController"}),
    LOCATION_SERVICES("ACCESS_FINE_LOCATION", "Require GPS location", "images/location", new String[]{"crossmobile.ios.corelocation.CLLocation", "crossmobile.ios.corelocation.CLLocationManager", "crossmobile.ios.mapkit.MKMapView"}),
    INTERNET_CONNECTION("INTERNET", "Require internet connection", "images/internet", new String[]{"crossmobile.ios.foundation.NSURL"}),
    BLUETOOTH("BLUETOOTH", "Require BlueTooth connectivity", "images/bluetooth", new String[]{}),
    VIBRATE("VIBRATE", "Require to vibrate the phone", "images/vibrate", new String[]{"crossmobile.ios.audiotoolbox.AudioServices"}),
    STORAGE("WRITE_EXTERNAL_STORAGE", "Require to write to external storage, outside current application", "images/external", new String[]{"crossmobile.ios.foundation.Foundation"}),
    BILLING("BILLING", "Require the in-app store", "images/billing", new String[]{"crossmobile.ios.storekit.SKPaymentQueue"}),
    ACCESS_NETWORK_STATE("ACCESS_NETWORK_STATE", "Require Network State", "images/access", new String[]{"crossmobile.ios.mapkit.MKMapView"}),
    FINGERPRINT("USE_FINGERPRINT", "Require Fingerprint authentication", "images/fingerprint", new String[]{"crossmobiole.ios.touchid.LAContext"});

    private static final String[] android_perm;
    private static final String[] friendly_names;
    private static final String[] tooltips;
    private static final String[] icons;

    private final String permission;
    private final String displayName;
    private final String tooltip;
    private final String icon;
    private final String[] classes;

    static {
        Permissions[] values = Permissions.values();
        android_perm = new String[values.length];
        friendly_names = new String[values.length];
        tooltips = new String[values.length];
        icons = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            friendly_names[i] = values[i].displayName;
            android_perm[i] = values[i].permission;
            tooltips[i] = values[i].tooltip;
            icons[i] = values[i].icon;
        }
    }

    Permissions(String perm_name, String tooltip, String icon, String[] classes) {
        String name = name();
        this.permission = "android.permission." + perm_name;
        this.displayName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase().replace('_', ' ');
        this.classes = classes;
        this.tooltip = tooltip;
        this.icon = icon;
    }

    public String getPermission() {
        return permission;
    }

    public static String[] getPermissions() {
        return android_perm;
    }

    public static String[] getNames() {
        return friendly_names;
    }

    public static String[] getTooltips() {
        return tooltips;
    }

    public static String[] getIcons() {
        return icons;
    }

    boolean requires(String classname) {
        for (String aClass : classes)
            if (classname.equals(aClass))
                return true;
        return false;
    }
}
