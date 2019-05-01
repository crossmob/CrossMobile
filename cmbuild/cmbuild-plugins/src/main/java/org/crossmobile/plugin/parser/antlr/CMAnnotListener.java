// Generated from CMAnnot.g4 by ANTLR 4.7.1
package org.crossmobile.plugin.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CMAnnotParser}.
 */
public interface CMAnnotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(CMAnnotParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(CMAnnotParser.ClassdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#protinheritance}.
	 * @param ctx the parse tree
	 */
	void enterProtinheritance(CMAnnotParser.ProtinheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#protinheritance}.
	 * @param ctx the parse tree
	 */
	void exitProtinheritance(CMAnnotParser.ProtinheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(CMAnnotParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(CMAnnotParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(CMAnnotParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(CMAnnotParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(CMAnnotParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(CMAnnotParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#propertydef}.
	 * @param ctx the parse tree
	 */
	void enterPropertydef(CMAnnotParser.PropertydefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#propertydef}.
	 * @param ctx the parse tree
	 */
	void exitPropertydef(CMAnnotParser.PropertydefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#cparts}.
	 * @param ctx the parse tree
	 */
	void enterCparts(CMAnnotParser.CpartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#cparts}.
	 * @param ctx the parse tree
	 */
	void exitCparts(CMAnnotParser.CpartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(CMAnnotParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(CMAnnotParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#extconst}.
	 * @param ctx the parse tree
	 */
	void enterExtconst(CMAnnotParser.ExtconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#extconst}.
	 * @param ctx the parse tree
	 */
	void exitExtconst(CMAnnotParser.ExtconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(CMAnnotParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(CMAnnotParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#selectorNamedParam}.
	 * @param ctx the parse tree
	 */
	void enterSelectorNamedParam(CMAnnotParser.SelectorNamedParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#selectorNamedParam}.
	 * @param ctx the parse tree
	 */
	void exitSelectorNamedParam(CMAnnotParser.SelectorNamedParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#selectorParam}.
	 * @param ctx the parse tree
	 */
	void enterSelectorParam(CMAnnotParser.SelectorParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#selectorParam}.
	 * @param ctx the parse tree
	 */
	void exitSelectorParam(CMAnnotParser.SelectorParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#returntype}.
	 * @param ctx the parse tree
	 */
	void enterReturntype(CMAnnotParser.ReturntypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#returntype}.
	 * @param ctx the parse tree
	 */
	void exitReturntype(CMAnnotParser.ReturntypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#listofvariables}.
	 * @param ctx the parse tree
	 */
	void enterListofvariables(CMAnnotParser.ListofvariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#listofvariables}.
	 * @param ctx the parse tree
	 */
	void exitListofvariables(CMAnnotParser.ListofvariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#var_type_name}.
	 * @param ctx the parse tree
	 */
	void enterVar_type_name(CMAnnotParser.Var_type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#var_type_name}.
	 * @param ctx the parse tree
	 */
	void exitVar_type_name(CMAnnotParser.Var_type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CMAnnotParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CMAnnotParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterVartype(CMAnnotParser.VartypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitVartype(CMAnnotParser.VartypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CMAnnotParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CMAnnotParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#simple_vartype_name}.
	 * @param ctx the parse tree
	 */
	void enterSimple_vartype_name(CMAnnotParser.Simple_vartype_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#simple_vartype_name}.
	 * @param ctx the parse tree
	 */
	void exitSimple_vartype_name(CMAnnotParser.Simple_vartype_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#simple_vartype}.
	 * @param ctx the parse tree
	 */
	void enterSimple_vartype(CMAnnotParser.Simple_vartypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#simple_vartype}.
	 * @param ctx the parse tree
	 */
	void exitSimple_vartype(CMAnnotParser.Simple_vartypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMAnnotParser#visibility}.
	 * @param ctx the parse tree
	 */
	void enterVisibility(CMAnnotParser.VisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMAnnotParser#visibility}.
	 * @param ctx the parse tree
	 */
	void exitVisibility(CMAnnotParser.VisibilityContext ctx);
}