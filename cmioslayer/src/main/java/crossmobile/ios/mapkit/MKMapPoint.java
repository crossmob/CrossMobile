/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.*;

/**
 * MKMapPoint class defines an object that represents a point of the map on its
 * two dimensional projection.
 */
@CMStruct({"x", "y"})
public final class MKMapPoint {

    /**
     * The x-axis location of the point.
     */
    private double x;

    /**
     * The y-axis location of the point.
     */
    private double y;

    /**
     * Constructs MKMapPoint with the specified parameters.
     *
     * @param x The x-axis location of the point.
     * @param y The y-axis location of the point.
     */
    @CMConstructor(" MKMapPoint MKMapPointMake ( double x, double y ); ")
    public MKMapPoint(@CMRef("x") double x, @CMRef("y") double y) {
        this.x = x;
        this.y = y;
    }

    @CMGetter("double x;")
    public double getX() {
        return x;
    }

    @CMSetter("double x;")
    public void setX(double x) {
        this.x = x;
    }

    @CMGetter("double y;")
    public double getY() {
        return y;
    }

    @CMSetter("double y;")
    public void setY(double y) {
        this.y = y;
    }

    void set(MKMapPoint other) {
        this.x = other.x;
        this.y = other.y;
    }
}
