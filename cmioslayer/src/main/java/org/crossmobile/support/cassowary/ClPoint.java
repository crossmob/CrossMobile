/*
 * Cassowary Incremental Constraint Solver
 * Original Smalltalk Implementation by Alan Borning
 *
 * Java Implementation by:
 * Greg J. Badros
 * Erwin Bolwidt
 *
 * (C) 1998, 1999 Greg J. Badros and Alan Borning
 * (C) Copyright 2012 Erwin Bolwidt
 *
 * See the file LICENSE for legal details regarding this software
 */

package org.crossmobile.support.cassowary;

public class ClPoint {

    private ClVariable x;

    private ClVariable y;

    public ClPoint(double x, double y) {
        this.x = new ClVariable(x);
        this.y = new ClVariable(y);
    }

    public ClPoint(double x, double y, int a) {
        this.x = new ClVariable("x" + a, x);
        this.y = new ClVariable("y" + a, y);
    }

    public ClPoint(ClVariable clv_x, ClVariable clv_y) {
        this.x = clv_x;
        this.y = clv_y;
    }

    public ClVariable getX() {
        return x;
    }

    public ClVariable getY() {
        return y;
    }

    // use only before adding into the solver
    public void setXY(double x, double y) {
        this.x.setValue(x);
        this.y.setValue(y);
    }

    public void setXY(ClVariable clv_x, ClVariable clv_y) {
        this.x = clv_x;
        this.y = clv_y;
    }

    public double getXValue() {
        return getX().getValue();
    }

    public double getYValue() {
        return getY().getValue();
    }

    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ")";
    }

}
