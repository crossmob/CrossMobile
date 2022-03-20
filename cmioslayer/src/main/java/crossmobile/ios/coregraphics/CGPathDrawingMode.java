/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGPathDrawingMode class defines different drawing modes.
 */
@CMEnum
public final class CGPathDrawingMode {

    /**
     * Fills the path area using the non-zero winding rule.
     */
    public static final int Fill = 0;

    /**
     * Fills the path area using the even-odd rule.
     */
    public static final int EOFill = 1;

    /**
     * Renders the path with a line.
     */
    public static final int Stroke = 2;

    /**
     * Fills the path and then strokes it with the non-zero winding rule.
     */
    public static final int FillStroke = 3;

    /**
     * Fills the path and then strokes it with the even-odd rule.
     */
    public static final int EOFillStroke = 4;

    private CGPathDrawingMode() {
    }
}
