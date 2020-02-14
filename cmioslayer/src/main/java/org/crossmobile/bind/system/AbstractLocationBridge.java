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
package org.crossmobile.bind.system;

import crossmobile.ios.corelocation.CLLocation;
import org.crossmobile.bridge.LocationBridge;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class AbstractLocationBridge implements LocationBridge {

    private double lastLat = 0, lastLon = 0;
    private final Map<LocationChangeDelegate, Object> delegates = new WeakHashMap<>();
    private final LocationChangeDelegate singletonDelegate = (latitude, longitude) -> {
        lastLat = latitude;
        lastLon = longitude;
        for (LocationChangeDelegate delegate : delegates.keySet())
            delegate.updateLocation(latitude, longitude);
    };

    @Override
    public final void startUpdating(LocationChangeDelegate delegate) {
        if (delegate != null) {
            if (lastLat != 0 && lastLon != 0)
                delegate.updateLocation(lastLat, lastLon);
            if (delegates.put(delegate, "") == null && delegates.size() == 1)
                startSysUpdating(singletonDelegate);
        }
    }

    @Override
    public final void stopUpdating(LocationChangeDelegate delegate) {
        if (delegate != null && delegates.remove(delegate) != null && delegates.isEmpty())
            stopSysUpdating();
    }

    @Override
    public CLLocation lastKnownLocation() {
        return new CLLocation(lastLat, lastLon);
    }

    protected abstract void startSysUpdating(LocationChangeDelegate delegate);

    protected abstract void stopSysUpdating();
}
