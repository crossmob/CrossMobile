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
 * CGInterpolationQuality class defines different values of interpolation
 * quality when enlarging images.
 */
@CMEnum
public final class CGInterpolationQuality {

    /**
     * The default interpolation quality.
     */
    public static final int Default = 0;

    /**
     * No interpolation.
     */
    public static final int None = 1;

    /**
     * Low interpolation quality.
     */
    public static final int Low = 2;

    /**
     * Medium interpolation quality.
     */
    public static final int Medium = 4;

    /**
     * High level interpolation quality.
     */
    public static final int High = 3;

    private CGInterpolationQuality() {
    }
}
