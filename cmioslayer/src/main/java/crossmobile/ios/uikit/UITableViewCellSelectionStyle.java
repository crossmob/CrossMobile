/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
