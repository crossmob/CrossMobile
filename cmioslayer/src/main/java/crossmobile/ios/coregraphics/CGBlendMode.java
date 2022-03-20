/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGBlendMode class defines different ways of assembling multiple images in
 * order to form a final image.
 */
@CMEnum
public final class CGBlendMode {

    /**
     * The effect is the result of painting the source images over the
     * background images.
     */
    public static final int Normal = 0;

    /**
     * The effect is the result of multiplying the source images with the
     * background images.
     */
    public static final int Multiply = 1;

    /**
     * The effect is the result of multiplying the inverse of the source images
     * with the inverse of the background images.
     */
    public static final int Screen = 2;

    /**
     * The effect is the result of multiplying or screening the source images
     * with the background images.
     */
    public static final int Overlay = 3;

    /**
     * The effect is the result of composing the darker background or source
     * images.
     */
    public static final int Darken = 4;

    /**
     * The effect is the result of composing the lighter background or source
     * images.
     */
    public static final int Lighten = 5;

    /**
     * The effect is the result of brightening the background image in order to
     * reflect the source image.
     */
    public static final int ColorDodge = 6;

    /**
     * The effect is the result of darkening the background image in order to
     * reflect the source image.
     */
    public static final int ColorBurn = 7;

    /**
     * The effect is a dodging or burning result after darkening or lightening
     * the background color according to source image's lightening.
     */
    public static final int SoftLight = 8;

    /**
     * The effect is a screening or multiplying result after darkening or
     * lightening the background color according to source image's lightening.
     */
    public static final int HardLight = 9;

    /**
     * The effect is the result of color subtraction(the brighter one) of source
     * image from background image or vice versa.
     */
    public static final int Difference = 10;

    /**
     * The effect is similar to Difference but with lower contrast.
     */
    public static final int Exclusion = 11;

    /**
     * The effect is a combination of background's brightness and color
     * intensity with the source image's tint color.
     */
    public static final int Hue = 12;

    /**
     * The effect is a combination of background's brightness and tint color
     * with the color intensity of the source image.
     */
    public static final int Saturation = 13;

    /**
     * The effect is a combination of background's brightness with the color
     * tint and intensity of the source image.
     */
    public static final int Color = 14;

    /**
     * The effect is a combination of background's color tint and intensity with
     * the brightness of the source image.
     */
    public static final int Luminosity = 15;

    /**
     * Applies the following Porter-Duff blend mode equation: R = 0.
     */
    public static final int Clear = 16;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S.
     */
    public static final int Copy = 17;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*Da.
     */
    public static final int SourceIn = 18;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*(1 - Da).
     */
    public static final int SourceOut = 19;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*Da + D*(1 -
     * Sa).
     */
    public static final int SourceAtop = 20;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*(1 - Da) +
     * D.
     */
    public static final int DestinationOver = 21;

    /**
     * Applies the following Porter-Duff blend mode equation: R = D*Sa.
     */
    public static final int DestinationIn = 22;

    /**
     * Applies the following Porter-Duff blend mode equation: R = D*(1 - Sa).
     */
    public static final int DestinationOut = 23;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*(1 - Da) +
     * D*Sa.
     */
    public static final int DestinationAtop = 24;

    /**
     * Applies the following Porter-Duff blend mode equation: R = S*(1 - Da) +
     * D*(1 - Sa).
     */
    public static final int XOR = 25;

    /**
     * Applies the following Porter-Duff blend mode equation: R = MAX(0, 1 - ((1
     * - D) + (1 - S))).
     */
    public static final int PlusDarker = 26;

    /**
     * Applies the following Porter-Duff blend mode equation: R = MIN(1, S + D).
     */
    public static final int PlusLighter = 27;

    private CGBlendMode() {
    }
}
