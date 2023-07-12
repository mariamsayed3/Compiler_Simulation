// Generated from C:/Users/maria/OneDrive/Documents/new beginning/ACL/Test/grammar\Assignment.g4 by ANTLR 4.12.0
package csen1002.main.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AssignmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AssignmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AssignmentParser#startOfGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartOfGrammar(AssignmentParser.StartOfGrammarContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssignmentParser#eachRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEachRow(AssignmentParser.EachRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssignmentParser#eachRowDash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEachRowDash(AssignmentParser.EachRowDashContext ctx);
}