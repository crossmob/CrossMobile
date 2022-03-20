/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
        locationThread = new Thread(this::updatingProcess, "LocationFinder");
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
            @SuppressWarnings("unchecked") Map<String, Object> res = (Map<String, Object>) NSJSONSerialization.JSONObjectWithData(NSData.dataWithContentsOfURL(NSURL.URLWithString("http://freegeoip.net/json")), 0, null);
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
