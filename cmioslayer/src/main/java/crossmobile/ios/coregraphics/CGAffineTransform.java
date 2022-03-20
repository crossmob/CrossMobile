/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.*;

/**
 * CGAffineTransform class defines an object that represents an affine
 * transformation matrix.
 */
@CMStruct({"a", "b", "c", "d", "tx", "ty"})
public final class CGAffineTransform {

    private static final CGAffineTransform IDENTITY = new CGAffineTransform();

    /**
     * The [1,1] value of the 3x3 transformation matrix.
     */
    private double a;

    /**
     * The [1,2] value of the 3x3 transformation matrix.
     */
    private double b;

    /**
     * The [2,1] value of the 3x3 transformation matrix.
     */
    private double c;

    /**
     * The [2,2] value of the 3x3 transformation matrix.
     */
    private double d;

    /**
     * The [3,1] value of the 3x3 transformation matrix.
     */
    private double tx;

    /**
     * The [3,2] value of the 3x3 transformation matrix.
     */
    private double ty;

    /**
     * Returns the identity affine transformation.
     *
     * @return The identity affine transformation.
     */
    @CMFunction(" const CGAffineTransform CGAffineTransformIdentity;")
    public static CGAffineTransform identity() {
        return new CGAffineTransform();
    }

    /**
     * Returns the transformation matrix that results from the specified angle.
     *
     * @param alpha The angle of the rotation expressed in radians.
     * @return The transformation matrix that results from the specified angle.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformMakeRotation ( CGFloat angle ); ")
    public static CGAffineTransform makeRotation(double alpha) {
        return new CGAffineTransform().rotateSelf(alpha);
    }

    /**
     * Returns the transformation matrix that results from the specified scaling
     * values.
     *
     * @param sx The scale for x values.
     * @param sy The scale for y values.
     * @return The transformation matrix that results from the specified scaling
     * values.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformMakeScale ( CGFloat sx, CGFloat sy ); ")
    public static CGAffineTransform makeScale(double sx, double sy) {
        return new CGAffineTransform().scaleSelf(sx, sy);
    }

    /**
     * Returns the transformation matrix that results from the specified values.
     *
     * @param tx The transformation for x values.
     * @param ty The transformation for x values.
     * @return The transformation matrix that results from the specified values.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformMakeTranslation ( CGFloat tx, CGFloat ty ); ")
    public static CGAffineTransform makeTranslation(double tx, double ty) {
        return new CGAffineTransform().translateSelf(tx, ty);
    }

    private CGAffineTransform() {
        this(1, 0, 0, 1, 0, 0);
    }

    /**
     * Constructs an affine transformation with the specified matrix values.
     *
     * @param a  The value at [1,1] position of the matrix.
     * @param b  The value at [1,2] position of the matrix.
     * @param c  The value at [2,1] position of the matrix.
     * @param d  The value at [2,2] position of the matrix.
     * @param tx The value at [3,1] position of the matrix.
     * @param ty The value at [3,2] position of the matrix.
     */
    @CMConstructor(" CGAffineTransform CGAffineTransformMake ( CGFloat a, CGFloat b, CGFloat c, CGFloat d, CGFloat tx, CGFloat ty ); ")
    public CGAffineTransform(@CMRef("a") double a, @CMRef("b") double b, @CMRef("c") double c, @CMRef("d") double d, @CMRef("tx") double tx, @CMRef("ty") double ty) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tx = tx;
        this.ty = ty;
    }

    private CGAffineTransform(CGAffineTransform other) {
        this(other.a, other.b, other.c, other.d, other.tx, other.ty);
    }

    @CMGetter("CGFloat a;")
    public double getA() {
        return a;
    }

    @CMSetter("CGFloat a;")
    public void setA(double a) {
        this.a = a;
    }

    @CMGetter("CGFloat b;")
    public double getB() {
        return b;
    }

    @CMSetter("CGFloat b;")
    public void setB(double b) {
        this.b = b;
    }

    @CMGetter("CGFloat c;")
    public double getC() {
        return c;
    }

    @CMSetter("CGFloat c;")
    public void setC(double c) {
        this.c = c;
    }

    @CMGetter("CGFloat d;")
    public double getD() {
        return d;
    }

    @CMSetter("CGFloat d;")
    public void setD(double d) {
        this.d = d;
    }

    @CMGetter("CGFloat tx;")
    public double getTx() {
        return tx;
    }

    @CMSetter("CGFloat tx;")
    public void setTx(double tx) {
        this.tx = tx;
    }

    @CMGetter("CGFloat ty;")
    public double getTy() {
        return ty;
    }

    @CMSetter("CGFloat ty;")
    public void setTy(double ty) {
        this.ty = ty;
    }

    /**
     * Returns the transformation matrix that results from the rotation of the
     * specified affine transformation.
     *
     * @param alpha The angle of the rotation expressed in radians.
     * @return The transformation matrix of the rotated affine transformation.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformRotate ( CGAffineTransform t, CGFloat angle ); ")
    public CGAffineTransform rotate(double alpha) {
        return new CGAffineTransform(this).rotateSelf(alpha);
    }

    CGAffineTransform rotateSelf(double alpha) {
        return concatSelf(Math.cos(alpha), Math.sin(alpha), -Math.sin(alpha), Math.cos(alpha), 0, 0);
    }

    /**
     * Returns the affine transformation matrix that results from the specified
     * values.
     *
     * @param sx The scale of x values.
     * @param sy The scale of y values.
     * @return The affine transformation matrix that results from the specified
     * values.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformScale ( CGAffineTransform t, CGFloat sx, CGFloat sy ); ")
    public CGAffineTransform scale(double sx, double sy) {
        return new CGAffineTransform(this).scaleSelf(sx, sy);
    }

    CGAffineTransform scaleSelf(double sx, double sy) {
        return concatSelf(sx, 0, 0, sy, 0, 0);
    }

    /**
     * Returns the transformation matrix of this affine transformation.
     *
     * @param tx The transformation of x values.
     * @param ty The transformation of y values.
     * @return The transformation matrix of this affine transformation.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformTranslate ( CGAffineTransform t, CGFloat tx, CGFloat ty ); ")
    public CGAffineTransform translate(double tx, double ty) {
        return new CGAffineTransform(this).translateSelf(tx, ty);
    }

    CGAffineTransform translateSelf(double tx, double ty) {
        return concatSelf(1, 0, 0, 1, tx, ty);
    }

    /**
     * Returns the combination of the specified affine transformation and the
     * current one.
     *
     * @param other The other affine transformation.
     * @return The combination of the specified affine transformation and the
     * current one.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformConcat ( CGAffineTransform t1, CGAffineTransform t2 ); ")
    public CGAffineTransform concat(CGAffineTransform other) {
        return new CGAffineTransform(this).concatSelf(other.a, other.b, other.c, other.d, other.tx, other.ty);
    }

    CGAffineTransform concatSelf(CGAffineTransform other) {
        return concatSelf(other.a, other.b, other.c, other.d, other.tx, other.ty);
    }

    CGAffineTransform concatSelf(double a, double b, double c, double d, double tx, double ty) {
        double A = this.a * a + this.c * b;
        double C = this.a * c + this.c * d;
        double TX = this.a * tx + this.c * ty + this.tx;
        double B = this.b * a + this.d * b;
        double D = this.b * c + this.d * d;
        double TY = this.b * tx + this.d * ty + this.ty;
        this.a = A;
        this.b = B;
        this.c = C;
        this.d = D;
        this.tx = TX;
        this.ty = TY;
        return this;
    }

    CGAffineTransform identitySelf() {
        this.a = 1;
        this.b = 0;
        this.c = 0;
        this.d = 1;
        this.tx = 0;
        this.ty = 0;
        return this;
    }

    /**
     * Returns a Boolean that specifies whether this affine transformation is
     * the identity transformation.
     *
     * @return TRUE then this affine transformation is the identity
     * transformation.
     */
    @CMFunction(" bool CGAffineTransformIsIdentity ( CGAffineTransform t ); ")
    public boolean isIdentity() {
        return equals(IDENTITY);
    }

    /**
     * Returns the inverted affine transformation matrix of the current one.
     *
     * @return The inverted affine transformation matrix of the current one.
     */
    @CMFunction(" CGAffineTransform CGAffineTransformInvert ( CGAffineTransform t ); ")
    public CGAffineTransform invert() {
        double A = a, B = b, C = c, D = d, TX = tx, TY = ty;
        double det = A * D - B * C;
        if (Math.abs(det) <= Double.MIN_VALUE)
            return new CGAffineTransform(this); // return a copy of this, if the inverse could not be found
        return new CGAffineTransform(
                (D / det),
                -(B / det),
                -(C / det),
                (A / det),
                ((C * TY - D * TX) / det),
                ((B * TX - A * TY) / det));
    }

    CGAffineTransform set(double a, double b, double c, double d, double tx, double ty) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tx = tx;
        this.ty = ty;
        return this;
    }

    CGAffineTransform set(CGAffineTransform t) {
        set(t.a, t.b, t.c, t.d, t.tx, t.ty);
        return this;
    }

    @Override
    @CMPure
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) getA();
        hash = 47 * hash + (int) getB();
        hash = 47 * hash + (int) getC();
        hash = 47 * hash + (int) getD();
        hash = 47 * hash + (int) getTx();
        hash = 47 * hash + (int) getTy();
        return hash;
    }

    @Override
    @CMPure
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        CGAffineTransform other = (CGAffineTransform) o;
        return getA() == other.getA() && getB() == other.getB()
                && getC() == other.getC() && getD() == other.getD()
                && getTx() == other.getTx() && getTy() == other.getTy();
    }

    @Override
    @CMPure
    public String toString() {
        return "a=" + getA() + ", c=" + getC() + ", tx=" + getTx() + ", b=" + getB() + ", d=" + getD() + ", ty=" + getTy();
    }
}
