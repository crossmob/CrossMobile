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
package org.crossmobile;

import com.panayotis.loadlib.LoadLib;

public class NativeHandler {

    private static final boolean isLoaded;

    static {
        isLoaded = LoadLib.load("/lib/"
                + (System.getProperty("os.arch").contains("64") ? "64" : "32")
                + "/commander.dll");
    }

    public static long getPid(long handler) {
        return isLoaded ? handlerToPid(handler) : -1;
    }

    public static void killPid(long pid) {
        if (isLoaded)
            kill(pid);
    }

    private static native void kill(long pid);

    private static native long handlerToPid(long handler);
}
