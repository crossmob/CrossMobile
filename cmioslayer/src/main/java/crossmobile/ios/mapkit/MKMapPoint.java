/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
