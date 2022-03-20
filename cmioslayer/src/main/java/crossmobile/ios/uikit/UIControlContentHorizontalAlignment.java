/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIControlContentVerticalAlignment class defines different types of horizontal
 * alignment for the content within a control element.
 */
@CMEnum
public final class UIControlContentHorizontalAlignment {

    /**
     * The content of the control element is horizontally center-aligned.
     */
    public static final int Center = 0;

    /**
     * The content of the control element is horizontally aligned to the left.
     */
    public static final int Left = 1;

    /**
     * The content of the control element is horizontally aligned to the right.
     */
    public static final int Right = 2;

    /**
     * The content of the control element is horizontally aligned so that it
     * fills the rectangle that encloses it.
     */
    public static final int Fill = 3;
    /**
     * The content of the control element is horizontally aligned to the left for
     * left-to-right languages and to the right for right-to-left languages.
     */
    public static final int Leading = 4;
    /**
     * The content of the control element is horizontally aligned to the right for
     * * left-to-right languages and to the left for right-to-left languages.
     */
    public static final int Trailing = 5;

    private UIControlContentHorizontalAlignment() {
    }
}
