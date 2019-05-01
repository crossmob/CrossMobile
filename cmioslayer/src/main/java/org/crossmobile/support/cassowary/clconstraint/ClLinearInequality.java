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

import org.crossmobile.support.cassowary.*;

public class ClLinearInequality extends ClLinearConstraint {

    public ClLinearInequality(ClLinearExpression cle, ClStrength strength, double weight) {
        super(cle, strength, weight);
    }

    public ClLinearInequality(ClLinearExpression cle, ClStrength strength) {
        super(cle, strength);
    }

    public ClLinearInequality(ClLinearExpression cle) {
        super(cle);
    }

    public ClLinearInequality(ClVariable clv1, byte op_enum, ClVariable clv2, ClStrength strength, double weight)
            throws CLInternalError {
        super(new ClLinearExpression(clv2), strength, weight);
        if (op_enum == CL.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv1);
        } else if (op_enum == CL.LEQ) {
            _expression.addVariable(clv1, -1.0);
        } else
            // the operator was invalid
            throw new CLInternalError("Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClVariable clv1, byte op_enum, ClVariable clv2, ClStrength strength) throws CLInternalError {
        this(clv1, op_enum, clv2, strength, 1.0);
    }

    public ClLinearInequality(ClVariable clv1, byte op_enum, ClVariable clv2) throws CLInternalError {
        this(clv1, op_enum, clv2, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClVariable clv, byte op_enum, double val, ClStrength strength, double weight)
            throws CLInternalError {
        super(new ClLinearExpression(val), strength, weight);
        if (op_enum == CL.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.LEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new CLInternalError("Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClVariable clv, byte op_enum, double val, ClStrength strength) throws CLInternalError {
        this(clv, op_enum, val, strength, 1.0);
    }

    public ClLinearInequality(ClVariable clv, byte op_enum, double val) throws CLInternalError {
        this(clv, op_enum, val, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle1, byte op_enum, ClLinearExpression cle2, ClStrength strength, double weight)
            throws CLInternalError {
        super(cle2.clone(), strength, weight);
        if (op_enum == CL.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addExpression(cle1);
        } else if (op_enum == CL.LEQ) {
            _expression.addExpression(cle1, -1.0);
        } else
            // the operator was invalid
            throw new CLInternalError("Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClLinearExpression cle1, byte op_enum, ClLinearExpression cle2, ClStrength strength)
            throws CLInternalError {
        this(cle1, op_enum, cle2, strength, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle1, byte op_enum, ClLinearExpression cle2) throws CLInternalError {
        this(cle1, op_enum, cle2, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClAbstractVariable clv, byte op_enum, ClLinearExpression cle, ClStrength strength, double weight)
            throws CLInternalError {
        super(cle.clone(), strength, weight);
        if (op_enum == CL.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.LEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new CLInternalError("Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClAbstractVariable clv, byte op_enum, ClLinearExpression cle, ClStrength strength)
            throws CLInternalError {
        this(clv, op_enum, cle, strength, 1.0);
    }

    public ClLinearInequality(ClAbstractVariable clv, byte op_enum, ClLinearExpression cle) throws CLInternalError {
        this(clv, op_enum, cle, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle, byte op_enum, ClAbstractVariable clv, ClStrength strength, double weight)
            throws CLInternalError {
        super(cle.clone(), strength, weight);
        if (op_enum == CL.LEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.GEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new CLInternalError("Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClLinearExpression cle, byte op_enum, ClAbstractVariable clv, ClStrength strength)
            throws CLInternalError {
        this(cle, op_enum, clv, strength, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle, byte op_enum, ClAbstractVariable clv) throws CLInternalError {
        this(cle, op_enum, clv, ClStrength.required, 1.0);
    }

    @Override
    public final boolean isInequality() {
        return true;
    }

    @Override
    public final String toString() {
        return super.toString() + " >= 0 )";
    }
}
