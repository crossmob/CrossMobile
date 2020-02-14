/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CLDeviceOrientation class defines different types of orientations concerning
 * the physical orientation of the device.
 */
@CMEnum
public final class CLDeviceOrientation {

    /**
     * The orientation of the device is unknown.
     */
    public static final int Unknown = 0;

    /**
     * The device is held vertically with home button at the bottom.
     */
    public static final int Portrait = 1;

    /**
     * The device is held vertically with home button at the top.
     */
    public static final int PortraitUpsideDown = 2;

    /**
     * The device is held horizontally with home button on the right side.
     */
    public static final int LandscapeLeft = 3;

    /**
     * The device is held horizontally with home button on the left side.
     */
    public static final int LandscapeRight = 4;

    /**
     * The device is held parallel to the ground with the screen upwards.
     */
    public static final int FaceUp = 5;

    /**
     * The device is held parallel to the ground with the screen downwards.
     */
    public static final int FaceDown = 6;

    private CLDeviceOrientation() {
    }
}
