// Generated from C:/Users/maria/OneDrive/Documents/new beginning/ACL/Test/grammar\Assignment.g4 by ANTLR 4.12.0
package csen1002.main.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AssignmentParser}.
 */
public interface AssignmentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AssignmentParser#startOfGrammar}.
	 * @param ctx the parse tree
	 */
	void enterStartOfGrammar(AssignmentParser.StartOfGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignmentParser#startOfGrammar}.
	 * @param ctx the parse tree
	 */
	void exitStartOfGrammar(AssignmentParser.StartOfGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssignmentParser#eachRow}.
	 * @param ctx the parse tree
	 */
	void enterEachRow(AssignmentParser.EachRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignmentParser#eachRow}.
	 * @param ctx the parse tree
	 */
	void exitEachRow(AssignmentParser.EachRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssignmentParser#eachRowDash}.
	 * @param ctx the parse tree
	 */
	void enterEachRowDash(AssignmentParser.EachRowDashContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssignmentParser#eachRowDash}.
	 * @param ctx the parse tree
	 */
	void exitEachRowDash(AssignmentParser.EachRowDashContext ctx);
}