/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIControlContentVerticalAlignment class defines different types of vertical
 * alignment for the content within a control element.
 */
@CMEnum
public final class UIControlContentVerticalAlignment {

    /**
     * The content of the control element is vertically center-aligned.
     */
    public static final int Center = 0;

    /**
     * The content of the control element is vertically aligned to the top.
     */
    public static final int Top = 1;

    /**
     * The content of the control element is vertically aligned to the bottom.
     */
    public static final int Bottom = 2;

    /**
     * The content of the control element is vertically aligned so that it fills
     * the rectangle that encloses it.
     */
    public static final int Fill = 3;

    private UIControlContentVerticalAlignment() {
    }
}
