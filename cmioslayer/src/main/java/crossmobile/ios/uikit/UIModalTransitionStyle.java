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
 * UIModalTransitionStyle class defines different transition styles for view
 * controllers.
 */
@CMEnum
public final class UIModalTransitionStyle {

    /**
     * The default style of a view controller that slides up from the bottom of
     * the screen and then slides again back down.
     */
    public static final int CoverVertical = 0;

    /**
     * The current view controller flips from right to the left and reveals the
     * new view controller and then from left to the right is revealed the
     * previous controller.
     */
    public static final int FlipHorizontal = 1;

    /**
     * The current view fades out and the new fades in while on return happens
     * the opposite revealing.
     */
    public static final int CrossDissolve = 2;

    /**
     * Current view curls up from one corner revealing new view and on return
     * happens the opposite.
     */
    public static final int PartialCurl = 3;

    private UIModalTransitionStyle() {
    }
}
