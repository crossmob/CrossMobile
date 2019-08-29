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
package org.crossmobile.foreign;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AndroidLauncher {

    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
    private static final String APK_PREFIX = File.separator + "target" + File.separator + "app" + File.separator + "build" + File.separator + "outputs" + File.separator + "apk" + File.separator;

    private static AdbUtils adb;
    private static String bundleID;

    @SuppressWarnings("UseSpecificCatch")
    public static void launch(Properties props) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }

        String mainClass = props.getProperty("mainclass");
        if (mainClass == null || mainClass.trim().isEmpty()) {
            System.err.println("Unable to locate main class");
            System.exit(-1);
        }

        File loc = null;
        try {
            loc = new File(Class.forName(mainClass).getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (Exception e) {
            System.err.println("Unable to find location of main class " + mainClass);
            e.printStackTrace(System.err);
            System.exit(-1);
        }
        File basedir = loc.getName().equals("classes") ? loc.getParentFile() : null;
        basedir = basedir != null && basedir.getName().equals("target") ? basedir.getParentFile() : null;
        if (basedir == null) {
            System.err.println("Expected base dir to exist inside the folders 'target" + File.separator + "classes` : base dir found at " + loc.getAbsolutePath());
            System.exit(-1);
        }

        try {
            props.load(new InputStreamReader(new FileInputStream(new File(basedir, "local.properties")), StandardCharsets.UTF_8));
        } catch (Exception ex) {
            System.err.println("Unable to load local properties");
        }
        adb = new AdbUtils(getFile(props.getProperty("sdk.dir") + File.separator + "platform-tools" + File.separator + (isWindows ? "adb.exe" : "adb"), "Android SDK"));
        adb.setBaseDir(basedir);
        bundleID = props.getProperty("bundleId");
        boolean release = props.getProperty("release", "false").equals("true");

        // Android SDK is peculiar. The name of the APK is based on the name of the current folder.
        // apkName = props.getProperty("appId");
        String apkName = basedir.getName();
        ConnectedAndroidDispatcher.setAdbLocation(adb.getPath());

        String rel_deb = release ? "release" : "debug";
        File oldLocation = new File(basedir + APK_PREFIX + apkName + "-" + rel_deb + ".apk");
        File newLocation = new File(basedir + APK_PREFIX + rel_deb + File.separator + apkName + "-" + rel_deb + ".apk");
        if (!oldLocation.isFile() && !newLocation.isFile()) {
            System.out.println("Unable to locate APK under " + newLocation.getAbsolutePath() + " or " + oldLocation.getAbsolutePath() + "\nExiting.");
            System.exit(-1);
            return;
        }

        System.out.println("Listing connected Android devices");
        AndroidTargetSelector selector = new AndroidTargetSelector(dvc -> {
            adb.setDevice(dvc);
            if (!adb.foundDevice()) {
                System.out.println("No devices selected, exiting.");
                System.exit(-1);
                return;
            }
            adb.installApk(newLocation.isFile() ? newLocation.getAbsolutePath() : oldLocation.getAbsolutePath());
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
                System.out.println("[ERROR] Unable to retrieve PID of activity " + bundleID);
                System.exit(1);
            }

            adb.log(newPid);
        });
        while (true)
            waitSomeTime();
    }

    private static String getFile(String relativePath, String filetype) {
        File file = new File(relativePath);
        if (!file.isFile()) {
            System.out.println("[ERROR] " + filetype + " must be set to run Android");
            System.exit(1);
        }
        return file.getAbsolutePath();
    }

    private static void waitSomeTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
