/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.*;

/**
 * CLLocationCoordinate2D class defines an object that represents the
 * geographical coordinates of the device.
 */
@CMStruct({"latitude", "longitude"})
public final class CLLocationCoordinate2D {

    /**
     * The latitude expressed in degrees.
     */
    private double latitude;

    /**
     * The longitude expressed in degrees.
     */
    private double longitude;

    /**
     * Constructs a CLLocationCoordinate2D object with the specified latitude
     * and longitude values.
     *
     * @param latitude  CLLocationCoordinate2D's latitude.
     * @param longitude CLLocationCoordinate2D's longitude.
     */
    @CMConstructor("CLLocationCoordinate2D CLLocationCoordinate2DMake(CLLocationDegrees latitude, CLLocationDegrees longitude);")
    public CLLocationCoordinate2D(@CMRef("latitude") double latitude, @CMRef("longitude") double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @CMGetter("CLLocationDegrees latitude;")
    public double getLatitude() {
        return latitude;
    }

    @CMSetter("CLLocationDegrees latitude;")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @CMGetter("CLLocationDegrees longitude;")
    public double getLongitude() {
        return longitude;
    }

    @CMSetter("CLLocationDegrees longitude;")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    void set(CLLocationCoordinate2D other) {
        this.latitude = other.latitude;
        this.longitude = other.longitude;
    }

    @Override
    public String toString() {
        return "lat:" + latitude + ",lon:" + longitude;
    }

    double distanceFromCoordinates(CLLocationCoordinate2D other) {
        double R = 6371000; // m
        double dLat = Math.toRadians(other.latitude - latitude);
        double dLon = Math.toRadians(other.longitude - longitude);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(other.latitude))
                * Math.cos(Math.toRadians(latitude)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CLLocationCoordinate2D other = (CLLocationCoordinate2D) obj;
        return this.latitude == other.latitude && this.longitude == other.longitude;
    }
}
