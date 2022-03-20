/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISegmentedControlStyle class defines the style of the segmented control.
 */
@CMEnum
public final class UISegmentedControlStyle {

    /**
     * The segmented control has the default plain style.
     */
    public static final int Plain = 0;

    /**
     * The segmented control has large bordered style.
     */
    public static final int Bordered = 1;

    /**
     * The segmented control has small toolbar style with tint color.
     */
    public static final int Bar = 2;

    /**
     * The segmented control has large style with tint color.
     */
    public static final int Bezeled = 3;

    private UISegmentedControlStyle() {
    }
}
