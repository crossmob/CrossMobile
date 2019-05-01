// Generated from LProj.g4 by ANTLR 4.5.3
package org.crossmobile.build.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LProjParser}.
 */
public interface LProjListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LProjParser#lproj}.
     *
     * @param ctx the parse tree
     */
    void enterLproj(LProjParser.LprojContext ctx);

    /**
     * Exit a parse tree produced by {@link LProjParser#lproj}.
     *
     * @param ctx the parse tree
     */
    void exitLproj(LProjParser.LprojContext ctx);

    /**
     * Enter a parse tree produced by {@link LProjParser#elements}.
     *
     * @param ctx the parse tree
     */
    void enterElements(LProjParser.ElementsContext ctx);

    /**
     * Exit a parse tree produced by {@link LProjParser#elements}.
     *
     * @param ctx the parse tree
     */
    void exitElements(LProjParser.ElementsContext ctx);

    /**
     * Enter a parse tree produced by {@link LProjParser#pair}.
     *
     * @param ctx the parse tree
     */
    void enterPair(LProjParser.PairContext ctx);

    /**
     * Exit a parse tree produced by {@link LProjParser#pair}.
     *
     * @param ctx the parse tree
     */
    void exitPair(LProjParser.PairContext ctx);
}