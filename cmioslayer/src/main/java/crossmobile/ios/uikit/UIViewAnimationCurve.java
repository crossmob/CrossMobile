/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewAnimationCurve class specifies the different types of animation curves.
 */
@CMEnum
public final class UIViewAnimationCurve {

    /**
     * The animation curve starts slowly and continues slowly.The default one.
     */
    public static final int EaseInOut = 0;

    /**
     * The animation curve starts slowly and then speeds up.
     */
    public static final int EaseIn = 1;

    /**
     * The animation curve starts quickly and then slows down.
     */
    public static final int EaseOut = 2;

    /**
     * The animation proceeds evenly.
     */
    public static final int Linear = 3;

    private UIViewAnimationCurve() {
    }
}
