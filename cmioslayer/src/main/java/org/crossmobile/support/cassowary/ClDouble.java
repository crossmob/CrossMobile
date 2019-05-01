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

public class ClDouble extends Number {
    private double value;

    public ClDouble(double val) {
        value = val;
    }

    public ClDouble() {
        this(0.0);
    }

    @Override
    public final ClDouble clone() {
        return new ClDouble(value);
    }

    @Override
    public final double doubleValue() {
        return value;
    }

    @Override
    public final int intValue() {
        return (int) value;
    }

    @Override
    public final long longValue() {
        return (long) value;
    }

    @Override
    public final float floatValue() {
        return (float) value;
    }

    @Override
    public final byte byteValue() {
        return (byte) value;
    }

    @Override
    public final short shortValue() {
        return (short) value;
    }

    public final void setValue(double val) {
        value = val;
    }

    @Override
    public final String toString() {
        return java.lang.Double.toString(value);
    }

    @Override
    public final boolean equals(Object o) {
        try {
            return value == ((ClDouble) o).value;
        } catch (Exception err) {
            return false;
        }
    }

    @Override
    public final int hashCode() {
        System.err.println("ClDouble.hashCode() called!");
        return (int) java.lang.Double.doubleToLongBits(value);
    }

}
