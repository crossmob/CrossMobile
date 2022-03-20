/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CLLocationAccuracy class defines different values concerning the accuracy of
 * a location.
 */
@CMEnum
public final class CLLocationAccuracy {

    /**
     * Represents the highest level of accuracy that is a combination of extra
     * sensor data and is used for navigation applications.
     */
    public static final double BestForNavigation = -2;

    /**
     * Represents the highest level of accuracy.
     */
    public static final double Best = -1;

    /**
     * Represents the accuracy within 10m.
     */
    public static final double NearestTenMeters = 10;

    /**
     * Represents the accuracy within 100m.
     */
    public static final double HundredMeters = 100;

    /**
     * Represents the accuracy within 1km.
     */
    public static final double Kilometer = 1000;

    /**
     * Represents the accuracy within 3km.
     */
    public static final double ThreeKilometers = 3000;

    private CLLocationAccuracy() {
    }
}
