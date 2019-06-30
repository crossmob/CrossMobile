/*
 * (c) 2019 by Panayotis Katsaloulis
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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.*;

import static org.crossmobile.bind.graphics.Geometry.apply;

/**
 * CGPoint class defines an object that represents a point in a 2D coordinate
 * system.
 */
@CMStruct({"x", "y"})
public final class CGPoint {

    /**
     * The x coordinate of the CGPoint.
     */
    private double x;

    /**
     * The y coordinate of the CGPoint.
     */
    private double y;

    CGPoint(CGPoint point) {
        x = point.x;
        y = point.y;
    }

    /**
     * Constructs a CGPoint with specified coordinates.
     *
     * @param x The x value of the CGPoint.
     * @param y The y value of the CGPoint.
     */
    @CMConstructor(" CGPoint CGPointMake ( CGFloat x, CGFloat y ); ")
    public CGPoint(@CMRef("x") double x, @CMRef("y") double y) {
        this.x = x;
        this.y = y;
    }

    @CMGetter("CGFloat x;")
    public double getX() {
        return x;
    }

    @CMSetter("CGFloat x;")
    public void setX(double x) {
        this.x = x;
    }

    @CMGetter("CGFloat y;")
    public double getY() {
        return y;
    }

    @CMSetter("CGFloat y;")
    public void setY(double y) {
        this.y = y;
    }

    void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void set(CGPoint other) {
        set(other.x, other.y);
    }

    /**
     * Constructs and returns a default CGRect object located at (0,0) with 0
     * weight and 0 height.
     *
     * @return A default CGRect object located at (0,0) with 0 weight and 0
     * height.
     */
    @CMFunction("const CGPoint CGPointZero;")
    public static CGPoint zero() {
        return new CGPoint(0, 0);
    }

    /**
     * Applies the specified affine transformation to this point.
     *
     * @param t The affine transformation that is applied to the point.
     * @return The point after the affine transformation.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction("CGPoint CGPointApplyAffineTransform(CGPoint point, CGAffineTransform t);")
    public CGPoint applyAffineTransform(CGAffineTransform t) {
        return apply(t, new CGPoint(this));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof CGPoint))
            return false;
        CGPoint p = (CGPoint) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Float.floatToIntBits((float) this.x);
        hash = 89 * hash + Float.floatToIntBits((float) this.y);
        return hash;
    }

    @Override
    public String toString() {
        return ((int) (x * 10)) / 10f + "," + ((int) (y * 10)) / 10.0;
    }
}
