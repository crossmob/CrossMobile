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
package org.crossmobile.foreign;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidLauncher {

    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
    private static final String APK_PREFIX = File.separator + "target" + File.separator + "app" + File.separator + "build" + File.separator + "outputs" + File.separator + "apk" + File.separator;
    private static final Pattern PID_PATTERN = Pattern.compile("[^\\s]+\\s+[^\\s]+\\s+([^\\s]+)\\s+.+");

    private static String adb;
    private static String bundleID;
    private static String apkname;
    private static File basedir;
    private static String device;
    private static String pid = null;

    @SuppressWarnings("UseSpecificCatch")
    public static void launch(Properties props) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
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
        basedir = loc.getName().equals("classes") ? loc.getParentFile() : null;
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
        adb = getFile(props.getProperty("sdk.dir") + File.separator + "platform-tools" + File.separator + (isWindows ? "adb.exe" : "adb"), "Android SDK");
        bundleID = props.getProperty("bundleId");
        boolean release = props.getProperty("release", "false").equals("true");

        // Android SDK is peculiar. The name of the APK is based on the name of the current folder.
        // apkname = props.getProperty("appId");
        apkname = basedir.getName();
        ConnectedAndroidDispatcher.setAdbLocation(adb);

        String rel_deb = release ? "release" : "debug";
        File oldlocation = new File(basedir + APK_PREFIX + apkname + "-" + rel_deb + ".apk");
        File newlocation = new File(basedir + APK_PREFIX + rel_deb + File.separator + apkname + "-" + rel_deb + ".apk");
        if (!oldlocation.isFile() && !newlocation.isFile()) {
            System.out.println("Unable to locate APK under " + newlocation.getAbsolutePath() + " or " + oldlocation.getAbsolutePath() + "\nExiting.");
            System.exit(-1);
            return;
        }

        System.out.println("Listing connected Android devices");
        AtomicReference<Boolean> status = new AtomicReference<>();
        AndroidTargetSelector selector = new AndroidTargetSelector(dvc -> {
            device = dvc;
            if (device == null) {
                System.out.println("No devices selected, exiting.");
                System.exit(-1);
                return;
            }
            exec(System.out::println, true,
                    adb,
                    "-s", device,
                    "install",
                    "-r",
                    newlocation.isFile() ? newlocation.getAbsolutePath() : oldlocation.getAbsolutePath());
            String oldPid = getPID(null);
            exec(System.out::println, true,
                    adb,
                    "-s", device,
                    "shell",
                    "am",
                    "start",
                    "-n", bundleID + "/" + bundleID + ".CMLauncher");

            pid = null;
            for (int i = 0; i < 10; i++) {
                pid = getPID(oldPid);
                if (pid != null)
                    break;
                waitSomeTime();
            }
            if (pid == null) {
                System.out.println("[ERROR] Unable to retrieve PID of activity " + bundleID);
                System.exit(1);
            }
            System.out.println(" ");
            exec(line -> {
                        System.out.println(line);
                        if (line.contains("CrossMob:") && line.contains("Activity destroyed"))
                            status.set(line.contains("error"));
                    }, true,
                    adb,
                    "-s", device,
                    "logcat",
                    "--pid=" + pid);
//                    "-s", "AndroidRuntime:E", "System.out:I", "System.err:W", "CrossMob:*");
        });
        while (true) {
            waitSomeTime();
            if (device != null && status.get() != null)
                System.exit(status.get() ? -1 : 0);
        }
    }

    private static String getPID(String oldPid) {
        AtomicReference<String> pid = new AtomicReference<>();
        exec(line -> {
                    line = line.trim();
                    int space = line.indexOf(' ');
                    if (space >= 0 && space < line.length() + 1 && bundleID.equals(line.substring(space).trim())) {
                        try {
                            String newPid = line.substring(0, space).trim();
                            if (!newPid.equals(oldPid))
                                pid.set(line.substring(0, space).trim());
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }, false,
                adb, "-s", device, "shell", "ps", "-o", "PID,NAME");
        return pid.get();
    }

    private static void exec(Consumer<String> out, boolean debug, String... cmds) {
        Commander cmd = new Commander(cmds);
        cmd.setCurrentDir(basedir);
        cmd.setOutListener(out);
        cmd.setErrListener(System.out::println);
        cmd.setDebug(debug);
        cmd.exec();
        cmd.waitFor();
        if (cmd.exitValue() != 0)
            System.exit(cmd.exitValue());
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
