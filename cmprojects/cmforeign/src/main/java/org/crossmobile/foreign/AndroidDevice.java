// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.foreign;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AndroidDevice implements Comparable<AndroidDevice> {

    private static final Map<String, String> VERSION = new HashMap<>();

    private static final String DEVICENAME_KEY = "ro.product.model";
    private static final String SDK_VERSION = "ro.build.version.sdk";
    private static final String RELEASE_VERSION = "ro.build.version.release";
    private static final String ID_NAME = "persist.sys.device_name";
    private static final Pattern PATTERN = Pattern.compile("\\[(.*?)\\]:\\s*\\[(.*)\\]");

    static {
        VERSION.put("1", "1.0");
        VERSION.put("2", "1.1");
        VERSION.put("3", "Cupcake");
        VERSION.put("4", "Donut");
        VERSION.put("5", "Eclair");
        VERSION.put("6", "Eclair");
        VERSION.put("7", "Eclair");
        VERSION.put("8", "Froyo");
        VERSION.put("9", "Gingerbread");
        VERSION.put("10", "Gingerbread");
        VERSION.put("11", "Honeycomb");
        VERSION.put("12", "Honeycomb");
        VERSION.put("13", "Honeycomb");
        VERSION.put("14", "Ice Cream Sandwich");
        VERSION.put("15", "Ice Cream Sandwich");
        VERSION.put("16", "Jelly Bean");
        VERSION.put("17", "Jelly Bean");
        VERSION.put("18", "Jelly Bean");
        VERSION.put("19", "KitKat");
        VERSION.put("20", "KitKat");
        VERSION.put("21", "Lollipop");
        VERSION.put("22", "Lollipop");
        VERSION.put("23", "Marshmallow");
        VERSION.put("24", "Nougat");
        VERSION.put("25", "Nougat");
        VERSION.put("26", "Oreo");
        VERSION.put("27", "Oreo");
        VERSION.put("28", "Pie");
        VERSION.put("", "");
    }

    public final String deviceID;
    private final Map<String, String> properties = new HashMap<>();

    public AndroidDevice(String deviceID) {
        this.deviceID = deviceID;
    }

    public void addPropertyLine(String entry) {
        Matcher matcher = PATTERN.matcher(entry.trim());
        if (matcher.matches())
            properties.put(matcher.group(1), matcher.group(2));
    }

    public String getName() {
        return properties.get(DEVICENAME_KEY);
    }

    public String getVersion() {
        String name = VERSION.getOrDefault(properties.getOrDefault(SDK_VERSION, ""), "");
        String ver = properties.getOrDefault(RELEASE_VERSION, "");
        return (name + " " + ver).trim();
    }

    public String getID() {
        return properties.getOrDefault(ID_NAME, deviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.deviceID);
    }

    @Override
    public String toString() {
        return getName() + ", " + getVersion() + " [" + getID() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AndroidDevice other = (AndroidDevice) obj;
        return Objects.equals(this.deviceID, other.deviceID);
    }

    @Override
    public int compareTo(AndroidDevice o) {
        String self = getName();
        String other = getName();
        return self.equals(other)
                ? this.deviceID.compareTo(o.deviceID)
                : self.compareTo(other);
    }
}
