/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.prefs;

import org.crossmobile.bridge.system.BaseUtils;
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

    private static final String RECENT_ITEM = "recent.item";
    private static final String CURRENT_DIR = "current.dir";
    private static final String PROJECT_DIR = "project.dir";
    private static final String NETBEANS_LOCATION = "location.netbeans";
    private static final String INTELLIJ_LOCATION = "location.intellij";
    private static final String VSCODE_LOCATION = "location.vscode";
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

    public static final String LAUNCH_ACTION_RUN = "run";
    public static final String LAUNCH_ACTION_BUILD = "build";

    private static final Preferences prefs = Preferences.userRoot().node("org").node("crossmobile").node("prefs");
    private static final Preferences prefsOld = Preferences.userRoot().node("tech").node("crossmobile").node("prefs");

    private static String getPreference(String key, String default_value) {
        String result = prefs.get(key, null);
        if (result == null) {
            result = prefsOld.get(key, default_value);
            if (result != null) // migrate to new location
                setPreference(key, result);
        }
        prefsOld.remove(key);
        return result;
    }

    private static void setPreference(String key, String value) {
        prefsOld.remove(key);
        prefs.put(key, value);
    }

    private static void removePreference(String key) {
        prefsOld.remove(key);
        prefs.remove(key);
    }

    public static String getProject(int id) {
        return getPreference(RECENT_ITEM + id, null);
    }

    public static void storeProject(int i, String project) {
        setPreference(RECENT_ITEM + i, project);
    }

    public static boolean removeProject(int i) {
        if (getPreference(RECENT_ITEM + i, null) == null)
            return false;
        removePreference(RECENT_ITEM + i);
        return true;
    }

    public static void setCurrentDir(File dir) {
        try {
            if (dir != null && dir.exists())
                setPreference(CURRENT_DIR, dir.getCanonicalPath());
        } catch (IOException ignored) {
        }
    }

    public static File getCurrentDir() {
        return new File(getPreference(CURRENT_DIR, ""));
    }

    public static File getProjectsDir() {
        String path = getPreference(PROJECT_DIR, null);
        return path == null
                ? new File(System.getProperty("user.home") + File.separator + "CrossMobileProjects")
                : new File(path);
    }

    public static void setProjectsDir(File dir) {
        try {
            if (dir != null) {
                dir.mkdirs();
                if (dir.isDirectory())
                    setPreference(PROJECT_DIR, dir.getCanonicalPath());
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

    public static void setVSCodeLocation(String fname) {
        setTagLocation(VSCODE_LOCATION, fname);
    }

    public static String getVSCodeLocation() {
        return getTagLocation(VSCODE_LOCATION);
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
        return androidSDKLocation.isEmpty() ? "" : getSafeFile(
                androidSDKLocation + File.separator + "tools" + File.separator + "bin" + File.separator + SDKMANAGER.filename(),
                androidSDKLocation + File.separator + "cmdline-tools" + File.separator + "bin" + File.separator + SDKMANAGER.filename()
        );
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
        setPreference(ANDROID_KEY, location);
    }

    public static String getAndroidKeyLocation() {
        return getPreference(ANDROID_KEY, "");
    }

    public static void setStudioLocation(String fname) {
        setTagLocation(STUDIO_LOCATION, fname);
    }

    public static void setVisualStudioLocation(String fname) {
        setTagLocation(VISUALSTUDIO_LOCATION, fname);
    }

    private static String getSafeFile(String... paths) {
        for (String path : paths)
            if (new File(path).exists())
                return path;
        return "";
    }

    private static String getTagLocation(String TAG) {
        return getSafeFile(getPreference(TAG, ""));
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
            setPreference(TAG, location);
        }
    }

    public static void setSelectedLaunchAction(String path, String action) {
        if (action != null)
            setPreference(LAUNCH_ACTION + ":" + hash(path), action);
    }

    public static String getSelectedLaunchAction(String path) {
        return getPreference(LAUNCH_ACTION + ":" + hash(path), LAUNCH_ACTION_RUN);
    }

    public static boolean isWizardExecuted() {
        return BaseUtils.objectToBoolean(getPreference(INITIAL_WIZARD, "false"));
    }

    public static void setWizardExecuted(boolean value) {
        setPreference(INITIAL_WIZARD, Boolean.toString(value));
    }

    public static void setSelectedLaunchTarget(String path, String target) {
        if (target != null)
            setPreference(LAUNCH_TARGET + hash(path), target);
    }

    public static LaunchTarget getSelectedLaunchTarget(String path) {
        return LaunchTarget.find(getPreference(LAUNCH_TARGET + hash(path), null));
    }

    public static void setLaunchType(String path, String launchType) {
        setPreference(LAUNCH_TYPE + hash(path), launchType);
    }

    public static String getLaunchType(String path) {
        return getPreference(LAUNCH_TYPE + hash(path), "debug");
    }

    private static String hash(String filename) {
        try {
            return TextUtils.bytesToHex(MessageDigest.getInstance("MD5").digest(filename.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            return Integer.toString(filename.hashCode());
        }
    }

    public static String getUserTheme() {
        return getPreference(USER_THEME, SystemDependent.getDefaultTheme());
    }

    public static void setUserTheme(String theme) {
        theme = theme == null || theme.trim().isEmpty() ? "auto" : theme.trim();
        setPreference(USER_THEME, theme);
    }

    public static String getSystemTheme() {
        return getPreference(SYSTEM_THEME, "bright");
    }

    public static void setSystemTheme(String theme) {
        theme = theme == null || theme.trim().isEmpty() ? "bright" : theme.trim();
        setPreference(SYSTEM_THEME, theme);
    }
}
