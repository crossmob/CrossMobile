/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.ann.CMPod;

import java.io.File;
import java.util.Objects;

import static org.crossmobile.bridge.system.Pair.pair;
import static org.crossmobile.utils.FileUtils.write;
import static org.crossmobile.utils.TextUtils.*;

public class PluginPod implements Comparable<PluginPod> {

    private final String name;
    private final String minVersion;
    private final String maxVersion;

    public static String getPlatform() {
        return "platform :ios, '8.0'";
    }

    public PluginPod(CMPod pod) {
        this(pod.value(), pod.minVersion(), pod.maxVersion());
    }

    PluginPod(String name, String minVersion, String maxVersion) {
        this.name = name;
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
    }

    public String getName() {
        return name;
    }

    public String getMinVersion() {
        return minVersion;
    }

    public String getMaxVersion() {
        return maxVersion;
    }

    @Override
    public int compareTo(PluginPod other) {
        if (other == null)
            return -1;
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(name, ((PluginPod) o).name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("pod '");
        out.append(name).append('\'');
        if (!minVersion.isEmpty() || !maxVersion.isEmpty())
            out.append(", '").append(minVersion.isEmpty() ? "0" : minVersion).append('\'');
        if (!maxVersion.isEmpty())
            out.append(", '").append(maxVersion).append('\'');
        return out.toString();
    }

    String freeze() {
        return esc(name) + "|" + esc(minVersion) + "|" + esc(maxVersion);
    }

    static PluginPod unfreeze(String input) {
        String[] parts = input.split("[|]", -1);
        if (parts.length != 3)
            throw new IllegalArgumentException("Unfreeze of PluginPod should have exactly three parts");
        return new PluginPod(unesc(parts[0]), unesc(parts[1]), unesc(parts[2]));
    }

    private static String esc(String input) {
        return escape(input, '\\', true, pair('|', 'p'), pair(';', 's'));

    }

    private static String unesc(String input) {
        return unescape(input, '\\', true, pair('p', '|'), pair('s', ';'));
    }

    public static void create(File destDir, String projectName, Iterable<XcodeTarget> targets, Iterable<PluginPod> pods) {
        Log.info("Binding pods: " + iterableToString(pods, " ", pod -> pod.name));

        StringBuilder podfile = new StringBuilder();
        podfile.append(PluginPod.getPlatform()).append("\n\n");
        for (XcodeTarget target : targets) {
            podfile.append("target '").append(target.name.isEmpty() ? projectName : target.name).append("' do\n");
            for (PluginPod pod : pods)
                podfile.append("  ").append(pod.toString()).append('\n');
            podfile.append("end\n\n");
        }
        write(new File(destDir, "Podfile"), podfile.toString()).getAbsolutePath();

        File pod = ExecLocator.findPath("pod");
        if (pod == null)
            throw new RuntimeException("Unable to locate CocoaPods installation");

        Commander c = new Commander(pod.getAbsolutePath(), "install");
        c.setCurrentDir(destDir);
        c.setOutListener(Log::info);
        c.setErrListener(Log::warning);
        if (c.exec() != null) {
            c.waitFor();
            if (c.exitValue() == 0)
                Log.info("Pods have been attached");
            else
                Log.error("Unable to create pods");
        }
    }
}
