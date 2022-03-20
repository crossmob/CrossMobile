/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGInterpolationQuality class defines different values of interpolation
 * quality when enlarging images.
 */
@CMEnum
public final class CGInterpolationQuality {

    /**
     * The default interpolation quality.
     */
    public static final int Default = 0;

    /**
     * No interpolation.
     */
    public static final int None = 1;

    /**
     * Low interpolation quality.
     */
    public static final int Low = 2;

    /**
     * Medium interpolation quality.
     */
    public static final int Medium = 4;

    /**
     * High level interpolation quality.
     */
    public static final int High = 3;

    private CGInterpolationQuality() {
    }
}
