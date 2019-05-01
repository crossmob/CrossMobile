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
 * NSSearchPathDomainMask class defines different base locations of paths used
 * by the NSFileManager.
 */
@CMEnum
public final class NSSearchPathDomainMask {

    /**
     * The user's home directory.
     */
    public static final int UserDomain = 1;

    /**
     * The local domain.
     */
    public static final int LocalDomain = 2;

    /**
     * The network domain.
     */
    public static final int NetworkDomain = 4;

    /**
     * The system domain.
     */
    public static final int SystemDomain = 8;

    /**
     * All the domains.
     */
    public static final int AllDomains = 0x0ffff;

    private NSSearchPathDomainMask() {
    }
}
