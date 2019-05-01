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

/**
 * The enumerations from ClLinearInequality, and `global' functions that we want easy to access
 */
package org.crossmobile.support.cassowary;

public class CL {
    protected final static boolean fDebugOn = false;
    public static boolean fTraceOn = false; // true;
    protected final static boolean fTraceAdded = false;
    protected final static boolean fGC = false;

    protected static void debugprint(String s) {
        System.err.println(s);
    }

    protected static void traceprint(String s) {
        System.err.println(s);
    }

    protected static void fnenterprint(String s) {
        System.err.println("* " + s);
    }

    protected static void fnexitprint(String s) {
        System.err.println("- " + s);
    }

    public static final byte GEQ = 1;
    public static final byte LEQ = 2;

    public static ClLinearExpression Plus(ClLinearExpression e1, ClLinearExpression e2) {
        return e1.plus(e2);
    }

    public static ClLinearExpression Plus(ClLinearExpression e1, double e2) {
        return e1.plus(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Plus(double e1, ClLinearExpression e2) {
        return (new ClLinearExpression(e1)).plus(e2);
    }

    public static ClLinearExpression Plus(ClVariable e1, ClLinearExpression e2) {
        return (new ClLinearExpression(e1)).plus(e2);
    }

    public static ClLinearExpression Plus(ClLinearExpression e1, ClVariable e2) {
        return e1.plus(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Plus(ClVariable e1, double e2) {
        return (new ClLinearExpression(e1)).plus(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Plus(double e1, ClVariable e2) {
        return (new ClLinearExpression(e1)).plus(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Minus(ClLinearExpression e1, ClLinearExpression e2) {
        return e1.minus(e2);
    }

    public static ClLinearExpression Minus(double e1, ClLinearExpression e2) {
        return (new ClLinearExpression(e1)).minus(e2);
    }

    public static ClLinearExpression Minus(ClLinearExpression e1, double e2) {
        return e1.minus(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Times(ClLinearExpression e1, ClLinearExpression e2) throws NonlinearExpressionException {
        return e1.times(e2);
    }

    public static ClLinearExpression Times(ClLinearExpression e1, ClVariable e2) throws NonlinearExpressionException {
        return e1.times(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Times(ClVariable e1, ClLinearExpression e2) throws NonlinearExpressionException {
        return (new ClLinearExpression(e1)).times(e2);
    }

    public static ClLinearExpression Times(ClLinearExpression e1, double e2) throws NonlinearExpressionException {
        return e1.times(new ClLinearExpression(e2));
    }

    public static ClLinearExpression Times(double e1, ClLinearExpression e2) throws NonlinearExpressionException {
        return (new ClLinearExpression(e1)).times(e2);
    }

    public static ClLinearExpression Times(double n, ClVariable clv) throws NonlinearExpressionException {
        return (new ClLinearExpression(clv, n));
    }

    public static ClLinearExpression Times(ClVariable clv, double n) throws NonlinearExpressionException {
        return (new ClLinearExpression(clv, n));
    }

    public static ClLinearExpression Divide(ClLinearExpression e1, ClLinearExpression e2) throws NonlinearExpressionException {
        return e1.divide(e2);
    }

    public static boolean approx(double a, double b) {
        double epsilon = 1.0e-8;
        if (a == 0.0) {
            return (Math.abs(b) < epsilon);
        } else if (b == 0.0) {
            return (Math.abs(a) < epsilon);
        } else {
            return (Math.abs(a - b) < Math.abs(a) * epsilon);
        }
    }

    public static boolean approx(ClVariable clv, double b) {
        return approx(clv.getValue(), b);
    }

    static boolean approx(double a, ClVariable clv) {
        return approx(a, clv.getValue());
    }
}
