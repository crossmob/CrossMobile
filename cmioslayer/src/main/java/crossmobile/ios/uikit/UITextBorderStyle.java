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
 * UITextBorderStyle class defines different border styles for text objects.
 */
@CMEnum
public final class UITextBorderStyle {

    /**
     * Text object without border.
     */
    public static final int None = 0;

    /**
     * Text object with a thin line border.
     */
    public static final int Line = 1;

    /**
     * The default bezel-styled border for data entry fields.
     */
    public static final int Bezel = 2;

    /**
     * Text objects with rounded-style border.
     */
    public static final int RoundedRect = 3;

    @Deprecated
    public static final int System = RoundedRect;

    private UITextBorderStyle() {
    }
}
