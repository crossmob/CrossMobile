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
import org.crossmobile.support.cassowary.ClStrength;
import org.crossmobile.support.cassowary.ClVariable;

abstract class ClEditOrStayConstraint extends ClConstraint {

    protected ClVariable _variable;
    // cache the expresion
    private ClLinearExpression _expression;

    public ClEditOrStayConstraint(ClVariable var, ClStrength strength, double weight) {
        super(strength, weight);
        _variable = var;
        _expression = new ClLinearExpression(_variable, -1.0, _variable.getValue());
    }

    public ClEditOrStayConstraint(ClVariable var, ClStrength strength) {
        this(var, strength, 1.0);
    }

    public ClEditOrStayConstraint(ClVariable var) {
        this(var, ClStrength.required, 1.0);
        _variable = var;
    }

    public ClVariable variable() {
        return _variable;
    }

    @Override
    public ClLinearExpression expression() {
        return _expression;
    }

}
