/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
