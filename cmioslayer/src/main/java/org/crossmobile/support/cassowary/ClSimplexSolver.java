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

import org.crossmobile.support.cassowary.clconstraint.ClConstraint;
import org.crossmobile.support.cassowary.clconstraint.ClEditConstraint;
import org.crossmobile.support.cassowary.clconstraint.ClLinearInequality;
import org.crossmobile.support.cassowary.clconstraint.ClStayConstraint;

import java.util.*;

public class ClSimplexSolver extends ClTableau {

    // the arrays of positive and negative error vars for the stay constraints
    // (need both positive and negative since they have only non-negative values)
    private final List<ClAbstractVariable> _stayMinusErrorVars;
    private final List<ClAbstractVariable> _stayPlusErrorVars;

    // give error variables for a non required constraint,
    // maps to ClSlackVariable-s
    private final IdentityHashMap<ClConstraint, Set<ClAbstractVariable>> _errorVars;

    // Return a lookup table giving the marker variable for each
    // constraint (used when deleting a constraint).
    private final IdentityHashMap<ClConstraint, ClAbstractVariable> _markerVars;

    private final ClObjectiveVariable _objective;

    // Map edit variables to ClEditInfo-s.
    // ClEditInfo instances contain all the information for an
    // edit constraint (the edit plus/minus vars, the index [for old-style
    // resolve(List...) interface], and the previous value.
    // (ClEditInfo replaces the parallel vectors from the Smalltalk impl.)
    private final IdentityHashMap<ClVariable, ClEditInfo> _editVarMap;

    private long _slackCounter;
    private long _artificialCounter;
    private long _dummyCounter;

    private final List<ClDouble> _resolve_pair;

    private final double _epsilon;

    private boolean _fOptimizeAutomatically;
    private boolean _fNeedsSolving;

    private final LinkedList<Integer> _stkCedcns;

    // Ctr initializes the fields, and creates the objective row
    public ClSimplexSolver() {
        _stayMinusErrorVars = new ArrayList<ClAbstractVariable>();
        _stayPlusErrorVars = new ArrayList<ClAbstractVariable>();
        _errorVars = new IdentityHashMap<ClConstraint, Set<ClAbstractVariable>>();
        _markerVars = new IdentityHashMap<ClConstraint, ClAbstractVariable>();

        _resolve_pair = new ArrayList<ClDouble>(2);
        _resolve_pair.add(new ClDouble(0));
        _resolve_pair.add(new ClDouble(0));

        _objective = new ClObjectiveVariable("Z");

        _editVarMap = new IdentityHashMap<ClVariable, ClEditInfo>();
//        assert _editVarMap == null : "edit var == null";

        _slackCounter = 0;
        _artificialCounter = 0;
        _dummyCounter = 0;
        _epsilon = 1e-8;

        _fOptimizeAutomatically = true;
        _fNeedsSolving = false;

        ClLinearExpression e = new ClLinearExpression();
        _rows.put(_objective, e);
        _stkCedcns = new LinkedList<Integer>();
        _stkCedcns.push(0);

        if (fTraceOn)
            traceprint("objective expr == " + rowExpression(_objective));
    }

    // Convenience function for creating a linear inequality constraint
    public final ClSimplexSolver addLowerBound(ClAbstractVariable v, double lower) throws RequiredConstraintFailureException,
            CLInternalError {
        ClLinearInequality cn = new ClLinearInequality(v, CL.GEQ, new ClLinearExpression(lower));
        return addConstraint(cn);
    }

    // Convenience function for creating a linear inequality constraint
    public final ClSimplexSolver addUpperBound(ClAbstractVariable v, double upper) throws RequiredConstraintFailureException,
            CLInternalError {
        ClLinearInequality cn = new ClLinearInequality(v, CL.LEQ, new ClLinearExpression(upper));
        return addConstraint(cn);
    }

    // Convenience function for creating a pair of linear inequality constraint
    public final ClSimplexSolver addBounds(ClAbstractVariable v, double lower, double upper)
            throws RequiredConstraintFailureException, CLInternalError {
        addLowerBound(v, lower);
        addUpperBound(v, upper);
        return this;
    }

    // Add constraint "cn" to the solver
    public final ClSimplexSolver addConstraint(ClConstraint cn) throws RequiredConstraintFailureException, CLInternalError {
//        System.out.println(this.hashCode()+":"+cn);
        if (fTraceOn)
            fnenterprint("addConstraint: " + cn);
        List<ClSlackVariable> eplus_eminus = new ArrayList<ClSlackVariable>(2);
        ClDouble prevEConstant = new ClDouble();
        ClLinearExpression expr = newExpression(cn, eplus_eminus, prevEConstant);
        boolean fAddedOkDirectly = false;

        try {
            fAddedOkDirectly = tryAddingDirectly(expr);
            if (!fAddedOkDirectly)
                // could not add directly
                addWithArtificialVariable(expr);
        } catch (RequiredConstraintFailureException err) {
            // /try {
            // / removeConstraint(cn); // FIXGJB
            // } catch (ExCLConstraintNotFound errNF) {
            // This should not possibly happen
            // / System.err.println("ERROR: could not find a constraint just added\n");
            // /}
            throw err;
        }

        _fNeedsSolving = true;

        if (cn.isEditConstraint()) {
            int i = _editVarMap.size();
            ClEditConstraint cnEdit = (ClEditConstraint) cn;
            ClSlackVariable clvEplus = eplus_eminus.get(0);
            ClSlackVariable clvEminus = eplus_eminus.get(1);
            _editVarMap.put(cnEdit.variable(), new ClEditInfo(cnEdit, clvEplus, clvEminus, prevEConstant.doubleValue(), i));
        }

        if (_fOptimizeAutomatically) {
            optimize(_objective);
            setExternalVariables();
        }

        cn.addedTo(this);
        return this;
    }

