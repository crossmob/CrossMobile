/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
