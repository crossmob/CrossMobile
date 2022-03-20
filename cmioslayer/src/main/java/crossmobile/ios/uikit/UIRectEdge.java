/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIRectEdge class specifies the edges of a rectangle.
 */
@CMEnum
public final class UIRectEdge {

    /**
     * A rectangle without edges.
     */
    public static final int None = 0;

    /**
     * A rectangle that has only the top edge.
     */
    public static final int Top = 1 << 0;

    /**
     * A rectangle that has only the left edge.
     */
    public static final int Left = 1 << 1;

    /**
     * A rectangle that has only the bottom edge.
     */
    public static final int Bottom = 1 << 2;

    /**
     * A rectangle that has only the right edge.
     */
    public static final int Right = 1 << 3;

    /**
     * A rectangle that has all the edges.
     */
    public static final int UIRectEdgeAll = Top | Left | Bottom | Right;

    private UIRectEdge() {
    }
}
