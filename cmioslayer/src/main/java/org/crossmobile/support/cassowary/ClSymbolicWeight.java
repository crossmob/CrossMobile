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

public class ClSymbolicWeight {
    public static final ClSymbolicWeight clsZero = new ClSymbolicWeight(0.0, 0.0, 0.0);

    private double[] _values;

    public ClSymbolicWeight(int cLevels) {
        _values = new double[cLevels];
    }

    public ClSymbolicWeight(double w1, double w2, double w3) {
        _values = new double[]{w1, w2, w3};
    }

    public ClSymbolicWeight(double[] weights) {
        _values = weights.clone();
    }

    @Override
    public ClSymbolicWeight clone() {
        return new ClSymbolicWeight(_values);
    }

    public ClSymbolicWeight times(double n) {
        ClSymbolicWeight clsw = clone();
        for (int i = 0; i < _values.length; i++) {
            clsw._values[i] *= n;
        }
        return clsw;
    }

    public ClSymbolicWeight divideBy(double n) {
        // assert(n != 0);
        ClSymbolicWeight clsw = clone();
        for (int i = 0; i < _values.length; i++) {
            clsw._values[i] /= n;
        }
        return clsw;
    }

    public ClSymbolicWeight add(ClSymbolicWeight cl) {
        // assert(cl.cLevels() == cLevels());

        ClSymbolicWeight clsw = clone();
        for (int i = 0; i < _values.length; i++) {
            clsw._values[i] += cl._values[i];
        }
        return clsw;
    }

    public ClSymbolicWeight subtract(ClSymbolicWeight cl) {
        // assert(cl.cLevels() == cLevels());

        ClSymbolicWeight clsw = clone();
        for (int i = 0; i < _values.length; i++) {
            clsw._values[i] -= cl._values[i];
        }
        return clsw;
    }

    public boolean lessThan(ClSymbolicWeight cl) {
        // assert cl.cLevels() == cLevels()
        for (int i = 0; i < _values.length; i++) {
            if (_values[i] < cl._values[i])
                return true;
            else if (_values[i] > cl._values[i])
                return false;
        }
        return false; // they are equal
    }

    public boolean lessThanOrEqual(ClSymbolicWeight cl) {
        // assert cl.cLevels() == cLevels()
        for (int i = 0; i < _values.length; i++) {
            if (_values[i] < cl._values[i])
                return true;
            else if (_values[i] > cl._values[i])
                return false;
        }
        return true; // they are equal
    }

    public boolean equal(ClSymbolicWeight cl) {
        for (int i = 0; i < _values.length; i++) {
            if (_values[i] != cl._values[i])
                return false;
        }
        return true; // they are equal
    }

    public boolean greaterThan(ClSymbolicWeight cl) {
        return !this.lessThanOrEqual(cl);
    }

    public boolean greaterThanOrEqual(ClSymbolicWeight cl) {
        return !this.lessThan(cl);
    }

    public boolean isNegative() {
        return this.lessThan(clsZero);
    }

    public double asDouble() {
        double sum = 0;
        double factor = 1;
        double multiplier = 1000;
        for (int i = _values.length - 1; i >= 0; i--) {
            sum += _values[i] * factor;
            factor *= multiplier;
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuffer bstr = new StringBuffer("[");
        for (int i = 0; i < _values.length - 1; i++) {
            bstr.append(_values[i]);
            bstr.append(",");
        }
        bstr.append(_values[_values.length - 1]);
        bstr.append("]");
        return bstr.toString();
    }

    public int cLevels() {
        return _values.length;
    }

}
