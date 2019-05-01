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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMBundle;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

/**
 * NSLog class is used in order to log messages related to errors.
 */
@CMLib(target = CMLibTarget.API_NOUWP)
@CMBundle
public final class NSLog {

    private NSLog() {
    }

    /**
     * Logs the specified arguments by using the provided format.
     *
     * @param format The format to use
     * @param args   The list of arguments
     */
    @CMFunction(value = "void NSLog(NSString *format, ...);",
            swiftVarArgMethod = "NSLogv(format as String, va_array)")
    public static void log(String format, Object... args) {
        Native.system().error(NSString.initWithFormat(format, args), null);
    }
}
