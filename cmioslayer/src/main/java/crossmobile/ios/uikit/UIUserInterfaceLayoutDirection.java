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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIUserNotificationType class defines  the layout alignment of the
 * elements based on the language settings.
 */
@CMEnum
public final class UIUserInterfaceLayoutDirection {
    /**
     * Direction is left to right.
     */
    public static final int LeftToRight = 0;

    /**
     * Direction is right to left.
     */
    public static final int RightToLeft = 1;


    private UIUserInterfaceLayoutDirection() {
    }
}
