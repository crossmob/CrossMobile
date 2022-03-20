/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITextBorderStyle class defines different border styles for text objects.
 */
@CMEnum
public final class UITextBorderStyle {

    /**
     * Text object without border.
     */
    public static final int None = 0;

    /**
     * Text object with a thin line border.
     */
    public static final int Line = 1;

    /**
     * The default bezel-styled border for data entry fields.
     */
    public static final int Bezel = 2;

    /**
     * Text objects with rounded-style border.
     */
    public static final int RoundedRect = 3;

    @Deprecated
    public static final int System = RoundedRect;

    private UITextBorderStyle() {
    }
}