    // Same as addConstraint, except returns false if the constraint
    // resulted in an unsolvable system (instead of throwing an exception)
    public final boolean addConstraintNoException(ClConstraint cn) throws CLInternalError {
        if (fTraceOn)
            fnenterprint("addConstraintNoException: " + cn);

        try {
            addConstraint(cn);
            return true;
        } catch (RequiredConstraintFailureException e) {
            return false;
        }
    }

    // Add an edit constraint for "v" with given strength
    public final ClSimplexSolver addEditVar(ClVariable v, ClStrength strength) throws CLInternalError {
        try {
            ClEditConstraint cnEdit = new ClEditConstraint(v, strength);
            return addConstraint(cnEdit);
        } catch (RequiredConstraintFailureException e) {
            // should not get this
            throw new CLInternalError("Required failure when adding an edit variable");
        }
    }

    // default to strength = strong
    public final ClSimplexSolver addEditVar(ClVariable v) throws CLInternalError {
        return addEditVar(v, ClStrength.strong);
    }

    public void removeEditVar(ClVariable v) {
        ClEditInfo cei = _editVarMap.get(v);
//        if(cei==null) return;
        removeEditVar(v, cei);
    }

    // Remove the edit constraint previously added for variable v
    private void removeEditVar(ClVariable v, ClEditInfo cei) {
        ClConstraint cn = cei.Constraint();
        removeConstraintInternal(cn, v);
        cn.removedFrom(this);
    }

    // beginEdit() should be called before sending
    // resolve() messages, after adding the appropriate edit variables
    public final ClSimplexSolver beginEdit() throws CLInternalError {
//        System.out.println(_editVarMap);
//        assert _editVarMap == null : "_editVarMap == null";
        assert _editVarMap != null : "_editVarMap.size() > 0";
        // may later want to do more in here
        _infeasibleRows.clear();
        resetStayConstants();
        _stkCedcns.addFirst(_editVarMap.size());
        return this;
    }

    // endEdit should be called after editing has finished
    // for now, it just removes all edit variables
    public final ClSimplexSolver endEdit() throws CLInternalError {
        assert _editVarMap.size() > 0 : "_editVarMap.size() > 0";
        resolve();
        _stkCedcns.pop();
        int n = _stkCedcns.peek();
        removeEditVarsTo(n);
        // may later want to do more in here
        return this;
    }

    // removeAllEditVars() just eliminates all the edit constraints
    // that were added
    public final ClSimplexSolver removeAllEditVars() throws CLInternalError {
        return removeEditVarsTo(0);
    }

    // remove the last added edit vars to leave only n edit vars left
    public final ClSimplexSolver removeEditVarsTo(int n) throws CLInternalError {
        try {
            // for (Enumeration e = _editVarMap.keys(); e.hasMoreElements();) {
            // ClVariable v = (ClVariable) e.nextElement();
            // ClEditInfo cei = (ClEditInfo) _editVarMap.get(v);
            for (Iterator<Map.Entry<ClVariable, ClEditInfo>> i = _editVarMap.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry<ClVariable, ClEditInfo> entry = i.next();
                if (entry.getValue().Index() >= n) {
                    removeEditVar(entry.getKey(), entry.getValue());
                    i.remove();
                }
            }
            assert _editVarMap.size() == n : "_editVarMap.size() == n";

            return this;
        } catch (ConstraintNotFoundException e) {
            // should not get this
            throw new CLInternalError("Constraint not found in removeEditVarsTo");
        }
    }

    // Add weak stays to the x and y parts of each point. These have
    // increasing weights so that the solver will try to satisfy the x
    // and y stays on the same point, rather than the x stay on one and
    // the y stay on another.
    public final ClSimplexSolver addPointStays(List<ClPoint> listOfPoints) throws RequiredConstraintFailureException,
            CLInternalError {
        if (fTraceOn)
            fnenterprint("addPointStays" + listOfPoints);
        double weight = 1.0;
        final double multiplier = 2.0;
        int size = listOfPoints.size();
        for (int i = 0; i < size; i++) {
            addPointStay(listOfPoints.get(i), weight);
            weight *= multiplier;
        }
        return this;
    }

    public final ClSimplexSolver addPointStay(ClVariable vx, ClVariable vy, double weight)
            throws RequiredConstraintFailureException, CLInternalError {
        addStay(vx, ClStrength.weak, weight);
        addStay(vy, ClStrength.weak, weight);
        return this;
    }

