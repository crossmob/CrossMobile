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

    public static boolean isJDKfigured() {
        return !getJDKLocation().isEmpty();
    }

    public static void checkJavaVersion(Component relative, Runnable andAfter) {
        new Thread(() -> {
            try {
                synchronized (Thread.currentThread()) {
                    Thread.currentThread().wait(1000);
                }
            } catch (InterruptedException ex) {
            }
            if (SystemDependent.isJavaOld(System.getProperty("java.version")))
                JOptionPane.showOptionDialog(relative, "<html><b>Your Java version seems to be too old</b>.\n\nIt is strongly recommended to upgrade to at least\nJDK version 1.8_144 for security reasons.\n\nPlease update your system to a newer Java version,\nor you might experience connectivity issues.\n\n"
                        + "Currenct Java version: " + System.getProperty("java.version"), "CrossMobile", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new String[]{"I will"}, 0);
            if (andAfter != null)
                andAfter.run();
        }).start();
    }

}
