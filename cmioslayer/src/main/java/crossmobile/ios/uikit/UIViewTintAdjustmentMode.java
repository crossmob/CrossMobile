/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewTintAdjustmentMode class defines different options of view tint color
 * adjustment.
 */
@CMEnum
public final class UIViewTintAdjustmentMode {

    /**
     * The view automatically adjusts its tint color to the superview's or to
     * the UIViewTintAdjustmentModeNormal if there is no superview.
     */
    public static final int Automatic = 0;

    /**
     * The view changes its tint color to the initial without changes.
     */
    public static final int Normal = 1;

    /**
     * The view changes its tint color to a desaturated color version of the
     * original.
     */
    public static final int Dimmed = 2;

    private UIViewTintAdjustmentMode() {
    }
}