    public final ClSimplexSolver addPointStay(ClVariable vx, ClVariable vy) throws RequiredConstraintFailureException,
            CLInternalError {
        addPointStay(vx, vy, 1.0);
        return this;
    }

    public final ClSimplexSolver addPointStay(ClPoint clp, double weight) throws RequiredConstraintFailureException,
            CLInternalError {
        addStay(clp.getX(), ClStrength.weak, weight);
        addStay(clp.getY(), ClStrength.weak, weight);
        return this;
    }

    public final ClSimplexSolver addPointStay(ClPoint clp) throws RequiredConstraintFailureException, CLInternalError {
        addPointStay(clp, 1.0);
        return this;
    }

    // Add a stay of the given strength (default to weak) of v to the tableau
    public final ClSimplexSolver addStay(ClVariable v, ClStrength strength, double weight)
            throws RequiredConstraintFailureException, CLInternalError {
        ClStayConstraint cn = new ClStayConstraint(v, strength, weight);
        return addConstraint(cn);
    }

    // default to weight == 1.0
    public final ClSimplexSolver addStay(ClVariable v, ClStrength strength) throws RequiredConstraintFailureException,
            CLInternalError {
        addStay(v, strength, 1.0);
        return this;
    }

    // default to strength = weak
    public final ClSimplexSolver addStay(ClVariable v) throws RequiredConstraintFailureException, CLInternalError {
        addStay(v, ClStrength.weak, 1.0);
        return this;
    }

    public ClSimplexSolver removeConstraint(ClConstraint cn) throws ConstraintNotFoundException, CLInternalError {
        removeConstraintInternal(cn, null);
        cn.removedFrom(this);
        return this;
    }

    // Remove the constraint cn from the tableau
    // Also remove any error variable associated with cn
    private ClSimplexSolver removeConstraintInternal(ClConstraint cn, ClAbstractVariable dontRemove)
            throws ConstraintNotFoundException, CLInternalError {
        if (fTraceOn)
            fnenterprint("removeConstraint: " + cn);
        if (fTraceOn)
            traceprint(this.toString());

        _fNeedsSolving = true;

        resetStayConstants();

        ClLinearExpression zRow = rowExpression(_objective);

        Set<ClAbstractVariable> eVars = _errorVars.get(cn);
        if (fTraceOn)
            traceprint("eVars == " + eVars);

        if (eVars != null)
            for (ClAbstractVariable clv : eVars) {
                final ClLinearExpression expr = rowExpression(clv);
                if (expr == null)
                    zRow.addVariable(clv, -cn.weight() * cn.strength().getSymbolicWeight().asDouble(), _objective, this);
                else // the error variable was in the basis
                    zRow.addExpression(expr, -cn.weight() * cn.strength().getSymbolicWeight().asDouble(), _objective, this);
            }

        ClAbstractVariable marker = _markerVars.remove(cn);
        if (marker == null)
            throw new ConstraintNotFoundException();

        if (fTraceOn)
            traceprint("Looking to remove var " + marker);

        if (rowExpression(marker) == null) {
            // not in the basis, so need to do some work
            Set<ClAbstractVariable> col = _columns.get(marker);

            if (fTraceOn)
                traceprint("Must pivot -- columns are " + col);

            ClAbstractVariable exitVar = null;
            double minRatio = 0.0;
            for (ClAbstractVariable v : col)
                if (v.isRestricted()) {
                    final ClLinearExpression expr = rowExpression(v);
                    double coeff = expr.coefficientFor(marker);
                    if (fTraceOn)
                        traceprint("Marker " + marker + "'s coefficient in " + expr + " is " + coeff);
                    if (coeff < 0.0) {
                        double r = -expr.constant() / coeff;
                        // Bland's anti-cycling rule:
                        // if multiple variables are about the same,
                        // always pick the lowest via some total
                        // ordering -- I use their hash codes
                        if (exitVar == null || r < minRatio || (CL.approx(r, minRatio) && v.hashCode() < exitVar.hashCode())) {
                            minRatio = r;
                            exitVar = v;
                        }
                    }
                }
            if (exitVar == null) {
                if (fTraceOn)
                    traceprint("exitVar is still null");
                for (ClAbstractVariable v : col)
                    if (v.isRestricted()) {
                        final ClLinearExpression expr = rowExpression(v);
                        double coeff = expr.coefficientFor(marker);
                        double r = expr.constant() / coeff;
                        if (exitVar == null || r < minRatio) {
                            minRatio = r;
                            exitVar = v;
                        }
                    }
            }

            if (exitVar == null)
                // exitVar is still null
                if (col.isEmpty())
                    removeColumn(marker);
                else
                    // exitVar = (ClAbstractVariable) col.elements().nextElement();
                    // was the above; instead, let's be sure we do not
                    // pick the objective --01/07/01 gjb
                    for (ClAbstractVariable v : col)
                        if (v != _objective) {
                            exitVar = v;
                            break;
                        }

            if (exitVar != null)
                pivot(marker, exitVar);
        }

        if (rowExpression(marker) != null)
            removeRow(marker);

        if (eVars != null)
            for (ClAbstractVariable v : eVars)
                // FIXGJBNOW != or equals?
                if (v != marker)
                    removeColumn(v);

        if (cn.isStayConstraint()) {
            if (eVars != null) {
                int size = _stayPlusErrorVars.size();
                for (int i = 0; i < size; i++) {
                    eVars.remove(_stayPlusErrorVars.get(i));
                    eVars.remove(_stayMinusErrorVars.get(i));
                }
            }
        } else if (cn.isEditConstraint()) {
            assert eVars != null : "eVars != null";
            ClEditConstraint cnEdit = (ClEditConstraint) cn;
            ClVariable clv = cnEdit.variable();
            ClEditInfo cei = _editVarMap.get(clv);
            ClSlackVariable clvEditMinus = cei.ClvEditMinus();
            // ClSlackVariable clvEditPlus = cei.ClvEditPlus();
            // the clvEditPlus is a marker variable that is removed elsewhere
            removeColumn(clvEditMinus);
            if (clv != dontRemove)
                _editVarMap.remove(clv);
        }

        // FIXGJB do the remove at top
        if (eVars != null)
            _errorVars.remove(eVars);
        marker = null;

        if (_fOptimizeAutomatically) {
            optimize(_objective);
            setExternalVariables();
        }

        return this;
    }

