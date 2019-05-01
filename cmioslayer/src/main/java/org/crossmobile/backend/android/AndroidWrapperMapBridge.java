/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.android;

import crossmobile.ios.mapkit.MKMapView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.WrapperMapBridge;
import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmlocation")
public class AndroidWrapperMapBridge extends AndroidWrapperBridge implements WrapperMapBridge {
    @Override
    public MapViewWrapper mapView(MKMapView parent) {
        return new AndroidMapViewWrapper(parent);
    }
}
