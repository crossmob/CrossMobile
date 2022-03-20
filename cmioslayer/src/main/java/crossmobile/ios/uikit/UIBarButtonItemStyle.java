/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIBarButtonItemStyle class defines styles for different button item types.
 */
@CMEnum
public final class UIBarButtonItemStyle {

    /**
     * The default button item that is highlighted when tapped.
     */
    public static final int Plain = 0;

    /**
     * A plain, bordered button item.
     */
    public static final int Bordered = 1;

    /**
     * A style for a button that indicates the completion of a task.
     */
    public static final int Done = 2;

    private UIBarButtonItemStyle() {
    }
}