    // Re-solve the current collection of constraints for new values for
    // the constants of the edit variables.
    // DEPRECATED: use suggestValue(...) then resolve()
    // If you must use this, be sure to not use it if you
    // remove an edit variable (or edit constraint) from the middle
    // of a list of edits and then try to resolve with this function
    // (you'll get the wrong answer, because the indices will be wrong
    // in the ClEditInfo objects)
    public final void resolve(List<ClDouble> newEditConstants) throws CLInternalError {
        if (fTraceOn)
            fnenterprint("resolve" + newEditConstants);
        for (Map.Entry<ClVariable, ClEditInfo> entry : _editVarMap.entrySet()) {
            int i = entry.getValue().Index();
            try {
                if (i < newEditConstants.size())
                    suggestValue(entry.getKey(), newEditConstants.get(i).doubleValue());
            } catch (CLException err) {
                throw new CLInternalError("Error during resolve");
            }
        }
        resolve();
    }

    // Convenience function for resolve-s of two variables
    public final void resolve(double x, double y) throws CLInternalError {
        _resolve_pair.get(0).setValue(x);
        _resolve_pair.get(1).setValue(y);
        resolve(_resolve_pair);
    }

    // Re-solve the current collection of constraints, given the new
    // values for the edit variables that have already been
    // suggested (see suggestValue() method)
    public final void resolve() throws CLInternalError {
        if (fTraceOn)
            fnenterprint("resolve()");
        dualOptimize();
        setExternalVariables();
        _infeasibleRows.clear();
        resetStayConstants();
    }

    // Suggest a new value for an edit variable
    // the variable needs to be added as an edit variable
    // and beginEdit() needs to be called before this is called.
    // The tableau will not be solved completely until
    // after resolve() has been called
    public final ClSimplexSolver suggestValue(ClVariable v, double x) throws CLException {
        if (fTraceOn)
            fnenterprint("suggestValue(" + v + ", " + x + ")");
//        System.out.println("suggestValue for variable " + v + " : " + x);
        ClEditInfo cei = _editVarMap.get(v);
        if (cei == null) {
            System.err.println("suggestValue for variable " + v + ", but var is not an edit variable\n");
            throw new CLException();
        }
        ClSlackVariable clvEditPlus = cei.ClvEditPlus();
        ClSlackVariable clvEditMinus = cei.ClvEditMinus();
        double delta = x - cei.PrevEditConstant();
        cei.SetPrevEditConstant(x);
        deltaEditConstant(delta, clvEditPlus, clvEditMinus);
        return this;
    }

    // Control whether optimization and setting of external variables
    // is done automatically or not. By default it is done
    // automatically and solve() never needs to be explicitly
    // called by client code; if setAutosolve is put to false,
    // then solve() needs to be invoked explicitly before using
    // variables' values
    // (Turning off autosolve while adding lots and lots of
    // constraints [ala the addDel test in ClTests] saved
    // about 20% in runtime, from 68sec to 54sec for 900 constraints,
    // with 126 failed adds)
    public final ClSimplexSolver setAutosolve(boolean f) {
        _fOptimizeAutomatically = f;
        return this;
    }

    // Tell whether we are autosolving
    public final boolean FIsAutosolving() {
        return _fOptimizeAutomatically;
    }

    // If autosolving has been turned off, client code needs
    // to explicitly call solve() before accessing variables
    // values
    public final ClSimplexSolver solve() throws CLInternalError {
        if (_fNeedsSolving) {
            optimize(_objective);
            setExternalVariables();
        }
        return this;
    }

    public ClSimplexSolver setEditedValue(ClVariable v, double n) throws CLInternalError {
        if (!containsVariable(v)) {
            v.change_value(n);
            return this;
        }

        if (!CL.approx(n, v.getValue())) {
            addEditVar(v);
            beginEdit();
            try {
                suggestValue(v, n);
            } catch (CLException e) {
                // just added it above, so we shouldn't get an error
                throw new CLInternalError("Error in setEditedValue");
            }
            endEdit();
        }
        return this;
    }

