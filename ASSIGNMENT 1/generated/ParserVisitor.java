// Generated from c:/Users/kemal/OneDrive/Skrivbord/uni-material/Code transformations (4DT902)/ASSIGNMENT 1/Parser.g4 by ANTLR 4.13.1
    // Define name of package for generated Java files. 
    package generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(ParserParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ParserParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#mainDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDecl(ParserParser.MainDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(ParserParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ParserParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(ParserParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(ParserParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(ParserParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(ParserParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(ParserParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arrayUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayUpdate(ParserParser.ArrayUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(ParserParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(ParserParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#methodDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDef(ParserParser.MethodDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(ParserParser.ReturnContext ctx);
}