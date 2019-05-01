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

package org.crossmobile.support.cassowary.clconstraint;

import org.crossmobile.support.cassowary.ClLinearExpression;
import org.crossmobile.support.cassowary.ClSimplexSolver;
import org.crossmobile.support.cassowary.ClStrength;
import org.crossmobile.support.cassowary.TooDifficultException;

public abstract class ClConstraint {
    private ClStrength _strength;
    private double _weight;

    private Object _attachedObject;

    private int _times_added;

    public ClConstraint(ClStrength strength, double weight) {
        _strength = strength;
        _weight = weight;
        _times_added = 0;
    }

    public ClConstraint(ClStrength strength) {
        this(strength, 1.0);
    }

    public ClConstraint() {
        this(ClStrength.required, 1.0);
    }

    public abstract ClLinearExpression expression();

    public boolean isEditConstraint() {
        return false;
    }

    public boolean isInequality() {
        return false;
    }

    public boolean isRequired() {
        return _strength.isRequired();
    }

    public boolean isStayConstraint() {
        return false;
    }

    public ClStrength strength() {
        return _strength;
    }

    public double weight() {
        return _weight;
    }

    @Override
    public String toString() {
        return _strength.toString() + " {" + weight() + "} (" + expression();
    }

    public void setAttachedObject(Object o) {
        _attachedObject = o;
    }

    public Object getAttachedObject() {
        return _attachedObject;
    }

    public void changeStrength(ClStrength strength) throws TooDifficultException {
        if (_times_added == 0) {
            setStrength(strength);
        } else {
            throw new TooDifficultException();
        }
    }

    public void addedTo(ClSimplexSolver solver) {
        ++_times_added;
    }

    public void removedFrom(ClSimplexSolver solver) {
        --_times_added;
    }

    private void setStrength(ClStrength strength) {
        _strength = strength;
    }

}