    public final boolean containsVariable(ClVariable v) throws CLInternalError {
        return columnsHasKey(v) || (rowExpression(v) != null);
    }

    public ClSimplexSolver addVar(ClVariable v) throws CLInternalError {
        if (!containsVariable(v)) {
            try {
                addStay(v);
            } catch (RequiredConstraintFailureException e) {
                // cannot have a required failure, since we add w/ weak
                throw new CLInternalError("Error in addVar -- required failure is impossible");
            }
            if (fTraceOn)
                traceprint("added initial stay on " + v);
        }
        return this;
    }

    // Originally from Michael Noth <noth@cs>
    @Override
    public final String getInternalInfo() {
        StringBuilder retstr = new StringBuilder(super.getInternalInfo());
        retstr.append("\nSolver info:\n");
        retstr.append("Stay Error Variables: ");
        retstr.append(_stayPlusErrorVars.size() + _stayMinusErrorVars.size());
        retstr.append(" (").append(_stayPlusErrorVars.size()).append(" +, ");
        retstr.append(_stayMinusErrorVars.size()).append(" -)\n");
        retstr.append("Edit Variables: ").append(_editVarMap.size());
        retstr.append("\n");
        return retstr.toString();
    }

    public final String getDebugInfo() {
        StringBuilder bstr = new StringBuilder(toString());
        bstr.append(getInternalInfo());
        bstr.append("\n");
        return bstr.toString();
    }

    @Override
    public final String toString() {
        StringBuilder bstr = new StringBuilder(super.toString());
        bstr.append("\n_stayPlusErrorVars: ");
        bstr.append(_stayPlusErrorVars);
        bstr.append("\n_stayMinusErrorVars: ");
        bstr.append(_stayMinusErrorVars);

        bstr.append("\n");
        return bstr.toString();
    }

    public Map<ClConstraint, ClAbstractVariable> getConstraintMap() {
        return _markerVars;
    }

    // // END PUBLIC INTERFACE
    // Add the constraint expr=0 to the inequality tableau using an
    // artificial variable. To do this, create an artificial variable
    // av and add av=expr to the inequality tableau, then make av be 0.
    // (Raise an exception if we can't attain av=0.)
    protected final void addWithArtificialVariable(ClLinearExpression expr) throws RequiredConstraintFailureException,
            CLInternalError {
        if (fTraceOn)
            fnenterprint("addWithArtificialVariable: " + expr);

        ClSlackVariable av = new ClSlackVariable(++_artificialCounter, "a");
        ClObjectiveVariable az = new ClObjectiveVariable("az");
        ClLinearExpression azRow = expr.clone();

        if (fTraceOn)
            traceprint("before addRows:\n" + this);

        addRow(az, azRow);
        addRow(av, expr);

        if (fTraceOn)
            traceprint("after addRows:\n" + this);
        optimize(az);

        ClLinearExpression azTableauRow = rowExpression(az);

        if (fTraceOn)
            traceprint("azTableauRow.constant() == " + azTableauRow.constant());

        if (!CL.approx(azTableauRow.constant(), 0.0)) {
            removeRow(az);
            removeColumn(av);
            throw new RequiredConstraintFailureException();
        }

        // See if av is a basic variable
        final ClLinearExpression e = rowExpression(av);

        if (e != null) {
            // find another variable in this row and pivot,
            // so that av becomes parametric
            if (e.isConstant()) {
                // if there isn't another variable in the row
                // then the tableau contains the equation av=0 --
                // just delete av's row
                removeRow(av);
                removeRow(az);
                return;
            }
            ClAbstractVariable entryVar = e.anyPivotableVariable();
            pivot(entryVar, av);
        }
        assert rowExpression(av) == null : "rowExpression(av) == null";
        removeColumn(av);
        removeRow(az);
    }

    // We are trying to add the constraint expr=0 to the appropriate
    // tableau. Try to add expr directly to the tableax without
    // creating an artificial variable. Return true if successful and
    // false if not.
    protected final boolean tryAddingDirectly(ClLinearExpression expr) throws RequiredConstraintFailureException {
        if (fTraceOn)
            fnenterprint("tryAddingDirectly: " + expr);
        final ClAbstractVariable subject = chooseSubject(expr);
        if (subject == null) {
            if (fTraceOn)
                fnexitprint("returning false");
            return false;
        }
        expr.newSubject(subject);
        if (columnsHasKey(subject))
            substituteOut(subject, expr);
        addRow(subject, expr);
        if (fTraceOn)
            fnexitprint("returning true");
        return true; // successfully added directly
    }

