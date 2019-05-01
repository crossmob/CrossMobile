/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
