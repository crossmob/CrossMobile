// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.prefs;

import org.crossmobile.utils.SystemDependent;
import org.crossmobile.utils.TextUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.prefs.Preferences;

import static org.crossmobile.utils.SystemDependent.Execs.*;

public class Prefs {

    public static final boolean CHECK_LICENSE = false;

    private static final String RECENT_ITEM = "recent.item";
    private static final String CURRENT_DIR = "current.dir";
    private static final String PROJECT_DIR = "project.dir";
    private static final String NETBEANS_LOCATION = "location.netbeans";
    private static final String INTELLIJ_LOCATION = "location.intellij";
    private static final String STUDIO_LOCATION = "location.studio";
    private static final String VISUALSTUDIO_LOCATION = "location.visualstudio";
    private static final String JDK_LOCATION = "location.jdk";
    private static final String ANDROID_LOCATION = "android.sdk.location";
    private static final String ANDROID_KEY = "android.key";
    private static final String LAUNCH_TARGET = "launch.target.";
    private static final String LAUNCH_TYPE = "launch.type.";
    private static final String LAUNCH_ACTION = "launch.action";
    private static final String INITIAL_WIZARD = "initial.wizard";
    private static final String USER_THEME = "user.theme";
    private static final String SYSTEM_THEME = "system.theme";

    public static final String LAUNCH_TARGET_IOS = "ios";
    public static final String LAUNCH_TARGET_ANDROID = "android";
    public static final String LAUNCH_TARGET_DESKTOP = "desktop";
    public static final String LAUNCH_TARGET_UWP = "uwp";
    public static final String LAUNCH_ACTION_RUN = "run";
    public static final String LAUNCH_ACTION_BUILD = "build";
    public static final String OPEN_NETBEANS = "Netbeans";
    public static final String OPEN_INTELLIJ = "IntelliJ IDEA";
    public static final String OPEN_STUDIO = "Android Studio";
    public static final String OPEN_XCODE = "Xcode";
    public static final String OPEN_VSTUDIO = "VStudio";

    private static final Preferences prefs = Preferences.userRoot().node("tech").node("crossmobile").node("prefs");

    public static String getProject(int id) {
        return prefs.get(RECENT_ITEM + id, null);
    }

    public static void storeProject(int i, String project) {
        prefs.put(RECENT_ITEM + i, project);
    }

    public static boolean removeProject(int i) {
        if (prefs.get(RECENT_ITEM + i, null) == null)
            return false;
        prefs.remove(RECENT_ITEM + i);
        return true;
    }

    public static void setCurrentDir(File dir) {
        try {
            if (dir != null && dir.exists())
                prefs.put(CURRENT_DIR, dir.getCanonicalPath());
        } catch (IOException ex) {
        }
    }

    public static File getCurrentDir() {
        return new File(prefs.get(CURRENT_DIR, ""));
    }

    public static File getProjectsDir() {
        String path = prefs.get(PROJECT_DIR, null);
        return path == null
                ? new File(System.getProperty("user.home") + File.separator + "CrossMobileProjects")
                : new File(path);
    }

    public static void setProjectsDir(File dir) {
        try {
            if (dir != null) {
                dir.mkdirs();
                if (dir.isDirectory())
                    prefs.put(PROJECT_DIR, dir.getCanonicalPath());
            }
        } catch (IOException e) {
        }
    }

    public static void setNetbeansLocation(String fname) {
        setTagLocation(NETBEANS_LOCATION, fname);
    }

    public static String getNetbeansLocation() {
        return getTagLocation(NETBEANS_LOCATION);
    }

    public static void setIntelliJLocation(String fname) {
        setTagLocation(INTELLIJ_LOCATION, fname);
    }

    public static String getIntelliJLocation() {
        return getTagLocation(INTELLIJ_LOCATION);
    }

    public static void setJDKLocation(String fname) {
        setTagLocation("JDK", JDK_LOCATION, fname);
    }

    public static String getJDKLocation() {
        String location = getTagLocation(JDK_LOCATION);
        return location.isEmpty() || getSafeFile(location + File.separator + "bin" + File.separator + JAVAC.filename()).isEmpty()
                ? ""
                : location;
    }

    public static void setAndroidSDKLocation(String fname) {
        setTagLocation("Android SDK", ANDROID_LOCATION, fname);
    }


    private static String getAndroidSDKManagerLocation(String androidSDKLocation) {
        return androidSDKLocation.isEmpty() ? "" : getSafeFile(androidSDKLocation + File.separator + "tools" + File.separator + "bin" + File.separator + SDKMANAGER.filename());
    }

