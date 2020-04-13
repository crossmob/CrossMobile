// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.foreign;

import java.io.File;
import java.util.ArrayList;
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
    private String debugProfile;

    public AdbUtils(String adb) {
        this.adb = adb;
    }

    public String getPid(String bundleID) {
        String pid = getPidNew(bundleID);
        return pid == null ? getPidOld(bundleID) : pid;
    }

    private String getPidNew(String bundleID) {
        AtomicReference<String> pid = new AtomicReference<>();
        exec(line -> {
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
        exec(line -> {
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
        exec(adb, "-s", device, "install", "-r", fileLocation);
    }

    public void launchApp(String launchId) {
        exec(adb, "-s", device, "shell", "am", "start", "-n", launchId);
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

    private String[] createLogcatArgs(String pid) {
        List<String> commands = new ArrayList<>();
        commands.add(adb);
        commands.add("-s");
        commands.add(device);
        commands.add("logcat");
        if (pid != null)
            commands.add("--pid=" + pid);
        if (!debugProfile.equals("full"))
            commands.add("-s");
        switch (debugProfile) {
            case "outerr":
                commands.add("System.out:I");
            case "err":
                commands.add("System.err:W");
                commands.add("AndroidRuntime:E");
            case "nslog":
                commands.add("CrossMob:*");
        }
        return commands.toArray(new String[0]);
    }

    private void logOld(String pid) {
        Log.info("");
        exec(false, line -> {
            if (line.contains(pid)) {
                Log.passInfo(line);
                if (line.contains("CrossMob") && line.contains("Activity destroyed"))
                    System.exit(line.contains("error") ? -1 : 0);
            }
        }, createLogcatArgs(null));
    }

    private void logNew(String pid) {
        Log.info("");
        exec(true, line -> {
            Log.passInfo(line);
            if (line.contains("CrossMob") && line.contains("Activity destroyed"))
                System.exit(line.contains("error") ? -1 : 0);
        }, createLogcatArgs(pid));
    }

    private void exec(String... cmds) {
        exec(true, true, null, null, cmds);
    }

    private void exec(Consumer<String> out, String... cmds) {
        exec(false, false, out, null, cmds);
    }

    private void exec(boolean terminateOnError, Consumer<String> out, String... cmds) {
        exec(true, terminateOnError, out, null, cmds);
    }

    private void exec(boolean displayCommand, boolean quitOnError, Consumer<String> out, Consumer<String> err, String... cmds) {
        Commander cmd = new Commander(cmds);
        cmd.setCurrentDir(baseDir);
        cmd.setOutListener(out == null ? Log::passInfo : out);
        cmd.setErrListener(err == null ? Log::passError : err);
        cmd.setDebug(displayCommand);
        cmd.exec();
        cmd.waitFor();
        if (quitOnError && cmd.exitValue() != 0)
            System.exit(cmd.exitValue());
    }

    public void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
    }

    public void setDebugProfile(String debugProfile) {
        this.debugProfile = debugProfile;
    }
}
