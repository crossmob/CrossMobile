/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIUserInterfaceStyle class defines whether a light or a dark theme is selected.
 */
@CMEnum
public final class UIUserInterfaceStyle {

    /**
     * The default style; inherit from parent UIView
     */
    public static final int Unspecified = 0;

    /**
     * A light style is selected
     */
    public static final int Light = 1;

    /**
     * A light style is selected
     */
    public static final int Dark = 2;

    private UIUserInterfaceStyle() {
    }
}
