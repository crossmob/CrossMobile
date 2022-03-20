/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
