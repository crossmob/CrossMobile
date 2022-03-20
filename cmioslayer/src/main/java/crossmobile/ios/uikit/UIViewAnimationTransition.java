/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewAnimationTransition class specifies the transition of a view.
 */
@CMEnum
public final class UIViewAnimationTransition {

    /**
     * There is no transition specified.
     */
    public static final int None = 0;

    /**
     * The view flips from left to right.
     */
    public static final int FlipFromLeft = 1;

    /**
     * The view flips from right to left.
     */
    public static final int FlipFromRight = 2;

    /**
     * The view whirls up from the bottom.
     */
    public static final int CurlUp = 3;

    /**
     * The view whirls down from the top.
     */
    public static final int CurlDown = 4;

    static final int CrossDissolve = 5;
    static final int FlipFromTop = 6;
    static final int FlipFromBottom = 7;

    private UIViewAnimationTransition() {
    }
}
