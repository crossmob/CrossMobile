/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewAutoresizing class specifies different options for view autoresizing.
 */
@CMEnum
public final class UIViewAutoresizing {

    /**
     * The view does not resize.
     */
    public static final int None = 0;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleLeftMargin = 1;

    /**
     * The view resizes its width.
     */
    public static final int FlexibleWidth = 1 << 1;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleRightMargin = 1 << 2;

    /**
     * The view resizes its height towards the top margin.
     */
    public static final int FlexibleTopMargin = 1 << 3;

    /**
     * The view increases its height.
     */
    public static final int FlexibleHeight = 1 << 4;

    /**
     * The view resizes its height towards the bottom margin.
     */
    public static final int FlexibleBottomMargin = 1 << 5;

    private UIViewAutoresizing() {
    }
}