    private static String getAdbLocation(String androidSDKLocation) {
        return androidSDKLocation.isEmpty() ? "" : getSafeFile(androidSDKLocation + File.separator + "platform-tools" + File.separator + ADB.filename());
    }

    public static String getAndroidSDKLocation() {
        String location = getTagLocation(ANDROID_LOCATION);
        if (location.isEmpty())
            return "";
        String sdkmanager = getAndroidSDKManagerLocation(location);
        if (!sdkmanager.isEmpty())
            return location;
        String adb = getAdbLocation(location);
        return adb.isEmpty() ? "" : location;
    }

    public static boolean isAndroidLicenseLocationValid() {
        return new File(getAndroidSDKLocation(), "licenses" + File.separator + "android-sdk-license").isFile();
    }

    public static String getAndroidStudioLocation() {
        return getTagLocation(STUDIO_LOCATION);
    }

    public static String getVisualStudioLocation() {
        return getTagLocation(VISUALSTUDIO_LOCATION);
    }

    public static String getAndroidSDKManagerLocation() {
        return getAndroidSDKManagerLocation(getAndroidSDKLocation());
    }

    public static void setAndroidKeyLocation(String location) {
        prefs.put(ANDROID_KEY, location);
    }

    public static String getAndroidKeyLocation() {
        return prefs.get(ANDROID_KEY, "");
    }

    public static void setStudioLocation(String fname) {
        setTagLocation(STUDIO_LOCATION, fname);
    }

    public static void setVisualStudioLocation(String fname) {
        setTagLocation(VISUALSTUDIO_LOCATION, fname);
    }

    private static String getSafeFile(String path) {
        return new File(path).exists() ? path : "";
    }

    private static String getTagLocation(String TAG) {
        return getSafeFile(prefs.get(TAG, ""));
    }

    private static void setTagLocation(String TAG, String location) {
        setTagLocation(null, TAG, location);
    }

    private static void setTagLocation(String appName, String TAG, String location) {
        if (location == null)
            return;
        String old = getTagLocation(TAG);
        if (!old.equals(location)) {
            if (appName != null) {
                String accError = SystemDependent.canAccessPath(appName, location);
                if (accError != null)
                    SwingUtilities.invokeLater(()
                            -> JOptionPane.showMessageDialog(null, accError, "External program access issue", JOptionPane.WARNING_MESSAGE));
            }
            prefs.put(TAG, location);
        }
    }

    public static void setSelectedLaunchAction(String path, String action) {
        if (action != null)
            prefs.put(LAUNCH_ACTION + ":" + hash(path), action);
    }

    public static String getSelectedLaunchAction(String path) {
        return prefs.get(LAUNCH_ACTION + ":" + hash(path), LAUNCH_ACTION_RUN);
    }

    public static boolean isWizardExecuted() {
        return prefs.getBoolean(INITIAL_WIZARD, false);
    }

    public static void setWizardExecuted(boolean value) {
        prefs.putBoolean(INITIAL_WIZARD, value);
    }

    public static void setSelectedLaunchTarget(String path, String target) {
        if (target != null)
            prefs.put(LAUNCH_TARGET + hash(path), target);
    }

    public static String getSelectedLaunchTarget(String path) {
        return prefs.get(LAUNCH_TARGET + hash(path), LAUNCH_TARGET_DESKTOP);
    }

    public static void setLaunchType(String path, String launchType) {
        prefs.put(LAUNCH_TYPE + hash(path), launchType);
    }

    public static String getLaunchType(String path) {
        return prefs.get(LAUNCH_TYPE + hash(path), "debug");
    }

    private static String hash(String filename) {
        try {
            return TextUtils.bytesToHex(MessageDigest.getInstance("MD5").digest(filename.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            return Integer.toString(filename.hashCode());
        }
    }

    public static String getUserTheme() {
        return prefs.get(USER_THEME, "auto");
    }

    public static void setUserTheme(String theme) {
        theme = theme == null || theme.trim().isEmpty() ? "auto" : theme.trim();
        prefs.put(USER_THEME, theme);
    }

    public static String getSystemTheme() {
        return prefs.get(SYSTEM_THEME, "bright");
    }

    public static void setSystemTheme(String theme) {
        theme = theme == null || theme.trim().isEmpty() ? "bright" : theme.trim();
        prefs.put(SYSTEM_THEME, theme);
    }
}
