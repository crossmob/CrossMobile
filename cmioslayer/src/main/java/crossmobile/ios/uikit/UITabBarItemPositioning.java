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
 * UITabBarItemPositioning class defines the position of a tab bar item.
 */
@CMEnum
public final class UITabBarItemPositioning {

    /**
     * The position of the item is automatically.
     */
    public static final int Automatic = 0;

    /**
     * The item is placed in the tab bar according to the rule that all items
     * are distributed in order to fill the width of the bar.
     */
    public static final int Fill = 1;

    /**
     * The item is placed in the tab bar according to the rule that items are
     * centered in the available free space.
     */
    public static final int Centered = 2;

    private UITabBarItemPositioning() {
    }

}
