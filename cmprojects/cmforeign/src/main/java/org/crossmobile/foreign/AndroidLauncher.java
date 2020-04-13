// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.foreign;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AndroidLauncher {

    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
    private static final String APK_PREFIX = File.separator + "target" + File.separator + "app" + File.separator + "build" + File.separator + "outputs" + File.separator + "apk" + File.separator;

    private static AdbUtils adb;
    private static String bundleID;
    private static File sdkDir;

    @SuppressWarnings("UseSpecificCatch")
    public static void launch(Properties props) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }

        String mainClass = props.getProperty("mainclass");
        if (mainClass == null || mainClass.trim().isEmpty()) {
            Log.error("Unable to locate main class");
            System.exit(1);
        }

        File loc = null;
        try {
            loc = new File(Class.forName(mainClass).getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (Exception e) {
            Log.error("Unable to find location of main class " + mainClass);
            StringWriter s = new StringWriter();
            e.printStackTrace(new PrintWriter(s));
            Log.error(s.toString());
            System.exit(1);
        }
        File basedir = loc.getName().equals("classes") ? loc.getParentFile() : null;
        basedir = basedir != null && basedir.getName().equals("target") ? basedir.getParentFile() : null;
        if (basedir == null) {
            Log.error("Expected base dir to exist inside the folders 'target" + File.separator + "classes` : base dir found at " + loc.getAbsolutePath());
            System.exit(1);
        }

        try {
            props.load(new InputStreamReader(new FileInputStream(new File(basedir, "local.properties")), StandardCharsets.UTF_8));
        } catch (Exception ex) {
            Log.error("Unable to load local properties");
            System.exit(1);
        }

        if (props.getProperty("sdk.dir", "").isEmpty()) {
            Log.error("SDK location not found, please use the configuration wizard to select the desired Android SDK");
            System.exit(1);
        }
        sdkDir = new File(props.getProperty("sdk.dir"));

        boolean release = props.getProperty("release", "false").equals("true");
        Log.info("Rebuild APK");
        GradleLauncher.runGradle(basedir, release);
        String apkFile = getApkFile(basedir, release);
        if (apkFile == null) {
            Log.error("Unable to locate APK");
            System.exit(1);
        }

        File adbFile = new File(sdkDir, "platform-tools" + File.separator + (isWindows ? "adb.exe" : "adb"));
        if (!adbFile.isFile()) {
            Log.error("Android SDK must be set to run Android");
            System.exit(1);
        }

        adb = new AdbUtils(adbFile.getAbsolutePath());
        adb.setBaseDir(basedir);
        adb.setDebugProfile(props.getProperty("debug.profile"));
        bundleID = props.getProperty("bundleId");

        // Android SDK is peculiar. The name of the APK is based on the name of the current folder.
        // apkName = props.getProperty("appId");
        ConnectedAndroidDispatcher.setAdbLocation(adb.getPath());

        Log.info("Listing connected Android devices");
        File emulator = new File(sdkDir, "emulator/emulator" + (isWindows ? ".exe" : ""));
        if (!emulator.isFile())
            emulator = new File(sdkDir, "tools/emulator" + (isWindows ? ".exe" : ""));
        AndroidTargetSelector selector = new AndroidTargetSelector(dvc -> {
            adb.setDevice(dvc);
            if (!adb.foundDevice()) {
                Log.error("No devices selected, exiting.");
                System.exit(1);
                return;
            }
            adb.installApk(apkFile);
            String oldPid = adb.getPid(bundleID);
            adb.launchApp(bundleID + "/" + bundleID + ".CMLauncher");

            String newPid = null;
            for (int i = 0; i < 10; i++) {
                newPid = adb.getPid(bundleID);
                if (newPid != null && !newPid.equals(oldPid))
                    break;
                else
                    newPid = null;
                waitSomeTime();
            }
            if (newPid == null) {
                Log.error("Unable to retrieve PID of activity " + bundleID);
                System.exit(1);
            }

            adb.log(newPid);
        }, emulator);
        while (true)
            waitSomeTime();
    }

    private static String getApkFile(File basedir, boolean release) {
        String apkName = basedir.getName();
        String rel_deb = release ? "release" : "debug";
        File oldLocation = new File(basedir + APK_PREFIX + apkName + "-" + rel_deb + ".apk");
        File newLocation = new File(basedir + APK_PREFIX + rel_deb + File.separator + apkName + "-" + rel_deb + ".apk");
        return newLocation.isFile() ? newLocation.getAbsolutePath() : (oldLocation.isFile() ? oldLocation.getAbsolutePath() : null);
    }

    private static void waitSomeTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
