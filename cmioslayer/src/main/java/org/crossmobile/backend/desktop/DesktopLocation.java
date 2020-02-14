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
package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSJSONSerialization;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bind.system.AbstractLocationBridge;

import java.util.Map;

class DesktopLocation extends AbstractLocationBridge {

    private Thread locationThread = null;
    private LocationChangeDelegate delegate = null;

    public DesktopLocation() {
    }

    @Override
    public boolean supportsFineLocations() {
        return true;
    }

    @Override
    public boolean supportsCoarseLocations() {
        return true;
    }

    @Override
    public void preferCoarseUpdating() {
    }

    @Override
    public void preferFineUpdating() {
    }

    @Override
    protected void startSysUpdating(LocationChangeDelegate delegate) {
        this.delegate = delegate;
        if (locationThread != null)
            return;
        locationThread = new Thread(() -> updatingProcess(), "LocationFinder");
        locationThread.start();
    }

    @Override
    protected void stopSysUpdating() {
        synchronized (this) {
            delegate = null;
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    private void updatingProcess() {
        double latitude = 0;
        double longitude = 0;
        try {
            Map<String, Object> res = (Map<String, Object>) NSJSONSerialization.JSONObjectWithData(NSData.dataWithContentsOfURL(NSURL.URLWithString("http://freegeoip.net/json")), 0, null);
            if (res != null) {
                latitude = Double.parseDouble(res.get("latitude").toString());
                longitude = Double.parseDouble(res.get("longitude").toString());
            }
        } catch (Exception ex) {
        }
        while (true)
            try {
                synchronized (this) {
                    if (delegate != null)
                        delegate.updateLocation(latitude, longitude);
                    wait(10000);
                }
            } catch (InterruptedException ex) {
            }
    }
}
