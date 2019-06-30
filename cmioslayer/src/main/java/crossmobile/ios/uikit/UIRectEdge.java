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
