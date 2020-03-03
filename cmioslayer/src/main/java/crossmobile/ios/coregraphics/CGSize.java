// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package crossmobile.ios.coregraphics;

import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bridge.ann.*;

import static org.crossmobile.bind.graphics.Geometry.apply;

/**
 * CGSize class defines an object that represents the size of a rectangle.
 */
@CMStruct({"width", "height"})
public final class CGSize {

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The height of the rectangle.
     */
    private double height;

    /**
     * Constructs a CGSize object with the specified width and height.
     *
     * @param width  The width of the CGSize object.
     * @param height The height of the CGSize object.
     */
    @CMConstructor(value = "CGSize CGSizeMake(CGFloat width, CGFloat height);")
    public CGSize(@CMRef("width") double width, @CMRef("height") double height) {
        this.width = width;
        this.height = height;
    }

    CGSize(CGSize size) {
        width = size.width;
        height = size.height;
    }

    @CMGetter("CGFloat width;")
    public double getWidth() {
        return width;
    }

    @CMSetter("CGFloat width;")
    public void setWidth(double width) {
        this.width = width;
    }

    @CMGetter("CGFloat height;")
    public double getHeight() {
        return height;
    }

    @CMSetter("CGFloat height;")
    public void setHeight(double height) {
        this.height = height;
    }

    void set(double width, double height) {
        this.width = width;
        this.height = height;
    }

    void set(CGSize other) {
        set(other.width, other.height);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CGSize))
            return false;
        return Geometry.equals(this, (CGSize) obj);
    }

    @Override
    public int hashCode() {
        return (int) (width * 10000 + height);
    }

    /**
     * Applies the specified affine transformation to this CGSize object.
     *
     * @param t The affine transformation that will be aplied to the CGSize
     *          object
     * @return The transformed CGSize object.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" CGSize CGSizeApplyAffineTransform ( CGSize size, CGAffineTransform t ); ")
    public CGSize applyAffineTransform(CGAffineTransform t) {
        return apply(t, new CGSize(width, height));
    }

    @Override
    public String toString() {
        return ((int) (width * 10)) / 10d + "," + ((int) (height * 10)) / 10d;
    }
}
