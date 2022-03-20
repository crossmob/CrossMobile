/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITableViewScrollPosition class defines different types of row scrolling for
 * table views.
 */
@CMEnum
public final class UITableViewScrollPosition {

    /**
     * The default scrolling view. The preferred row is fully visible.
     */
    public static final int None = 0;

    /**
     * The preferred row is scrolled to the top.
     */
    public static final int Top = 1;

    /**
     * The preferred row is scrolled in the middle.
     */
    public static final int Middle = 2;

    /**
     * The preferred row is scrolled to the bottom.
     */
    public static final int Bottom = 3;

    private UITableViewScrollPosition() {
    }
}
