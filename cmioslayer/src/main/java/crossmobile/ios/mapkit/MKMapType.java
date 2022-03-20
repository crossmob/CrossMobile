/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MKMapType class defines different types of displayed maps.
 */
@CMEnum
public final class MKMapType {

    /**
     * The default type of map that shows cartographic images of roads with
     * names.
     */
    public static final int Standard = 0;

    /**
     * The type of map that represents photos taken from space.
     */
    public static final int Satellite = 1;

    /**
     * The type of map that is a combination of the satellite images and
     * cartographic images.
     */
    public static final int Hybrid = 2;

    private MKMapType() {
    }
}
