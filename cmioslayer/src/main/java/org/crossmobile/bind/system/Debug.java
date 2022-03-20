/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import com.panayotis.ce.CEventManager;
import org.crossmobile.bridge.Native;

import static com.panayotis.ce.CEventCommons.*;

public class Debug {

    public static final boolean ENABLE_DEBUG = true;

    public static boolean Live_Graphics_Debug = false;
    public static boolean Live_Touch_Debug = false;
    public static boolean Ignore_Touches = false;

    public static boolean Full_Debug = false;

    public static void init() {
        if (ENABLE_DEBUG) {
            CEventManager.addListener(meta -> {
                Live_Graphics_Debug = meta instanceof Boolean ? (Boolean) meta : false;
                Native.graphics().refreshDisplay();
            }, CHANGE_DEBUG_GRAPHICS);
            CEventManager.addListener(meta -> {
                Live_Touch_Debug = meta instanceof Boolean ? (Boolean) meta : false;
                Native.graphics().refreshDisplay();
            }, CHANGE_DEBUG_TOUCH);
            CEventManager.addListener(meta -> {
                Ignore_Touches = meta instanceof Boolean ? (Boolean) meta : false;
            }, CHANGE_ENABLE_TOUCH);
        }
    }
}
