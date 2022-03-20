/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIInterfaceOrientationMask class defines different types of supported
 * orientations for the view controller interface.
 */
@CMEnum
public final class UIInterfaceOrientationMask {

    /**
     * The supported orientation of the view controller is portrait.
     */
    public static final int Portrait = (1 << UIInterfaceOrientation.Portrait);

    /**
     * The supported orientation of the view controller is landscape-left.
     */
    public static final int LandscapeLeft = (1 << UIInterfaceOrientation.LandscapeLeft);

    /**
     * The supported orientation of the view controller is landscape-right.
     */
    public static final int LandscapeRight = (1 << UIInterfaceOrientation.LandscapeRight);

    /**
     * The supported orientation of the view controller is portrait upside down.
     */
    public static final int PortraitUpsideDown = (1 << UIInterfaceOrientation.PortraitUpsideDown);

    /**
     * The supported orientation of the view controller is landscape (left or
     * right).
     */
    public static final int Landscape = (LandscapeLeft | LandscapeRight);

    /**
     * The view controller supports all the orientations.
     */
    public static final int All = (Portrait | LandscapeLeft | LandscapeRight | PortraitUpsideDown);

    /**
     * The view controller supports all the orientations except for the portrait
     * upside down.
     */
    public static final int AllButUpsideDown = (Portrait | LandscapeLeft | LandscapeRight);

    private UIInterfaceOrientationMask() {
    }
}
