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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UISwipeGestureRecognizerDirection class defines the direction of the swiping
 * gesture.
 */
@CMEnum
public final class UISwipeGestureRecognizerDirection {

    /**
     * The default direction of the swiping gesture is to the right.
     */
    public static final int Right = 1;

    /**
     * The swiping gesture to is set to the left.
     */
    public static final int Left = 1 << 1;

    /**
     * The swiping gesture to is set upward.
     */
    public static final int Up = 1 << 2;

    /**
     * The swiping gesture to is set downward.
     */
    public static final int Down = 1 << 3;

    private UISwipeGestureRecognizerDirection() {
    }

}
