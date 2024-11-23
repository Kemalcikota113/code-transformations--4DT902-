// Generated from c:/Users/kemal/OneDrive/Skrivbord/uni-material/Code transformations (4DT902)/ASSIGNMENT 0/SimpleParser.g4 by ANTLR 4.13.1
  // Define name of package for generated Java files. 
    package generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParserParser}.
 */
public interface SimpleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleParserParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleParserParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SimpleParserParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SimpleParserParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(SimpleParserParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(SimpleParserParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParserParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParserParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(SimpleParserParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(SimpleParserParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SimpleParserParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SimpleParserParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SimpleParserParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SimpleParserParser.CommentContext ctx);
}