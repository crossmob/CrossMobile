/*
 * (c) 2019 by Panayotis Katsaloulis
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

package org.crossmobile.bind.system;

import com.panayotis.ce.CEventManager;
import org.crossmobile.bridge.Native;

import static com.panayotis.ce.CEventCommons.*;

public class Debug {

    public static final boolean ENABLE_DEBUG = true;

    public static boolean Live_Graphics_Debug = false;
    public static boolean Live_Touch_Debug = false;
    public static boolean Ignore_Touches = false;

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
