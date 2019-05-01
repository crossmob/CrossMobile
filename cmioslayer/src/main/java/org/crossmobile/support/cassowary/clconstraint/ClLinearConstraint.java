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

class ClLinearConstraint extends ClConstraint {
    protected ClLinearExpression _expression;

    public ClLinearConstraint(ClLinearExpression cle, ClStrength strength, double weight) {
        super(strength, weight);
        _expression = cle;
    }

    public ClLinearConstraint(ClLinearExpression cle, ClStrength strength) {
        super(strength, 1.0);
        _expression = cle;
    }

    public ClLinearConstraint(ClLinearExpression cle) {
        super(ClStrength.required, 1.0);
        _expression = cle;
    }

    @Override
    public ClLinearExpression expression() {
        return _expression;
    }

    protected void setExpression(ClLinearExpression expr) {
        _expression = expr;
    }

}
