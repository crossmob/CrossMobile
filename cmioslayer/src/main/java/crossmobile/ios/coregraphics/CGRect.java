/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.*;

/**
 * CGRect class class defines an object that represents the position and the
 * dimensions of a rectangle.
 */
@CMStruct({"origin", "size"})
public final class CGRect {

    private static final CGRect NULL = new CGRect(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 0);
    private static final CGRect ZERO = new CGRect(0, 0, 0, 0);
    private static final CGRect INFINITE = new CGRect(-Double.MAX_VALUE, -Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

    /**
     * The coordinates of the rectangle.
     */
    private CGPoint origin;

    /**
     * The size of the rectangle.
     */
    private CGSize size;

    /**
     * Constructs a CGRect object with the specified size and position.
     *
     * @param x      The x-coordinate of the rectangle.
     * @param y      The y-coordinate of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    @CMConstructor("CGRect CGRectMake(CGFloat x, CGFloat y, CGFloat width, CGFloat height);")
    public CGRect(@CMRef("origin.x") double x, @CMRef("origin.y") double y, @CMRef("size.width") double width, @CMRef("size.height") double height) {
        origin = new CGPoint(x, y);
        size = new CGSize(width, height);
    }

    /**
     * Constructs a CGRect object based on the specified rectangle.
     *
     * @param other
     */
    private CGRect(CGRect other) {
        origin = new CGPoint(other.origin);
        size = new CGSize(other.size);
    }

    private CGRect(CGPoint origin, CGSize size, boolean clone) {
        this.origin = clone ? new CGPoint(origin) : origin;
        this.size = clone ? new CGSize(size) : size;
    }

    @CMGetter("CGPoint origin;")
    public CGPoint getOrigin() {
        return origin;
    }

    @CMSetter("CGPoint origin;")
    public void setOrigin(CGPoint origin) {
        this.origin.set(origin);
    }

    @CMGetter("CGSize size;")
    public CGSize getSize() {
        return size;
    }

    @CMSetter("CGSize size;")
    public void setSize(CGSize size) {
        this.size.set(size);
    }

    /**
     * Returns a NULL rectangle.
     *
     * @return A NULL rectangle.
     */
    @CMFunction(" const CGRect CGRectNull;")
    public static CGRect Null() {
        return new CGRect(NULL);
    }

    /**
     * Constructs and returns a default CGRect object located at (0,0) with 0
     * weight and 0 height.
     *
     * @return A default CGRect object located at (0,0) with 0 weight and 0
     * height.
     */
    @CMFunction("const CGRect CGRectZero;")
    public static CGRect zero() {
        return new CGRect(ZERO);
    }

    /**
     * Returns a rectangle that has no defined bounds.
     *
     * @return A rectangle without defined bounds.
     */
    @CMFunction(" const CGRect CGRectInfinite;")
    public static CGRect infinite() {
        return new CGRect(INFINITE);
    }

    /**
     * Returns the intersection of this rectangle with the specified rectangle.
     *
     * @param other The other rectangle that will be intersected with this one.
     * @return The intersection of this rectangle with given.
     */
    @CMFunction("CGRect CGRectIntersection(CGRect r1, CGRect r2)")
    public CGRect intersection(CGRect other) {
        if (other == null)
            return Null();
        double maxleft = this.getOrigin().getX() > other.getOrigin().getX() ? this.getOrigin().getX() : other.getOrigin().getX();
        double maxtop = this.getOrigin().getY() > other.getOrigin().getY() ? this.getOrigin().getY() : other.getOrigin().getY();
        double minright = (this.getOrigin().getX() + this.getSize().getWidth()) < (other.getOrigin().getX() + other.getSize().getWidth())
                ? this.getOrigin().getX() + this.getSize().getWidth() : other.getOrigin().getX() + other.getSize().getWidth();
        double minbottom = (this.getOrigin().getY() + this.getSize().getHeight()) < (other.getOrigin().getY() + other.getSize().getHeight())
                ? this.getOrigin().getY() + this.getSize().getHeight() : other.getOrigin().getY() + other.getSize().getHeight();
        if (maxleft > minright || maxtop > minbottom)
            return Null();
        return new CGRect(maxleft, maxtop, minright - maxleft, minbottom - maxtop);
    }

    /**
     * Returns a Boolean that shows whether this rectangle is NULL.
     *
     * @return TRUE then this rectangle is NULL.
     */
    @CMFunction("bool CGRectIsNull(CGRect rect);")
    public boolean isNull() {
        return equals(NULL);
    }

    /**
     * Returns a Boolean that shows whether this rectangle is of zero size or
     * NULL.
     *
     * @return TRUE then this rectangle is of zero size or NULL.
     */
    @CMFunction(" bool CGRectIsEmpty ( CGRect rect ); ")
    public boolean isEmpty() {
        return equals(ZERO);
    }

    /**
     * Returns a Boolean value that shows whether this rectangle is infinite.
     *
     * @return TRUE then this rectangle is infinite.
     */
    @CMFunction("bool CGRectIsInfinite(CGRect rect)")
    public boolean isInfinite() {
        return equals(INFINITE);
    }

    /**
     * Returns the minimum x value of this rectangle.
     *
     * @return The minimum x value of this rectangle.
     */
    @CMFunction(" CGFloat CGRectGetMinX ( CGRect rect ); ")
    public double getMinX() {
        return size.getWidth() < 0 ? origin.getX() + size.getWidth() : origin.getX();
    }

    /**
     * Returns the minimum y value of this rectangle.
     *
     * @return The minimum y value of this rectangle.
     */
    @CMFunction(" CGFloat CGRectGetMinY ( CGRect rect ); ")
    public double getMinY() {
        return size.getHeight() < 0 ? origin.getY() + size.getHeight() : origin.getY();
    }

    /**
     * Returns the maximum x value of this rectangle.
     *
     * @return The maximum x value of this rectangle.
     */
    @CMFunction(" CGFloat CGRectGetMaxX ( CGRect rect ); ")
    public double getMaxX() {
        return size.getWidth() < 0 ? origin.getX() : origin.getX() + size.getWidth();
    }

    /**
     * Returns the maximum y value of this rectangle.
     *
     * @return The maximum y value of this rectangle.
     */
    @CMFunction(" CGFloat CGRectGetMaxY ( CGRect rect ); ")
    public double getMaxY() {
        return size.getHeight() < 0 ? origin.getY() : origin.getY() + size.getHeight();
    }

    /**
     * Applies the specified affine transformation to this rectangle.
     *
     * @param t The affine transformation that is applied.
     * @return The transformed rectangle.
     * @see crossmobile.ios.coregraphics.CGAffineTransform
     */
    @CMFunction(" CGRect CGRectApplyAffineTransform ( CGRect rect, CGAffineTransform t ); ")
    public CGRect applyAffineTransform(CGAffineTransform t) {
        return new CGRect(origin.applyAffineTransform(t), size.applyAffineTransform(t), false);
    }

    /**
     * Returns true if point relative to its parent is inside current CGRect
     *
     * @param point point relative to its parent
     * @return Returns true if point relative to its parent is inside current CGRect
     */
    @CMFunction("bool CGRectContainsPoint(CGRect rect, CGPoint point);")
    public boolean containsPoint(CGPoint point) {
        if (point.getX() >= origin.getX() && point.getX() <= origin.getX() + size.getWidth()
                && point.getY() >= origin.getY() && point.getY() <= origin.getY() + size.getHeight())
            return true;
        return false;
    }

    @Override
    @CMPure
    public int hashCode() {
        CGPoint or = getOrigin();
        CGSize si = getSize();
        int hash = 7;
        hash = 29 * hash + (or != null ? or.hashCode() : 0);
        hash = 29 * hash + (si != null ? si.hashCode() : 0);
        return hash;
    }

    @Override
    @CMPure
    public String toString() {
        return "origin=(" + getOrigin().toString() + "), size=(" + getSize().toString() + ")";
    }

    @Override
    @CMPure
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof CGRect))
            return false;
        CGRect other = (CGRect) o;
        return getOrigin().equals(other.getOrigin()) && getSize().equals(other.getSize());
    }
}
