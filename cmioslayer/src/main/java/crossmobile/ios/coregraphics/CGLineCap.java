/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGLineCap class defines different styles of ending points of lines.
 */
@CMEnum
public final class CGLineCap {

    /**
     * The line's tail is squared-cut.
     */
    public static final int Butt = 0;

    /**
     * The line's tail is rounded.
     */
    public static final int Round = 1;

    /**
     * The line's tail is squared.
     */
    public static final int Square = 2;

    private CGLineCap() {
    }
}
