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
 * CGColorRenderingIntent class defines different options concerning handing
 * colors that are not included in the range of the color space of the a graphic
 * context.
 */
@CMEnum
public final class CGColorRenderingIntent {

    /**
     * The default rendering intent.
     */
    public static final int Default = 0;

    /**
     * Maps colors that do not belong to the range of the device into the
     * supported color space.
     */
    public static final int AbsoluteColorimetric = 1;

    /**
     * Shifts colors to adjust for the supported color space of the context.
     */
    public static final int RelativeColorimetric = 2;

    /**
     * Compresses the range of the graphics context in order to fit range of the
     * color space.
     */
    public static final int Perceptual = 3;

    /**
     * Preserves the relative saturation of the colors.
     */
    public static final int Saturation = 4;

    private CGColorRenderingIntent() {
    }

}
