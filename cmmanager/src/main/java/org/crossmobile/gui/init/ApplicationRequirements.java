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
package org.crossmobile.gui.init;

import org.crossmobile.utils.SystemDependent;

import javax.swing.*;
import java.awt.*;

import static org.crossmobile.prefs.Prefs.getAndroidSDKLocation;
import static org.crossmobile.prefs.Prefs.getJDKLocation;

public class ApplicationRequirements {

    public static boolean isAndroidConfigured() {
        return !getAndroidSDKLocation().isEmpty();
    }

    public static boolean isJDKconfigured() {
        return !getJDKLocation().isEmpty();
    }

    public static void checkJavaVersion(Component relative, Runnable andAfter) {
        new Thread(() -> {
            try {
                synchronized (Thread.currentThread()) {
                    Thread.currentThread().wait(1000);
                }
            } catch (InterruptedException ignored) {
            }
            if (SystemDependent.isJavaOld(System.getProperty("java.version")))
                JOptionPane.showOptionDialog(relative, "<html><b>Your Java version seems to be too old</b>.\n\nIt is strongly recommended to upgrade to at least\nJDK version 1.8_144 for security reasons.\n\nPlease update your system to a newer Java version,\nor you might experience connectivity issues.\n\n"
                        + "Current Java version: " + System.getProperty("java.version"), "CrossMobile", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"I will"}, 0);
            if (andAfter != null)
                andAfter.run();
        }).start();
    }

}
