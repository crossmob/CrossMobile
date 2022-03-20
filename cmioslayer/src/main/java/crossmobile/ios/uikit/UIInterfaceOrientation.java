/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIInterfaceOrientation defines different types of orientations for the user
 * interface of the application.
 */
@CMEnum
public final class UIInterfaceOrientation {

    /**
     * The interface orientation is set to be portrait.
     */
    public static final int Portrait = UIDeviceOrientation.Portrait;

    /**
     * The interface orientation is set to be portrait but upside down.
     */
    public static final int PortraitUpsideDown = UIDeviceOrientation.PortraitUpsideDown;

    /**
     * The interface orientation is set to be landscape with the home button to
     * the left.
     */
    public static final int LandscapeLeft = UIDeviceOrientation.LandscapeLeft;

    /**
     * The interface orientation is set to be portrait with the home button to
     * the right.
     */
    public static final int LandscapeRight = UIDeviceOrientation.LandscapeRight;

    private UIInterfaceOrientation() {
    }
}
