/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.*;

/**
 * MKCoordinateSpan class defines an object that represents the area that is
 * covered by the map.
 */
@CMStruct({"latitudeDelta", "longitudeDelta"})
public final class MKCoordinateSpan {

    /**
     * The portion of the north to south distance that is displayed on the map.
     */
    private double latitudeDelta;

    /**
     * The portion of the east to west distance that is displayed on the map.
     */
    private double longitudeDelta;

    /**
     * Constructs a MKCoordinateSpan object with the specified parameters.
     *
     * @param latitudeDelta  The portion of the north to south distance that is
     *                       displayed on the map.
     * @param longitudeDelta The portion of the east to west distance that is
     *                       displayed on the map.
     */
    @CMConstructor(" MKCoordinateSpan MKCoordinateSpanMake ( CLLocationDegrees latitudeDelta, CLLocationDegrees longitudeDelta ); ")
    public MKCoordinateSpan(@CMRef("latitudeDelta") double latitudeDelta, @CMRef("longitudeDelta") double longitudeDelta) {
        this.latitudeDelta = latitudeDelta;
        this.longitudeDelta = longitudeDelta;
    }

    @CMGetter("CLLocationDegrees latitudeDelta;")
    public double getLatitudeDelta() {
        return latitudeDelta;
    }

    @CMSetter("CLLocationDegrees latitudeDelta;")
    public void setLatitudeDelta(double latitudeDelta) {
        this.latitudeDelta = latitudeDelta;
    }

    @CMGetter("CLLocationDegrees longitudeDelta;")
    public double getLongitudeDelta() {
        return longitudeDelta;
    }

    @CMSetter("CLLocationDegrees longitudeDelta;")
    public void setLongitudeDelta(double longitudeDelta) {
        this.longitudeDelta = longitudeDelta;
    }

    void set(MKCoordinateSpan other) {
        this.latitudeDelta = other.latitudeDelta;
        this.longitudeDelta = other.longitudeDelta;
    }
}
