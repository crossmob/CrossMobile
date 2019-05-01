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
 * CGLineJoin class defines different types of joining stroked lines when they
 * shape an angle.
 */
@CMEnum
public final class CGLineJoin {

    /**
     * The bond of the two stroked lines shapes a sharp corner.
     */
    public static final int Miter = 0;

    /**
     * The bond of the two stroked lines shapes a rounded corner.
     */
    public static final int Round = 1;

    /**
     * The bond of the two stroked lines shapes a beveled corner.
     */
    public static final int Bevel = 2;

    private CGLineJoin() {
    }
}
