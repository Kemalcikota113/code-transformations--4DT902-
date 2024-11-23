// Generated from c:/Users/kemal/OneDrive/Skrivbord/uni-material/Code transformations (4DT902)/ASSIGNMENT 0/SimpleParser.g4 by ANTLR 4.13.1
    // Define name of package for generated Java files. 
    package generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(SimpleParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(SimpleParserParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SimpleParserParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(SimpleParserParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(SimpleParserParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(SimpleParserParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(SimpleParserParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SimpleParserParser.PrintContext ctx);
}