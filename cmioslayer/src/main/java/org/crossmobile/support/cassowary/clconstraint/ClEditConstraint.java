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

import org.crossmobile.support.cassowary.ClStrength;
import org.crossmobile.support.cassowary.ClVariable;

public class ClEditConstraint extends ClEditOrStayConstraint {

    public ClEditConstraint(ClVariable clv, ClStrength strength, double weight) {
        super(clv, strength, weight);
    }

    public ClEditConstraint(ClVariable clv, ClStrength strength) {
        super(clv, strength);
    }

    public ClEditConstraint(ClVariable clv) {
        super(clv);
    }

    @Override
    public boolean isEditConstraint() {
        return true;
    }

    @Override
    public String toString() {
        return "edit" + super.toString();
    }

}
