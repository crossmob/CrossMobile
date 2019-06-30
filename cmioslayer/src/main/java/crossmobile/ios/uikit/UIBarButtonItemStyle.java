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
 * UIBarButtonItemStyle class defines styles for different button item types.
 */
@CMEnum
public final class UIBarButtonItemStyle {

    /**
     * The default button item that is highlighted when tapped.
     */
    public static final int Plain = 0;

    /**
     * A plain, bordered button item.
     */
    public static final int Bordered = 1;

    /**
     * A style for a button that indicates the completion of a task.
     */
    public static final int Done = 2;

    private UIBarButtonItemStyle() {
    }
}
