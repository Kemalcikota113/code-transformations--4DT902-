// Generated from c:/Users/kemal/OneDrive/Skrivbord/uni-material/Code transformations (4DT902)/ASSIGNMENT 1/Parser.g4 by ANTLR 4.13.1
    // Define name of package for generated Java files. 
    package generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ParserParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ParserParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(ParserParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(ParserParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParserParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#mainDecl}.
	 * @param ctx the parse tree
	 */
	void enterMainDecl(ParserParser.MainDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#mainDecl}.
	 * @param ctx the parse tree
	 */
	void exitMainDecl(ParserParser.MainDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(ParserParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(ParserParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ParserParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ParserParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(ParserParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(ParserParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(ParserParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(ParserParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(ParserParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(ParserParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(ParserParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(ParserParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(ParserParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(ParserParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#dot}.
	 * @param ctx the parse tree
	 */
	void enterDot(ParserParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#dot}.
	 * @param ctx the parse tree
	 */
	void exitDot(ParserParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ParserParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ParserParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void enterMethodDef(ParserParser.MethodDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void exitMethodDef(ParserParser.MethodDefContext ctx);
}