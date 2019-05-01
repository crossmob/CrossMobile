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

public class ClStayConstraint extends ClEditOrStayConstraint {

    public ClStayConstraint(ClVariable var, ClStrength strength, double weight) {
        super(var, strength, weight);
    }

    public ClStayConstraint(ClVariable var, ClStrength strength) {
        super(var, strength, 1.0);
    }

    public ClStayConstraint(ClVariable var) {
        super(var, ClStrength.weak, 1.0);
    }

    @Override
    public boolean isStayConstraint() {
        return true;
    }

    @Override
    public String toString() {
        return "stay " + super.toString();
    }

}
