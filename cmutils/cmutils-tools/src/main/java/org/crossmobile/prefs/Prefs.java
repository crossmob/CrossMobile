/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.prefs;

import org.crossmobile.utils.TextUtils;

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
    private static final String STUDIO_LOCATION = "location.studio";
    private static final String VISUALSTUDIO_LOCATION = "location.visualstudio";
    private static final String JDK_LOCATION = "location.jdk";
    private static final String ANDROID_LOCATION = "android.sdk.location";
    private static final String ANDROID_TARGET = "android.target";
    private static final String ANDROID_KEY = "android.key";
    private static final String LAUNCH_TARGET = "launch.target.";
    private static final String LAUNCH_TYPE = "launch.type.";
    private static final String LAUNCH_ACTION = "launch.action";
    private static final String INITIAL_WIZARD = "initial.wizard";

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
        if (fname != null)
            prefs.put(NETBEANS_LOCATION, fname);
    }

    public static String getNetbeansLocation() {
        return getTagLocation(NETBEANS_LOCATION);
    }

    public static void setIntelliJLocation(String fname) {
        if (fname != null)
            prefs.put(INTELLIJ_LOCATION, fname);
    }

    public static String getIntelliJLocation() {
        return getTagLocation(INTELLIJ_LOCATION);
    }

    public static void setJDKLocation(String fname) {
        if (fname != null)
            prefs.put(JDK_LOCATION, fname);
    }

    public static String getJDKLocation() {
        String location = getTagLocation(JDK_LOCATION);
        return location.isEmpty() || getSafeFile(location + File.separator + "bin" + File.separator + JAVAC.filename()).isEmpty()
                ? ""
                : location;
    }

    public static String getAndroidSDKLocation() {
        String location = getTagLocation(ANDROID_LOCATION);
        return location.isEmpty() || getSafeFile(location + File.separator + "tools" + File.separator + ANDROID.filename()).isEmpty()
                ? ""
                : location;
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

    public static void setAndroidSDKLocation(String fname) {
        if (fname != null)
            prefs.put(ANDROID_LOCATION, fname);
    }

    public static String getAndroidManagerLocation() {
        String sdk = getAndroidSDKLocation();
        return sdk.isEmpty()
                ? ""
                : sdk + "/tools/bin/" + SDKMANAGER.filename();
    }

    public static void setAndroidKeyLocation(String location) {
        prefs.put(ANDROID_KEY, location);
    }

    public static String getAndroidKeyLocation() {
        return prefs.get(ANDROID_KEY, "");
    }

    public static void setAndroidTarget(String target) {
        prefs.put(ANDROID_TARGET, target);
    }

    public static void setStudioLocation(String fname) {
        if (fname != null)
            prefs.put(STUDIO_LOCATION, fname);
    }

    public static void setVisualStudioLocation(String fname) {
        if (fname != null)
            prefs.put(VISUALSTUDIO_LOCATION, fname);
    }

    private static String getSafeFile(String path) {
        return new File(path).exists() ? path : "";
    }

    private static String getTagLocation(String TAG) {
        return getSafeFile(prefs.get(TAG, ""));
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
}
