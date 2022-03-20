/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
