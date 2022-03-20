/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import org.crossmobile.bridge.ann.*;

/**
 * MKCoordinateRegion class defines an object that represents the part of the
 * map that is displayed.
 */
@CMStruct({"center", "span"})
public final class MKCoordinateRegion {

    /**
     * The center of the displayed area.
     */
    private CLLocationCoordinate2D center;

    /**
     * The portion of the map that is displayed.
     */
    private MKCoordinateSpan span;

    /**
     * Constructs an object with the specified parameters.
     *
     * @param center The center of the displayed area.
     * @param span   The portion of the map that is displayed.
     */
    @CMConstructor(" MKCoordinateRegion MKCoordinateRegionMake ( CLLocationCoordinate2D centerCoordinate, MKCoordinateSpan span ); ")
    public MKCoordinateRegion(@CMRef("center") CLLocationCoordinate2D center, @CMRef("span") MKCoordinateSpan span) {
        this.center = center;
        this.span = span;
    }

    @CMGetter("CLLocationCoordinate2D center;")
    public CLLocationCoordinate2D getCenter() {
        return center;
    }

    @CMSetter("CLLocationCoordinate2D center;")
    public void setCenter(CLLocationCoordinate2D center) {
        this.center.setLatitude(center.getLatitude());
        this.center.setLongitude(center.getLongitude());
    }

    @CMGetter("MKCoordinateSpan span;")
    public MKCoordinateSpan getSpan() {
        return span;
    }

    @CMSetter("MKCoordinateSpan span;")
    public void setSpan(MKCoordinateSpan span) {
        this.span.set(span);
    }
}
