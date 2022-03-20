/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import java.io.File;

public enum OperatingSystem {

    Windows,
    Linux,
    MacOSX,
    Unkown;
    public static final OperatingSystem current;

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.startsWith("win"))
            current = Windows;
        else if (os.startsWith("linux"))
            current = Linux;
        else if (os.startsWith("mac"))
            current = MacOSX;
        else
            current = Unkown;
    }

    public static String getJavaExec() {
        return System.getProperty("java.home") + File.separator + "bin" + File.separator + (OperatingSystem.current == OperatingSystem.Windows ? "java.exe" : "java");
    }
}
