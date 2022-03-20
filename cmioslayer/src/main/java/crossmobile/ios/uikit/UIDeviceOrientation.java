/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIDeviceOrientation class defines the physical orientation of the
 * device.
 */
@CMEnum
public final class UIDeviceOrientation {

    /**
     * The orientation is not detected.
     */
    public static final int Unknown = 0;

    /**
     * The orientation is portrait.
     */
    public static final int Portrait = 1;

    /**
     * The orientation is portrait but the device's home button on top.
     */
    public static final int PortraitUpsideDown = 2;

    /**
     * The orientation is landscape with the device's home button on the left.
     */
    public static final int LandscapeLeft = 3;

    /**
     * The orientation is landscape with the device's home button on the right.
     */
    public static final int LandscapeRight = 4;

    /**
     * The device is with the screen facing upwards and parallel to the ground.
     */
    public static final int FaceUp = 5;

    /**
     * The device is with the screen facing downwards and parallel to the
     * ground.
     */
    public static final int FaceDown = 6;

    private UIDeviceOrientation() {
    }
}
