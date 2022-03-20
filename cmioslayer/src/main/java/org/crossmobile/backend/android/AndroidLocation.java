/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.*;
import org.crossmobile.bind.system.AbstractLocationBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmlocation",
        depends = @CMLibDepends(groupId = "com.google.android.gms", pluginName = "play-services-location", version = "17.0.0"))
public class AndroidLocation extends AbstractLocationBridge {

    private final LocationManager locationManager = (LocationManager) MainActivity.current.getSystemService(Context.LOCATION_SERVICE);
    private final LocationRequest mLocationRequest = LocationRequest.create();
    private final FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(MainActivity.current);
    private final LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            LocationChangeDelegate safeDelegate = delegate;   // for thread safety
            if (locationResult == null || safeDelegate == null)
                return;
            for (Location location : locationResult.getLocations())
                safeDelegate.updateLocation(location.getLatitude(), location.getLongitude());
        }
    };

    private LocationChangeDelegate delegate;

    {
        MainActivity.current.getStateListener().register(new ActivityLifecycleListener() {
            @Override
            public void onPause() {
                stopSysUpdating();
            }

            @Override
            public void onResume() {
                startSysUpdating(delegate);
            }
        });
    }

    @Override
    public boolean supportsFineLocations() {
        return hasGooglePlay() && locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public boolean supportsCoarseLocations() {
        return hasGooglePlay() && locationManager != null && (locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER) || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
    }

    @Override
    public void preferCoarseUpdating() {
        mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
    }

    @Override
    public void preferFineUpdating() {
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void startSysUpdating(LocationChangeDelegate delegate) {
        this.delegate = delegate;
        if (delegate != null)
            AndroidPermissions.current().requestPermissions(notGranted -> {
                if (notGranted.size() < 2)    // at least one granted
                    mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
            }, AndroidPermission.ACCESS_COARSE_LOCATION, AndroidPermission.ACCESS_FINE_LOCATION);
    }

    @Override
    public void stopSysUpdating() {
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    private static Boolean enabledGooglePlay = null;

    private static boolean hasGooglePlay() {
        if (enabledGooglePlay == null)
            enabledGooglePlay = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.current) == ConnectionResult.SUCCESS;
        return enabledGooglePlay == null ? false : enabledGooglePlay;
    }

}
