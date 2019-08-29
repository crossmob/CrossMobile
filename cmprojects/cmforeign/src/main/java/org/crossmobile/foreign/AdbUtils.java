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

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public class AdbUtils {
    private final String adb;
    private String device;
    private File baseDir;

    public AdbUtils(String adb) {
        this.adb = adb;
    }

    public String getPid(String bundleID) {
        String pid = getPidNew(bundleID);
        return pid == null ? getPidOld(bundleID) : pid;
    }

    private String getPidNew(String bundleID) {
        AtomicReference<String> pid = new AtomicReference<>();
        exec(false, line -> {
            line = line.trim();
            int space = line.indexOf(' ');
            if (space >= 0 && space < line.length() + 1 && bundleID.equals(line.substring(space).trim())) {
                try {
                    pid.set(line.substring(0, space).trim());
                } catch (NumberFormatException ignored) {
                }
            }
        }, adb, "-s", device, "shell", "ps", "-o", "PID,NAME");
        return pid.get();
    }

    private String getPidOld(String bundleID) {
        AtomicReference<String> pid = new AtomicReference<>();
        AtomicInteger pidColumn = new AtomicInteger(-1);
        exec(false, line -> {
            line = line.trim();
            List<String> parts = Arrays.asList(line.split("\\s+"));
            if (pidColumn.get() < 0) {
                if (line.contains("PID")) {
                    for (int idx = 0; idx < parts.size(); idx++) {
                        String part = parts.get(idx);
                        if ("PID".equals(part)) {
                            pidColumn.set(idx);
                            break;
                        }
                    }
                }
            } else if (parts.size() > pidColumn.get() && parts.contains(bundleID)) {
                pid.set(parts.get(pidColumn.get()));
            }
        }, adb, "-s", device, "shell", "ps");
        return pid.get();
    }


    public String getPath() {
        return adb;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public boolean foundDevice() {
        return device != null && !device.isEmpty();
    }

    public void installApk(String fileLocation) {
        exec(true, adb, "-s", device, "install", "-r", fileLocation);
    }

    public void launchApp(String launchId) {
        exec(true, adb, "-s", device, "shell", "am", "start", "-n", launchId);
    }

    public void log(String pid) {
        if (isLogNew())
            logNew(pid);
        else
            logOld(pid);
    }

    private boolean isLogNew() {
        AtomicBoolean supportsNew = new AtomicBoolean(false);
        Consumer<String> parser = line -> {
            if (line.contains("--pid"))
                supportsNew.set(true);
        };
        exec(false, false, parser, parser, null, adb, "-s", device, "logcat", "--INVALID_COMMAND");
        return supportsNew.get();
    }

    private void logOld(String pid) {
        exec(true, false, line -> {
            if (line.contains(pid)) {
                System.out.println(line);
                if (line.contains("CrossMob") && line.contains("Activity destroyed"))
                    System.exit(line.contains("error") ? -1 : 0);
            }
        }, System.out::println, adb, "-s", device, "logcat");
//                    "-s", "AndroidRuntime:E", "System.out:I", "System.err:W", "CrossMob:*");
    }

    private void logNew(String pid) {
        exec(true, true, line -> {
            System.out.println(line);
            if (line.contains("CrossMob") && line.contains("Activity destroyed"))
                System.exit(line.contains("error") ? -1 : 0);
        }, System.out::println, adb, "-s", device, "logcat", "--pid=" + pid);
//                    "-s", "AndroidRuntime:E", "System.out:I", "System.err:W", "CrossMob:*");
    }

    private void exec(boolean debug, String... cmds) {
        exec(debug, debug, null, null, null, cmds);
    }

    private void exec(boolean debug, Consumer<String> out, String... cmds) {
        exec(debug, debug, out, null, null, cmds);
    }

    private void exec(boolean debug, boolean terminateOnError, Consumer<String> out, Runnable start, String... cmds) {
        exec(debug, terminateOnError, out, null, start, cmds);
    }

    private void exec(boolean debug, boolean terminateOnError, Consumer<String> out, Consumer<String> err, Runnable start, String... cmds) {
        Commander cmd = new Commander(cmds);
        cmd.setCurrentDir(baseDir);
        cmd.setOutListener(out == null ? System.out::println : out);
        cmd.setErrListener(err == null ? System.out::println : err);
        cmd.setStartListener(start);
        cmd.setDebug(debug);
        cmd.exec();
        cmd.waitFor();
        if (terminateOnError && cmd.exitValue() != 0)
            System.exit(cmd.exitValue());
    }

    public void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
    }
}
