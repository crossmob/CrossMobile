/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGColorRenderingIntent class defines different options concerning handing
 * colors that are not included in the range of the color space of the a graphic
 * context.
 */
@CMEnum
public final class CGColorRenderingIntent {

    /**
     * The default rendering intent.
     */
    public static final int Default = 0;

    /**
     * Maps colors that do not belong to the range of the device into the
     * supported color space.
     */
    public static final int AbsoluteColorimetric = 1;

    /**
     * Shifts colors to adjust for the supported color space of the context.
     */
    public static final int RelativeColorimetric = 2;

    /**
     * Compresses the range of the graphics context in order to fit range of the
     * color space.
     */
    public static final int Perceptual = 3;

    /**
     * Preserves the relative saturation of the colors.
     */
    public static final int Saturation = 4;

    private CGColorRenderingIntent() {
    }

}
