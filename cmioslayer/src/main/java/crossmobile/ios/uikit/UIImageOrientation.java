/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIImageOrientation class defines different types of orientations for images.
 */
@CMEnum
public final class UIImageOrientation {

    /**
     * The default orientation of an image.
     */
    public static final int Up = 0;

    /**
     * The image is rotated 180 degrees from its original position and it appears upside down.
     */
    public static final int Down = 1;

    /**
     * The image is rotated 90 degrees clockwise from its original position.
     */
    public static final int Left = 2;

    /**
     * The image is rotated 90 degrees anti-clockwise from its original position.
     */
    public static final int Right = 3;

    /**
     * The image is rotated 180 degrees around the y axis from its original position.
     */
    public static final int UpMirrored = 4;

    /**
     * The image is rotated 180 degrees around the x axis from its original position.
     */
    public static final int DownMirrored = 5;

    /**
     * The image is rotated 180 degrees around the y axis and then rotated 90 degrees anticlockwise.
     */
    public static final int LeftMirrored = 6;

    /**
     * The image is rotated 180 degrees around the y axis and then rotated 90 degrees clockwise.
     */
    public static final int RightMirrored = 7;

    private UIImageOrientation() {
    }
}
