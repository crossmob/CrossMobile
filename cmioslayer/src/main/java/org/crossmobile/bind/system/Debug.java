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
