/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
