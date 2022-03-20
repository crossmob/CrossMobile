/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.*;

/**
 * MKMapSize class defines an object that represents the size of a map.
 */
@CMStruct({"width", "height"})
public final class MKMapSize {

    /**
     * The width of the MKMapSize object.
     */
    private double width;

    /**
     * The height of the MKMapSize object.
     */
    private double height;

    /**
     * Constructs a MKMapSize object with the specified width and height values.
     *
     * @param width  The width of the MKMapSize object.
     * @param height The height of the MKMapSize object.
     */
    @CMConstructor(" MKMapSize MKMapSizeMake ( double width, double height ); ")
    public MKMapSize(@CMRef("width") double width, @CMRef("height") double height) {
        this.width = width;
        this.height = height;
    }

    @CMGetter("double width;")
    public double getWidth() {
        return width;
    }

    @CMSetter("double width;")
    public void setWidth(double width) {
        this.width = width;
    }

    @CMGetter("double height;")
    public double getHeight() {
        return height;
    }

    @CMSetter("double height;")
    public void setHeight(double height) {
        this.height = height;
    }

    void set(MKMapSize other) {
        this.width = other.width;
        this.height = other.height;
    }
}
