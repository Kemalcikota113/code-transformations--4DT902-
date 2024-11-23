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
	 * Enter a parse tree produced by {@link SimpleParserParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SimpleParserParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SimpleParserParser.StartContext ctx);
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
	 * Enter a parse tree produced by {@link SimpleParserParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(SimpleParserParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(SimpleParserParser.DeclareContext ctx);
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
	 * Enter a parse tree produced by {@link SimpleParserParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(SimpleParserParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(SimpleParserParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(SimpleParserParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(SimpleParserParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(SimpleParserParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(SimpleParserParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(SimpleParserParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(SimpleParserParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SimpleParserParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SimpleParserParser.PrintContext ctx);
}