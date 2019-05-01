package org.crossmobile.backend.swing;

import crossmobile.ios.mapkit.MKMapView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.WrapperMapBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.DESKTOP, name = "cmlocation")
public class SwingWrapperMapBridge extends SwingWrapperBridge implements WrapperMapBridge {
    @Override
    public MapViewWrapper mapView(MKMapView parent) {
        return new SwingMapViewWrapper(parent);
    }
}
