/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.corelocation.CLLocation;

public interface LocationBridge {

    boolean supportsCoarseLocations();

    boolean supportsFineLocations();

    void preferCoarseUpdating();

    void preferFineUpdating();

    void startUpdating(LocationChangeDelegate delegate);

    void stopUpdating(LocationChangeDelegate delegate);

    CLLocation lastKnownLocation();

    interface LocationChangeDelegate {

        void updateLocation(double latitude, double longitude);
    }
}
