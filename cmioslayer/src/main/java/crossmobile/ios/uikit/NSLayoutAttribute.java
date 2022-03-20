/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSLayoutAttribute class defines the different parts of an object's visual
 * representation that are used as a constraint of the layout.
 */
@CMEnum
public final class NSLayoutAttribute {

    /**
     * The left side of the object's rectangle.
     */
    public static final int Left = 1;

    /**
     * The right side of the object's rectangle.
     */
    public static final int Right = 2;

    /**
     * The top side of the object's rectangle.
     */
    public static final int Top = 3;

    /**
     * The bottom side of the object's rectangle.
     */
    public static final int Bottom = 4;

    /**
     * The leading edge of the object's rectangle.
     */
    public static final int Leading = 5;

    /**
     * The trailing edge of the object's rectangle.
     */
    public static final int Trailing = 6;

    /**
     * The width of the object's rectangle.
     */
    public static final int Width = 7;

    /**
     * The height of the object's rectangle.
     */
    public static final int Height = 8;

    /**
     * The center of the width of the object.
     */
    public static final int CenterX = 9;

    /**
     * The center of the height of the object.
     */
    public static final int CenterY = 10;

    /**
     * The object’s baseline.
     */
    public static final int Baseline = 11;

    /**
     * The object’s last baseline.
     */
    public static final int LastBaseline = Baseline;

    /**
     * The object’s first baseline.
     */
    public static final int FirstBaseline = 12;

    /**
     * The left margin of the object.
     */
    public static final int LeftMargin = 13;

    /**
     * The right margin of the object.
     */
    public static final int RightMargin = 14;

    /**
     * The top margin of the object.
     */
    public static final int TopMargin = 15;

    /**
     * The bottom margin of the object.
     */
    public static final int BottomMargin = 16;

    /**
     * The leading margin of the object.
     */
    public static final int LeadingMargin = 17;

    /**
     * The trailing margin of the object.
     */
    public static final int TrailingMargin = 18;

    /**
     * The center between left and right margin of the object.
     */
    public static final int CenterXWithinMargins = 19;

    /**
     * The center between top and bottom margin of the object.
     */
    public static final int CenterYWithinMargins = 20;

    /**
     * No attribute of the object's rectangle use for the layout's constraint.
     */
    public static final int NotAnAttribute = 0;

    private NSLayoutAttribute() {
    }

}
