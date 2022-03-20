/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIScrollViewIndicatorStyle class defines the style of the scroll indicator.
 */
@CMEnum
public final class UIScrollViewIndicatorStyle {

    /**
     * The scroll indicator style is the default.
     */
    public static final int Default = 0;

    /**
     * The scroll indicator is black.
     */
    public static final int Black = 1;

    /**
     * The scroll indicator is white.
     */
    public static final int White = 2;

    private UIScrollViewIndicatorStyle() {
    }
}