    // We are trying to add the constraint expr=0 to the tableaux. Try
    // to choose a subject (a variable to become basic) from among the
    // current variables in expr. If expr contains any unrestricted
    // variables, then we must choose an unrestricted variable as the
    // subject. Also, if the subject is new to the solver we won't have
    // to do any substitutions, so we prefer new variables to ones that
    // are currently noted as parametric. If expr contains only
    // restricted variables, if there is a restricted variable with a
    // negative coefficient that is new to the solver we can make that
    // the subject. Otherwise we can't find a subject, so return nil.
    // (In this last case we have to add an artificial variable and use
    // that variable as the subject -- this is done outside this method
    // though.)
    //
    // Note: in checking for variables that are new to the solver, we
    // ignore whether a variable occurs in the objective function, since
    // new slack variables are added to the objective function by
    // 'newExpression:', which is called before this method.
    protected final ClAbstractVariable chooseSubject(ClLinearExpression expr) throws RequiredConstraintFailureException {
        if (fTraceOn)
            fnenterprint("chooseSubject: " + expr);
        ClAbstractVariable subject = null; // the current best subject, if any

        boolean foundUnrestricted = false;
        boolean foundNewRestricted = false;

        final Map<ClAbstractVariable, ClDouble> terms = expr.terms();

        for (Map.Entry<ClAbstractVariable, ClDouble> entry : terms.entrySet()) {
            final ClAbstractVariable v = entry.getKey();
            double c = entry.getValue().doubleValue();

            if (foundUnrestricted) {
                if (!v.isRestricted())
                    if (!columnsHasKey(v))
                        return v;
            } else
                // we haven't found an restricted variable yet
                if (v.isRestricted()) {
                    if (!foundNewRestricted && !v.isDummy() && c < 0.0) {
                        final Set<ClAbstractVariable> col = _columns.get(v);
                        if (col == null || (col.size() == 1 && columnsHasKey(_objective))) {
                            subject = v;
                            foundNewRestricted = true;
                        }
                    }
                } else {
                    subject = v;
                    foundUnrestricted = true;
                }
        }

        if (subject != null)
            return subject;

        double coeff = 0.0;

        for (Map.Entry<ClAbstractVariable, ClDouble> entry : terms.entrySet()) {
            final ClAbstractVariable v = entry.getKey();
            double c = entry.getValue().doubleValue();
            if (!v.isDummy())
                return null; // nope, no luck
            if (!columnsHasKey(v)) {
                subject = v;
                coeff = c;
            }
        }

        if (!CL.approx(expr.constant(), 0.0))
            throw new RequiredConstraintFailureException();
        if (coeff > 0.0)
            expr.multiplyMe(-1);
        return subject;
    }

    // Each of the non-required edits will be represented by an equation
    // of the form
    // v = c + eplus - eminus
    // where v is the variable with the edit, c is the previous edit
    // value, and eplus and eminus are slack variables that hold the
    // error in satisfying the edit constraint. We are about to change
    // something, and we want to fix the constants in the equations
    // representing the edit constraints. If one of eplus and eminus is
    // basic, the other must occur only in the expression for that basic
    // error variable. (They can't both be basic.) Fix the constant in
    // this expression. Otherwise they are both nonbasic. Find all of
    // the expressions in which they occur, and fix the constants in
    // those. See the UIST paper for details.
    // (This comment was for resetEditConstants(), but that is now
    // gone since it was part of the screwey vector-based interface
    // to resolveing. --02/16/99 gjb)
    protected final void deltaEditConstant(double delta, ClAbstractVariable plusErrorVar, ClAbstractVariable minusErrorVar) {
        if (fTraceOn)
            fnenterprint("deltaEditConstant :" + delta + ", " + plusErrorVar + ", " + minusErrorVar);
        ClLinearExpression exprPlus = rowExpression(plusErrorVar);
        if (exprPlus != null) {
            exprPlus.incrementConstant(delta);

            if (exprPlus.constant() < 0.0)
                _infeasibleRows.add(plusErrorVar);
            return;
        }

        ClLinearExpression exprMinus = rowExpression(minusErrorVar);
        if (exprMinus != null) {
            exprMinus.incrementConstant(-delta);
            if (exprMinus.constant() < 0.0)
                _infeasibleRows.add(minusErrorVar);
            return;
        }

        Set<ClAbstractVariable> columnVars = _columns.get(minusErrorVar);

        for (ClAbstractVariable basicVar : columnVars) {
            ClLinearExpression expr = rowExpression(basicVar);
            // assert(expr != null, "expr != null" );
            final double c = expr.coefficientFor(minusErrorVar);
            expr.incrementConstant(c * delta);
            if (basicVar.isRestricted() && expr.constant() < 0.0)
                _infeasibleRows.add(basicVar);
        }
    }

    // We have set new values for the constants in the edit constraints.
    // Re-optimize using the dual simplex algorithm.
    protected final void dualOptimize() throws CLInternalError {
        if (fTraceOn)
            fnenterprint("dualOptimize:");
        final ClLinearExpression zRow = rowExpression(_objective);
        while (!_infeasibleRows.isEmpty()) {
            ClAbstractVariable exitVar = _infeasibleRows.iterator().next();
            _infeasibleRows.remove(exitVar);
            ClAbstractVariable entryVar = null;
            ClLinearExpression expr = rowExpression(exitVar);
            if (expr != null)
                if (expr.constant() < 0.0) {
                    double ratio = Double.MAX_VALUE;
                    double r;
                    Map<ClAbstractVariable, ClDouble> terms = expr.terms();
                    for (Map.Entry<ClAbstractVariable, ClDouble> entry : terms.entrySet()) {
                        final ClAbstractVariable v = entry.getKey();
                        double c = entry.getValue().doubleValue();
                        if (c > 0.0 && v.isPivotable()) {
                            double zc = zRow.coefficientFor(v);
                            r = zc / c; // FIXGJB r:= zc/c or zero, as ClSymbolicWeight-s
                            if (r < ratio || (CL.approx(r, ratio) && v.hashCode() < entryVar.hashCode())) {
                                entryVar = v;
                                ratio = r;
                            }
                        }
                    }
                    if (ratio == Double.MAX_VALUE)
                        throw new CLInternalError("ratio == nil (MAX_VALUE) in dualOptimize");
                    pivot(entryVar, exitVar);
                }
        }
    }

