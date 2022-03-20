/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.*;

/**
 * MKMapRect class defines an object that represents the rectangular area of a
 * map's two dimensional projection.
 */
@CMStruct({"origin", "size"})
public final class MKMapRect {

    /**
     * The starting point the rectangular area.
     */
    private MKMapPoint origin;

    /**
     * The size of the rectangular area.
     */
    private MKMapSize size;

    /**
     * Constructs a MKMapRect object with the specified parameters values.
     *
     * @param x      The x-coordinate of the rectangular area.
     * @param y      The y-coordinate of the rectangular area.
     * @param width  The width of the rectangular area.
     * @param height The height of the rectangular area.
     */
    @CMConstructor(" MKMapRect MKMapRectMake ( double x, double y, double width, double height ); ")
    public MKMapRect(@CMRef("origin.x") double x, @CMRef("origin.y") double y, @CMRef("size.width") double width, @CMRef("size.height") double height) {
        this.origin = new MKMapPoint(x, y);
        this.size = new MKMapSize(width, height);
    }

    @CMGetter("MKMapPoint origin;")
    public MKMapPoint getOrigin() {
        return origin;
    }

    @CMSetter("MKMapPoint origin;")
    public void setOrigin(MKMapPoint origin) {
        this.origin.set(origin);
    }

    @CMGetter("MKMapSize size;")
    public MKMapSize getSize() {
        return size;
    }

    @CMSetter("MKMapSize size;")
    public void setSize(MKMapSize size) {
        this.size.set(size);
    }
}
