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
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;

public class MapView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("maptype", new Value.Selections(new String[]{"standard", "satellite", "hyprid"}));
        addSupportedAttribute("showsUserLocation", Values.Boolean);
        addSupportedAttribute("zoomEnabled", Values.Boolean);
        addSupportedAttribute("scrollEnabled", Values.Boolean);
        addSupportedAttribute("rotateEnabled", Values.Boolean);
        addSupportedAttribute("pitchEnabled", Values.Boolean);

    }

    @Override
    public String getDefaultClassName() {
        return "crossmobile.ios.mapkit.MKMapView";
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        return out.toString();
    }

}
