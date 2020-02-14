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
 * UIViewAutoresizing class specifies different options for view autoresizing.
 */
@CMEnum
public final class UIViewAutoresizing {

    /**
     * The view does not resize.
     */
    public static final int None = 0;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleLeftMargin = 1;

    /**
     * The view resizes its width.
     */
    public static final int FlexibleWidth = 1 << 1;

    /**
     * The view resizes its width towards the left margin.
     */
    public static final int FlexibleRightMargin = 1 << 2;

    /**
     * The view resizes its height towards the top margin.
     */
    public static final int FlexibleTopMargin = 1 << 3;

    /**
     * The view increases its height.
     */
    public static final int FlexibleHeight = 1 << 4;

    /**
     * The view resizes its height towards the bottom margin.
     */
    public static final int FlexibleBottomMargin = 1 << 5;

    private UIViewAutoresizing() {
    }
}
