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
 * UITableViewCellEditingStyle class defines the style of cells in different
 * cases.
 */
@CMEnum
public final class UITableViewCellEditingStyle {

    /**
     * The default style.
     */
    public final static int None = 0;

    /**
     * A red circle with a minus sign inside, used for delete.
     */
    public final static int Delete = 1;

    /**
     * A green circle with a plus sign inside, used for insert.
     */
    public final static int Insert = 2;

    private UITableViewCellEditingStyle() {
    }
}
