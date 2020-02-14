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
 * UIControlContentVerticalAlignment class defines different types of vertical
 * alignment for the content within a control element.
 */
@CMEnum
public final class UIControlContentVerticalAlignment {

    /**
     * The content of the control element is vertically center-aligned.
     */
    public static final int Center = 0;

    /**
     * The content of the control element is vertically aligned to the top.
     */
    public static final int Top = 1;

    /**
     * The content of the control element is vertically aligned to the bottom.
     */
    public static final int Bottom = 2;

    /**
     * The content of the control element is vertically aligned so that it fills
     * the rectangle that encloses it.
     */
    public static final int Fill = 3;

    private UIControlContentVerticalAlignment() {
    }
}
