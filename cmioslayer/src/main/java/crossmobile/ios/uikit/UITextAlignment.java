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
 * UITextAlignment class defines different styles of text alignment.
 */
@CMEnum
public final class UITextAlignment {

    /**
     * Text aligned to the left.
     */
    public static final int Left = 0;

    /**
     * Text aligned to the right.
     */
    public static final int Center = 1;

    /**
     * Text aligned to the center.
     */
    public static final int Right = 2;

    private UITextAlignment() {
    }
}
