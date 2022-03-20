/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGGradientDrawingOptions class defines different ways of applying color
 * gradients to specified locations.
 */
@CMEnum
public final class CGGradientDrawingOptions {

    /**
     * The color is applied beyond the specified start location.
     */
    public static final int DrawsBeforeStartLocation = 1;

    /**
     * The color is applied beyond the specified end location.
     */
    public static final int DrawsAfterEndLocation = (1 << 1);

    private CGGradientDrawingOptions() {
    }

}
