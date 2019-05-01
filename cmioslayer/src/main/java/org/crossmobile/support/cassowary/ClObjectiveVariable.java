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

class ClObjectiveVariable extends ClAbstractVariable {
    public ClObjectiveVariable(String name) {
        super(name);
    }

    public ClObjectiveVariable(long number, String prefix) {
        super(number, prefix);
    }

    @Override
    public String toString() {
        return "[" + name() + ":obj]";
    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    public boolean isPivotable() {
        return false;
    }

    @Override
    public boolean isRestricted() {
        return false;
    }

}
