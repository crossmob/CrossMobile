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

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSRunLoopMode class defines different loop modes for the NSRunLoop.
 */
@CMEnum
public final class NSRunLoopMode {

    /**
     * The default loop mode for handling input sources.
     */
    public static final String Default = "NSDefaultRunLoopMode";

    /**
     * The loop mode for objects that belong to the common modes set.
     */
    public static final String Common = "NSRunLoopCommonModes";

    private NSRunLoopMode() {
    }

}
