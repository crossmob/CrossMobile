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
package org.crossmobile.build.utils;

import org.crossmobile.utils.FileUtils;

import java.io.File;
import java.util.regex.Pattern;

import static org.crossmobile.build.utils.Templates.*;

public final class SynchronizeHelpers {

    private final static Pattern packagePattern = Pattern.compile("([a-zA-Z]\\w*?\\.)*?[a-zA-Z]\\w*?");
    private final static Pattern classPattern = Pattern.compile("([a-zA-Z]\\w*?\\.)+?[a-zA-Z]\\w*?");

    private SynchronizeHelpers() {
    }

    /*
     * Create main activity & main application
     */
    public static void createActivityAndApplication(String bundleID, File generated) {
        FileUtils.write(getClassFile(generated, bundleID, CURRENT_ACTIVITY), LAUNCHACTIVITY_TEMPLATE.replace(BUNDLEID_ANCHOR, bundleID));
        FileUtils.write(getClassFile(generated, bundleID, CURRENT_APPLICATION), LAUNCHAPPLICATION_TEMPLATE.replace(BUNDLEID_ANCHOR, bundleID));
    }

    public static void createAndroidManifest(File manifestfile, String bundleid, String displayName, String version, int numversion, String applicationExtras, String permissions, boolean debuggable) {
        String manifest = ANDROID_MANIFEST
                .replace(BUNDLEID_ANCHOR, bundleid)
                .replace(DISPLAYNAME_ANCHOR, displayName)
                .replace(VERSION_ANCHOR, version)
                .replace(VERSIONCODE_ANCHOR, Integer.toString(numversion))
                .replace(APPLICATIONEXTRAS_ANCHOR, applicationExtras)
                .replace(PERMISSIONS_ANCHOR, permissions)
                .replace(DEBUGGABLE_ANCHOR, Boolean.toString(debuggable));
        FileUtils.write(manifestfile, manifest);
    }

    public static void createBasePathAndroid(File basepathfile, String bundleid) {
        String basepath = BASEPATH_ANDROID
                .replace(BUNDLEID_ANCHOR, bundleid);
        FileUtils.write(basepathfile, basepath);
    }

    private static File getClassFile(File generated, String packname, String classname) {
        return new File(new File(generated, packname.replace('.', File.separatorChar)), classname + ".java");
    }

    public static boolean checkValidDotNotation(String kind, String name, boolean asClass) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("Property \"" + kind + "\" should be set");
        if (!(asClass ? classPattern : packagePattern).matcher(name).matches() || name.contains("$"))
            throw new RuntimeException("Invalid " + kind + " name: " + name);
        return true;
    }

    public static void checkVariable(String name, Object value) {
        checkVariable(name, value == null, "is not set");
    }

    public static void checkVariable(String name, boolean failCondition, String explain) {
        if (failCondition)
            throw new RuntimeException("Attribute \'" + name + "\' " + explain);
    }
}
