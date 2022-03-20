/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import crossmobile.ios.mapkit.MKMapView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.WrapperMapBridge;
import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmlocation")
public class AndroidWrapperMapBridge implements WrapperMapBridge {
    @Override
    public MapViewWrapper mapView(MKMapView parent) {
        return new AndroidMapViewWrapper(parent);
    }
}
