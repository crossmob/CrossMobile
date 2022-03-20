/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITableViewCellSeparatorStyle class defines the style used for separator
 * cells.
 */
@CMEnum
public final class UITableViewCellSeparatorStyle {

    /**
     * No style for separator cell.
     */
    public static final int None = 0;

    /**
     * The default style for separator cell.
     */
    public static final int SingleLine = 1;

    private UITableViewCellSeparatorStyle() {
    }
}
