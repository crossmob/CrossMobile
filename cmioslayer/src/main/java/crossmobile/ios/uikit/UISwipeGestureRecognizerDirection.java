/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISwipeGestureRecognizerDirection class defines the direction of the swiping
 * gesture.
 */
@CMEnum
public final class UISwipeGestureRecognizerDirection {

    /**
     * The default direction of the swiping gesture is to the right.
     */
    public static final int Right = 1;

    /**
     * The swiping gesture to is set to the left.
     */
    public static final int Left = 1 << 1;

    /**
     * The swiping gesture to is set upward.
     */
    public static final int Up = 1 << 2;

    /**
     * The swiping gesture to is set downward.
     */
    public static final int Down = 1 << 3;

    private UISwipeGestureRecognizerDirection() {
    }

}
