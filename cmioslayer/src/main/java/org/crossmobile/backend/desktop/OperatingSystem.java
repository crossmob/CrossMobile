/*
 * (c) 2020 by Panayotis Katsaloulis
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
