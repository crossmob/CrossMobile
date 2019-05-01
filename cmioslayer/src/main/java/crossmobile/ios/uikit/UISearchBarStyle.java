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
 * UISearchBarStyle class defines the style of the search bar.
 */
@CMEnum
public final class UISearchBarStyle {

    /**
     * The search bar with default style.
     */
    public static final int Default = 0;

    /**
     * The search bar with a translucent background and opaque search field.
     */
    public static final int Prominent = 1;

    /**
     * The search bar with no background and translucent search field.
     */
    public static final int Minimal = 2;

    private UISearchBarStyle() {
    }

}
