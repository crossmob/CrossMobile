/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.launcher;

import org.crossmobile.bridge.system.LazyProperty;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public enum TargetArch {
    LINUX_X86_64("linux", "x86_64", "elf_x86_64", "/lib64/ld-linux-x86-64.so.2"),
    LINUX_ARM("linux", "arm", "armelf_linux_eabi", "/lib/ld-linux-armhf.so.3"),
    LINUX_ARM64("linux", "arm64", "aarch64linux", "/lib/ld-linux-aarch64.so.1");

    private static final String DEFAULT_OS;
    private static final String DEFAULT_ARCH;

    static {
        DEFAULT_OS = "linux";
        DEFAULT_ARCH = "x86_64";
    }

    private static final LazyProperty<Collection<String>> allOs = new LazyProperty<>(() -> {
        Collection<String> result = new HashSet<>();
        for (TargetArch target : TargetArch.values())
            result.add(target.os);
        return result;
    });
    private static final LazyProperty<Collection<String>> allArch = new LazyProperty<>(() -> {
        Collection<String> result = new HashSet<>();
        for (TargetArch target : TargetArch.values())
            result.add(target.arch);
        return result;
    });

    private final String os;
    private final String arch;
    private final String emulationMode;
    private final String linker;

    TargetArch(String os, String arch, String emulationMode, String linker) {
        this.os = os;
        this.arch = arch;
        this.emulationMode = emulationMode;
        this.linker = linker;
    }

    public String getOs() {
        return os;
    }

    public String getArch() {
        return arch;
    }

    public String getEmulation() {
        return emulationMode;
    }

    public String getLinker() {
        return linker;
    }

    public static TargetArch getFromOsArch(String os, String arch) {
        if (os == null)
            os = DEFAULT_OS;
        if (arch == null)
            arch = DEFAULT_ARCH;
        for (TargetArch targetArch : values())
            if (targetArch.os.equals(os) && targetArch.arch.equals(arch))
                return targetArch;
        throw new RuntimeException("Architecture " + arch + " is not supported on operating system " + os);
    }

    public static TargetArch getFromProfiles(List<String> activeProfiles) {
        String os = null;
        String arch = null;
        for (String profile : activeProfiles)
            if (allOs.get().contains(profile))
                if (os != null)
                    throw new RuntimeException("OS already defined as " + os + ", new value: " + profile);
                else
                    os = profile;
            else if (allArch.get().contains(profile))
                if (arch != null)
                    throw new RuntimeException("Arch already defined as " + arch + ", new value: " + profile);
                else
                    arch = profile;
        return getFromOsArch(os, arch);
    }
}
