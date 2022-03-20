/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewContentMode class specifies how a view adjusts the enclosed content
 * after a change to its size.
 */
@CMEnum
public final class UIViewContentMode {

    /**
     * Scale the content to fit and change the aspect ratio of the content if
     * needed.
     */
    public static final int ScaleToFill = 0;

    /**
     * Scale the content to fit the view, maintaining the aspect ratio and any
     * remaining area of the view is transparent.
     */
    public static final int ScaleAspectFit = 1;

    /**
     * Scale the content to fill the view.
     */
    public static final int ScaleAspectFill = 2;

    /**
     * Redisplay the view when the bounds change by invoking the setNeedsDisplay
     * method.
     */
    public static final int Redraw = 3;

    /**
     * Center the content and keep the proportions the same.
     */
    public static final int Center = 4;

    /**
     * Center the content aligned at the top.
     */
    public static final int Top = 5;

    /**
     * Center the content aligned at the bottom.
     */
    public static final int Bottom = 6;

    /**
     * Align the content on the left of the view.
     */
    public static final int Left = 7;

    /**
     * Align the content on the right.
     */
    public static final int Right = 8;

    /**
     * Align the content in the top-left.
     */
    public static final int TopLeft = 9;

    /**
     * Align the content in the top-right.
     */
    public static final int TopRight = 10;

    /**
     * Align the content in the bottom-left.
     */
    public static final int BottomLeft = 11;

    /**
     * Align the content in the bottom-right corner.
     */
    public static final int BottomRight = 12;

    private UIViewContentMode() {
    }
}
