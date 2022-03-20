/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITabBarItemPositioning class defines the position of a tab bar item.
 */
@CMEnum
public final class UITabBarItemPositioning {

    /**
     * The position of the item is automatically.
     */
    public static final int Automatic = 0;

    /**
     * The item is placed in the tab bar according to the rule that all items
     * are distributed in order to fill the width of the bar.
     */
    public static final int Fill = 1;

    /**
     * The item is placed in the tab bar according to the rule that items are
     * centered in the available free space.
     */
    public static final int Centered = 2;

    private UITabBarItemPositioning() {
    }

}
