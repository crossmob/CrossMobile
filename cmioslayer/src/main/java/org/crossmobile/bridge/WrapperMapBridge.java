package org.crossmobile.bridge;

import crossmobile.ios.mapkit.MKMapView;
import org.crossmobile.bind.wrapper.MapViewWrapper;

public interface WrapperMapBridge {
    MapViewWrapper mapView(MKMapView parent);
}
