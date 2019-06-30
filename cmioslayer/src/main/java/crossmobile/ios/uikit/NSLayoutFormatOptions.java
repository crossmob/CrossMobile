/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSLayoutFormatOptions class defines different types of interface alignment
 * and direction alignment in case of two or more interface elements.
 */
@CMEnum
public final class NSLayoutFormatOptions {

    /**
     * Applies left alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllLeft = NSLayoutAttribute.Left;

    /**
     * Applies right alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllRight = NSLayoutAttribute.Right;

    /**
     * Applies top alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllTop = NSLayoutAttribute.Top;

    /**
     * Applies bottom alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllBottom = NSLayoutAttribute.Bottom;

    /**
     * Applies left alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllLeading = NSLayoutAttribute.Leading;

    /**
     * Applies trailing alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllTrailing = NSLayoutAttribute.Trailing;

    /**
     * Applies CenterX alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllCenterX = NSLayoutAttribute.CenterX;

    /**
     * Applies CenterY alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllCenterY = NSLayoutAttribute.CenterY;

    /**
     * Applies baseline alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignAllBaseline = NSLayoutAttribute.Baseline;

    /**
     * Applies CenterX alignment to the interface elements according to the
     * NSLayoutAttribute.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int AlignmentMask = 0xFF;

    /**
     * Applies an alignment to the objects according to the normal direction of
     * the text based on the language.(e.g. English vs Chinese)
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int DirectionLeadingToTrailing = 0 << 8;

    /**
     * Applies a left to right alignment to the objects.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int DirectionLeftToRight = 1 << 8;

    /**
     * Applies a right to left alignment to the objects.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int DirectionRightToLeft = 2 << 8;

    /**
     * This attribute applied returns only for the direction of the format.
     *
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    public static final int DirectionMask = 0x3 << 8;

    private NSLayoutFormatOptions() {
    }
}
