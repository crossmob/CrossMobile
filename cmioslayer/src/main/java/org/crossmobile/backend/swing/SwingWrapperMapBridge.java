/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.mapkit.MKMapView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.WrapperMapBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.SWING, name = "cmlocation")
public class SwingWrapperMapBridge implements WrapperMapBridge {
    @Override
    public MapViewWrapper mapView(MKMapView parent) {
        return new SwingMapViewWrapper(parent);
    }
}
