/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIStackViewAlignment class defines different types of alignment for subviews
 * that are perpendicular to the stack view's axis.
 */
@CMEnum
public final class UIStackViewAlignment {

    /**
     * The views are enlarged so that they fill the available space
     * perpendicular to the stack view's axis.
     */
    public final static int Fill = 0;

    /**
     * The views of a vertical stack view are placed so that the leading edge of
     * each one aligns with the leading edge of the stack view.
     */
    public final static int Leading = 1;

    /**
     * The views of a horizontal stack view are placed so that the top edge of
     * each one aligns with the top edge of the stack view.
     */
    public final static int Top = Leading;

    /**
     * The views of a horizontal stack view are placed so that all the first
     * baselines of all the views are aligned.
     */
    public final static int FirstBaseline = 2; // Valid for horizontal axis only 

    /**
     * The views are placed so that the center of each one is aligned to stack
     * view axis.
     */
    public final static int Center = 3;

    /**
     * The views of a vertical stack view are placed so that the trailing edge
     * of each one is aligned to the trailing edge of the stack view.
     */
    public final static int Trailing = 4;

    /**
     * The views of a horizontal stack view are placed so that the bottom edge
     * of each one aligns with the bottom edge of the stack view.
     */
    public final static int Bottom = Trailing;

    /**
     * The views of a horizontal stack view are placed so that all the last
     * baselines of all the views are aligned.
     */
    public final static int LastBaseline = 5; // Valid for horizontal axis only 

    private UIStackViewAlignment() {
    }

}
