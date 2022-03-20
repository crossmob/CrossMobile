/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UILayoutPriority class defines values that indicate priorities of
 * restrictions for the constraint based layout system.
 */
@CMEnum
public final class UILayoutPriority {

    /**
     * A required priority constraint that restricts all layout constraints to
     * exceed this value.
     */
    public static final float Required = 1000;

    /**
     * The priority related to a view's content compressing resistance.
     */
    public static final float DefaultHigh = 750;

    /**
     * The priority related to the way a view horizontally encloses its content.
     */
    public static final float DefaultLow = 250;

    /**
     * The priority related to a view's resistance to comply with a size
     * computed to fit the layout.
     */
    public static final float FittingSizeLevel = 50;

    private UILayoutPriority() {
    }
}
