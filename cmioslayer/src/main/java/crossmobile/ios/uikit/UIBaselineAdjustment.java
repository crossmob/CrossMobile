/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIBaselineAdjustment class defines different text alignment options. *
 */
@CMEnum
public final class UIBaselineAdjustment {

    /**
     * The alignment of the text is done according to its font baseline.
     */
    public static final int AlignBaselines = 0;

    /**
     * The text is aligned to the center of the box that includes it.
     */
    public static final int AlignCenters = 1;

    /**
     * There is no alignment for the text.
     */
    public static final int None = 2;

    private UIBaselineAdjustment() {
    }

}
