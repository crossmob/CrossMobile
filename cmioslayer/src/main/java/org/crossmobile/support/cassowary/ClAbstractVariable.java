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

public abstract class ClAbstractVariable {
    private String _name;

    private static int iVariableNumber;

    public ClAbstractVariable(String name) {
        _name = name;
        iVariableNumber++;
    }

    public ClAbstractVariable() {
        _name = "v" + iVariableNumber;
        iVariableNumber++;
    }

    public ClAbstractVariable(long varnumber, String prefix) {
        _name = prefix + varnumber;
        iVariableNumber++;
    }

    public String name() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public boolean isDummy() {
        return false;
    }

    public abstract boolean isExternal();

    public abstract boolean isPivotable();

    public abstract boolean isRestricted();

    @Override
    public abstract String toString();

    public static int numCreated() {
        return iVariableNumber;
    }

}
