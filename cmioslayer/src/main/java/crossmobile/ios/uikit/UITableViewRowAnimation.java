/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITableViewRowAnimation class defines different types of animations that are
 * used for rows when added or deleted from a table one by one or as a block.
 */
@CMEnum
public final class UITableViewRowAnimation {

    /**
     * The row(or rows) fades in or out when added or deleted.
     */
    public static final int Fade = 0;

    /**
     * The row(or rows) slides in or out from the right or to the right.
     */
    public static final int Right = 1;

    /**
     * The row(or rows) slides in or out from the left or to the left.
     */
    public static final int Left = 2;

    /**
     * The row(or rows) slides in or out from the top or to the top.
     */
    public static final int Top = 3;

    /**
     * The row(or rows) slides in or out from the bottom or to the bottom.
     */
    public static final int Bottom = 4;

    /**
     * The default animation used for the row(or rows).
     */
    public static final int None = 5;

    private UITableViewRowAnimation() {
    }
}
