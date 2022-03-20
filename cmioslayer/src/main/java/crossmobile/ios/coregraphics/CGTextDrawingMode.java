/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGTextDrawingMode class defines different text drawing modes.
 */
@CMEnum
public final class CGTextDrawingMode {

    /**
     * Applies fill operation on the text symbols.
     */
    public static final int Fill = 0;

    /**
     * Applies stroke style on text symbols.
     */
    public static final int Stroke = 1;

    /**
     * Applies fill operation and then stroke operation on the text.
     */
    public static final int FillStroke = 2;

    /**
     * Updates the position of the text.
     */
    public static final int Invisible = 3;

    /**
     * Applies fill operation and then intersects with the clipping path.
     */
    public static final int FillClip = 4;

    /**
     * Applies stroke operation to the text and then intersects the result with
     * the clipping path.
     */
    public static final int StrokeClip = 5;

    /**
     * Applies stroke operation, then fill operation and finally intersects with
     * clipping path.
     */
    public static final int FillStrokeClip = 6;

    /**
     * Intersects the text with the clipping path.
     */
    public static final int Clip = 7;

    private CGTextDrawingMode() {
    }
}
