/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MKPinAnnotationColor class defines different colors for annotation pins that
 * indicate point on the map.
 */
@CMEnum
public final class MKPinAnnotationColor {

    /**
     * A red head pin.
     */
    public static final int Red = 0;

    /**
     * A green head pin.
     */
    public static final int Green = 1;

    /**
     * A purple head pin.
     */
    public static final int Purple = 2;

    private MKPinAnnotationColor() {
    }
}
