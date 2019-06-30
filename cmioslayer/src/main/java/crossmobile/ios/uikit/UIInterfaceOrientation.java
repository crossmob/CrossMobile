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
