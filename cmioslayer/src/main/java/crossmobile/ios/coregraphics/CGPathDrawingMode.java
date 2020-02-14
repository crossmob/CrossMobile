/*
 * (c) 2020 by Panayotis Katsaloulis
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
