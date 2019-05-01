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

public class ClVariable extends ClAbstractVariable {

    private double _value;

    private Object _attachedObject;

    public ClVariable(String name, double value) {
        super(name);
        _value = value;
    }

    public ClVariable(String name) {
        super(name);
        _value = 0.0;
    }

    public ClVariable(double value) {
        _value = value;
    }

    public ClVariable() {
        _value = 0.0;
    }

    public ClVariable(long number, String prefix, double value) {
        super(number, prefix);
        _value = value;
    }

    public ClVariable(long number, String prefix) {
        super(number, prefix);
        _value = 0.0;
    }

    @Override
    public boolean isDummy() {
        return false;
    }

    @Override
    public boolean isExternal() {
        return true;
    }

    @Override
    public boolean isPivotable() {
        return false;
    }

    @Override
    public boolean isRestricted() {
        return false;
    }

    @Override
    public String toString() {
        return "[" + name() + ":" + _value + "]";
    }

    public final double getValue() {
        return _value;
    }

    // change the value held -- should *not* use this if the variable is
    // in a solver -- instead use addEditVar() and suggestValue() interface
    public final void setValue(double value) {
        _value = value;
    }

    // permit overriding in subclasses in case something needs to be
    // done when the value is changed by the solver
    // may be called when the value hasn't actually changed -- just
    // means the solver is setting the external variable
    public void change_value(double value) {
        _value = value;
    }

    public void setAttachedObject(Object o) {
        _attachedObject = o;
    }

    public Object getAttachedObject() {
        return _attachedObject;
    }

}
