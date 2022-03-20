/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
