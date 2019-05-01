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
 * UITableViewCellSelectionStyle class defines the style of selected cells.
 */
@CMEnum
public final class UITableViewCellSelectionStyle {

    /**
     * The selected cell has no distinct style.
     */
    public static final int None = 0;

    /**
     * The selected cell has blue background.
     */
    public static final int Blue = 1;

    /**
     * The selected cell has grey background.
     */
    public static final int Gray = 2;

    /**
     * The selected cell has the Default Background
     */
    public static final int Default = 3;

    private UITableViewCellSelectionStyle() {
    }
}
