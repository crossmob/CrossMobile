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
 * UITextAlignment class defines different styles of text alignment.
 */
@CMEnum
public final class UITextAlignment {

    /**
     * Text aligned to the left.
     */
    public static final int Left = 0;

    /**
     * Text aligned to the right.
     */
    public static final int Center = 1;

    /**
     * Text aligned to the center.
     */
    public static final int Right = 2;

    private UITextAlignment() {
    }
}
