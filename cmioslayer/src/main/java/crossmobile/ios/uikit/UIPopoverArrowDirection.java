/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.Foundation;
import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIPopoverArrowDirection class defines different options related to the
 * direction of a popover arrow.
 */
@CMEnum
public final class UIPopoverArrowDirection {

    /**
     * The arrow points upward.
     */
    @SuppressWarnings("PointlessBitwiseExpression")
    public static final long UIPopoverArrowDirectionUp = 1 << 0;

    /**
     * The arrow points downward.
     */
    public static final long UIPopoverArrowDirectionDown = 1 << 1;

    /**
     * The arrow points to the left.
     */
    public static final long UIPopoverArrowDirectionLeft = 1 << 2;

    /**
     * The arrow points to the right.
     */
    public static final long UIPopoverArrowDirectionRight = 1 << 3;

    /**
     * The direction of the arrow is unknown.
     */
    public static final long UIPopoverArrowDirectionUnknown = Foundation.NSUIntegerMax;

    /**
     * The arrow points to any direction.
     */
    public static final long UIPopoverArrowDirectionAny = UIPopoverArrowDirectionUp | UIPopoverArrowDirectionDown | UIPopoverArrowDirectionLeft | UIPopoverArrowDirectionRight;

    private UIPopoverArrowDirection() {

    }
}
