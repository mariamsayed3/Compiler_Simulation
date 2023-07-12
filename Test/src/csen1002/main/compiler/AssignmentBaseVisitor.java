// Generated from C:/Users/maria/OneDrive/Documents/new beginning/ACL/Test/grammar\Assignment.g4 by ANTLR 4.12.0
package csen1002.main.compiler;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link AssignmentVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class AssignmentBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements AssignmentVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStartOfGrammar(AssignmentParser.StartOfGrammarContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEachRow(AssignmentParser.EachRowContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEachRowDash(AssignmentParser.EachRowDashContext ctx) { return visitChildren(ctx); }
}