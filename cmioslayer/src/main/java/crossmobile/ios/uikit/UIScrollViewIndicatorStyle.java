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
 * UIScrollViewIndicatorStyle class defines the style of the scroll indicator.
 */
@CMEnum
public final class UIScrollViewIndicatorStyle {

    /**
     * The scroll indicator style is the default.
     */
    public static final int Default = 0;

    /**
     * The scroll indicator is black.
     */
    public static final int Black = 1;

    /**
     * The scroll indicator is white.
     */
    public static final int White = 2;

    private UIScrollViewIndicatorStyle() {
    }
}
