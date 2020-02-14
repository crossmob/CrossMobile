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
package crossmobile.ios.mapkit;

//import com.google.android.maps.OverlayItem;

import crossmobile.ios.corelocation.CLLocation;
import crossmobile.ios.corelocation.CLLocationManager;
import crossmobile.ios.corelocation.CLLocationManagerDelegate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * MKUserLocationView class defines an object that represents the view of user's
 * current annotation on a map.
 */
class MKUserLocationView extends MKAnnotationView {

    private static final CLLocationManager user_callback;
    static List<WeakReference<MKMapView>> maps;

    static {
        maps = new ArrayList<>();

        user_callback = new CLLocationManager();
        user_callback.setDelegate(new CLLocationManagerDelegate() {
            @Override
            public void didUpdateToLocation(CLLocationManager manager, CLLocation newLocation, CLLocation oldLocation) {
                List<WeakReference<MKMapView>> dead = new ArrayList<>();
                for (WeakReference<MKMapView> refmap : maps) {
                    MKMapView map = refmap.get();
                    //      if (map != null)
                    // TODO:          map.updateUserLocation(newLocation);
                }
            }
        });
        user_callback.startUpdatingLocation();
    }

    static void registerMap(MKMapView map) {
        maps.add(new WeakReference<>(map));
        //  if (user_callback.location() != null)
        // TODO:      map.updateUserLocation(user_callback.location());

        // It's a good time to demove old references 
        for (WeakReference<MKMapView> refmap : maps)
            if (refmap.get() == null)
                maps.remove(refmap);
    }

    MKUserLocationView(MKUserLocation location, String reuseIdentifier) {
        super(location, reuseIdentifier);
    }
    // TODO : implement
//    OverlayItem overlayItem(AnnotationsOverlay overlay, boolean showsUserLocation) {
//        return createOverlayItem(overlay);
//    }
}
