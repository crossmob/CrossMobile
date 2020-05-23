/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

public class $foundation {

    public static void quitTimers() {
        NSRunLoop.mainRunLoop().invalidateAll();
    }

    public static boolean isUnderMainRunLoop() {
        return NSRunLoop.isUnderMainRunLoop();
    }

}