    // Make a new linear expression representing the constraint cn,
    // replacing any basic variables with their defining expressions.
    // Normalize if necessary so that the constant is non-negative. If
    // the constraint is non-required give its error variables an
    // appropriate weight in the objective function.
    protected final ClLinearExpression newExpression(ClConstraint cn, List<ClSlackVariable> eplus_eminus, ClDouble prevEConstant) {
        if (fTraceOn)
            fnenterprint("newExpression: " + cn);
        if (fTraceOn)
            traceprint("cn.isInequality() == " + cn.isInequality());
        if (fTraceOn)
            traceprint("cn.isRequired() == " + cn.isRequired());

        final ClLinearExpression cnExpr = cn.expression();
        ClLinearExpression expr = new ClLinearExpression(cnExpr.constant());
        ClSlackVariable slackVar = new ClSlackVariable();
        // ClDummyVariable dummyVar = new ClDummyVariable();
        ClSlackVariable eminus = new ClSlackVariable();
        ClSlackVariable eplus = new ClSlackVariable();
        final Map<ClAbstractVariable, ClDouble> cnTerms = cnExpr.terms();
        for (Map.Entry<ClAbstractVariable, ClDouble> entry : cnTerms.entrySet()) {
            final ClAbstractVariable v = entry.getKey();
            double c = entry.getValue().doubleValue();
            final ClLinearExpression e = rowExpression(v);
            if (e == null)
                expr.addVariable(v, c);
            else
                expr.addExpression(e, c);
        }

        if (cn.isInequality()) {
            ++_slackCounter;
            slackVar = new ClSlackVariable(_slackCounter, "s");
            expr.setVariable(slackVar, -1);
            _markerVars.put(cn, slackVar);
            if (!cn.isRequired()) {
                ++_slackCounter;
                eminus = new ClSlackVariable(_slackCounter, "em");
                expr.setVariable(eminus, 1.0);
                ClLinearExpression zRow = rowExpression(_objective);
                ClSymbolicWeight sw = cn.strength().getSymbolicWeight().times(cn.weight());
                zRow.setVariable(eminus, sw.asDouble());
                insertErrorVar(cn, eminus);
                noteAddedVariable(eminus, _objective);
            }
        } else
            // cn is an equality
            if (cn.isRequired()) {
                ++_dummyCounter;
                ClDummyVariable dummyVar = new ClDummyVariable(_dummyCounter, "d");
                expr.setVariable(dummyVar, 1.0);
                _markerVars.put(cn, dummyVar);
                if (fTraceOn)
                    traceprint("Adding dummyVar == d" + _dummyCounter);
            } else {
                ++_slackCounter;
                eplus = new ClSlackVariable(_slackCounter, "ep");
                eminus = new ClSlackVariable(_slackCounter, "em");

                expr.setVariable(eplus, -1.0);
                expr.setVariable(eminus, 1.0);
                _markerVars.put(cn, eplus);
                ClLinearExpression zRow = rowExpression(_objective);
                ClSymbolicWeight sw = cn.strength().getSymbolicWeight().times(cn.weight());
                double swCoeff = sw.asDouble();
                if (swCoeff == 0) {
                    if (fTraceOn)
                        traceprint("sw == " + sw);
                    if (fTraceOn)
                        traceprint("cn == " + cn);
                    if (fTraceOn)
                        traceprint("adding " + eplus + " and " + eminus + " with swCoeff == " + swCoeff);
                }
                zRow.setVariable(eplus, swCoeff);
                noteAddedVariable(eplus, _objective);
                zRow.setVariable(eminus, swCoeff);
                noteAddedVariable(eminus, _objective);
                insertErrorVar(cn, eminus);
                insertErrorVar(cn, eplus);
                if (cn.isStayConstraint()) {
                    _stayPlusErrorVars.add(eplus);
                    _stayMinusErrorVars.add(eminus);
                } else if (cn.isEditConstraint()) {
                    eplus_eminus.add(eplus);
                    eplus_eminus.add(eminus);
                    prevEConstant.setValue(cnExpr.constant());
                }
            }

        if (expr.constant() < 0)
            expr.multiplyMe(-1);

        if (fTraceOn)
            fnexitprint("returning " + expr);
        return expr;
    }

