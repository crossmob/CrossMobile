/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    @CMPure
    public int hashCode() {
        return (int) (getX() * 521 + getY());
    }

    @Override
    @CMPure
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof CGPoint))
            return false;
        CGPoint other = (CGPoint) o;
        return getX() == other.getX() && getY() == other.getY();
    }

    @Override
    public String toString() {
        return "x=" + ((int) (getX() * 10)) / 10d + ", y=" + ((int) (getY() * 10)) / 10d;
    }
}
