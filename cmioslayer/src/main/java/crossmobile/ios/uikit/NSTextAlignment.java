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
 * NSTextAlignment class defines different styles of text alignment.
 */
@CMEnum
public final class NSTextAlignment {

    /**
     * Text aligned to the left.
     */
    public static final int Left = UITextAlignment.Left;

    /**
     * Text aligned to the right.
     */
    public static final int Center = UITextAlignment.Center;

    /**
     * Text aligned to the center.
     */
    public static final int Right = UITextAlignment.Right;

    /**
     * Text is justified.
     */
    public static final int Justified = 3;

    /**
     * Use the default alignment.
     */
    public static final int Natural = 4;

    private NSTextAlignment() {
    }
}