    // Minimize the value of the objective. (The tableau should already
    // be feasible.)
    protected final void optimize(ClObjectiveVariable zVar) throws CLInternalError {
        if (fTraceOn)
            fnenterprint("optimize: " + zVar);
        if (fTraceOn)
            traceprint(this.toString());

        ClLinearExpression zRow = rowExpression(zVar);
        assert zRow != null : "zRow != null";
        ClAbstractVariable entryVar = null;
        ClAbstractVariable exitVar = null;
        while (true) {
            double objectiveCoeff = 0;
            Map<ClAbstractVariable, ClDouble> terms = zRow.terms();
            for (Map.Entry<ClAbstractVariable, ClDouble> entry : terms.entrySet()) {
                final ClAbstractVariable v = entry.getKey();
                double c = entry.getValue().doubleValue();
                // if (v.isPivotable() && c < 0.0 && (entryVar == null || v.hashCode() < entryVar.hashCode())) {
                if (v.isPivotable() && c < objectiveCoeff) {
                    objectiveCoeff = c;
                    entryVar = v;
                    break;
                }
            }
            if (objectiveCoeff >= -_epsilon) // || entryVar == null)
                return;
            if (fTraceOn)
                traceprint("entryVar == " + entryVar + ", objectiveCoeff == " + objectiveCoeff);

            double minRatio = Double.MAX_VALUE;
            Set<ClAbstractVariable> columnVars = _columns.get(entryVar);
            double r = 0.0;
            for (ClAbstractVariable v : columnVars) {
                if (fTraceOn)
                    traceprint("Checking " + v);
                if (v.isPivotable()) {
                    final ClLinearExpression expr = rowExpression(v);
                    double coeff = expr.coefficientFor(entryVar);
                    if (fTraceOn)
                        traceprint("pivotable, coeff = " + coeff);
                    if (coeff < 0.0) {
                        r = -expr.constant() / coeff;
                        if (r < minRatio || (CL.approx(r, minRatio) && v.hashCode() < exitVar.hashCode())) {
                            minRatio = r;
                            exitVar = v;
                        }
                    }
                }
            }
            if (minRatio == Double.MAX_VALUE)
                throw new CLInternalError("Objective function is unbounded in optimize");
            pivot(entryVar, exitVar);
            if (fTraceOn)
                traceprint(this.toString());
        }
    }

    // Do a pivot. Move entryVar into the basis (i.e. make it a basic variable),
    // and move exitVar out of the basis (i.e., make it a parametric variable)
    protected final void pivot(ClAbstractVariable entryVar, ClAbstractVariable exitVar) throws CLInternalError {

        // the entryVar might be non-pivotable if we're doing a removeConstraint --
        // otherwise it should be a pivotable variable -- enforced at call sites,
        // hopefully
        ClLinearExpression pexpr = removeRow(exitVar);

        pexpr.changeSubject(exitVar, entryVar);
        substituteOut(entryVar, pexpr);
        addRow(entryVar, pexpr);
    }

    // Each of the non-required stays will be represented by an equation
    // of the form
    // v = c + eplus - eminus
    // where v is the variable with the stay, c is the previous value of
    // v, and eplus and eminus are slack variables that hold the error
    // in satisfying the stay constraint. We are about to change
    // something, and we want to fix the constants in the equations
    // representing the stays. If both eplus and eminus are nonbasic
    // they have value 0 in the current solution, meaning the previous
    // stay was exactly satisfied. In this case nothing needs to be
    // changed. Otherwise one of them is basic, and the other must
    // occur only in the expression for that basic error variable.
    // Reset the constant in this expression to 0.
    protected final void resetStayConstants() {
        int size = _stayPlusErrorVars.size();
        for (int i = 0; i < size; i++) {
            ClLinearExpression expr = rowExpression(_stayPlusErrorVars.get(i));
            if (expr == null)
                expr = rowExpression(_stayMinusErrorVars.get(i));
            if (expr != null)
                expr.set_constant(0.0);
        }
    }

    // Set the external variables known to this solver to their appropriate values.
    // Set each external basic variable to its value, and set each
    // external parametric variable to 0. (It isn't clear that we will
    // ever have external parametric variables -- every external
    // variable should either have a stay on it, or have an equation
    // that defines it in terms of other external variables that do have
    // stays. For the moment I'll put this in though.) Variables that
    // are internal to the solver don't actually store values -- their
    // values are just implicit in the tableu -- so we don't need to set
    // them.
    protected final void setExternalVariables() {
        for (ClVariable v : _externalParametricVars) {
            if (_rows.containsKey(v)) {
                System.err.println("Error: variable" + v + " in _externalParametricVars is basic");
                continue;
            }
            v.change_value(0.0);
        }

        for (ClVariable v : _externalRows) {
            ClLinearExpression expr = rowExpression(v);
            v.change_value(expr.constant());
        }

        _fNeedsSolving = false;
    }

    // Protected convenience function to insert an error variable into
    // the _errorVars set, creating the mapping with put as necessary
    protected final void insertErrorVar(ClConstraint cn, ClAbstractVariable var) {
        if (fTraceOn)
            fnenterprint("insertErrorVar:" + cn + ", " + var);

        Set<ClAbstractVariable> cnset = _errorVars.get(var);
        if (cnset == null)
            _errorVars.put(cn, cnset = new HashSet<ClAbstractVariable>());
        cnset.add(var);
    }
}
