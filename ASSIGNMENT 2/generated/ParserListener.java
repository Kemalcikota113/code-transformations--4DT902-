// Generated from c:/Users/kemal/Downloads/A2/A2/Parser.g4 by ANTLR 4.13.1

    package generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ParserParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ParserParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStmt(ParserParser.FunctionCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStmt(ParserParser.FunctionCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(ParserParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(ParserParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignStmt(ParserParser.VarAssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignStmt(ParserParser.VarAssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignStmt(ParserParser.ArrayAssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignStmt(ParserParser.ArrayAssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(ParserParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(ParserParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(ParserParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(ParserParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn(ParserParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn(ParserParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ParserParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ParserParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ParserParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ParserParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(ParserParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(ParserParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ParserParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ParserParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ParserParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ParserParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void enterArrayInit(ParserParser.ArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void exitArrayInit(ParserParser.ArrayInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#arrayVar}.
	 * @param ctx the parse tree
	 */
	void enterArrayVar(ParserParser.ArrayVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arrayVar}.
	 * @param ctx the parse tree
	 */
	void exitArrayVar(ParserParser.ArrayVarContext ctx);
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
	 * Enter a parse tree produced by {@link ParserParser#arrayAssign}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(ParserParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#arrayAssign}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(ParserParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ParserParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ParserParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(ParserParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(ParserParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(ParserParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(ParserParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCharExpr(ParserParser.CharExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCharExpr(ParserParser.CharExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ParserParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ParserParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(ParserParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(ParserParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccessExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpr(ParserParser.ArrayAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccessExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpr(ParserParser.ArrayAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LengthExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLengthExpr(ParserParser.LengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LengthExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLengthExpr(ParserParser.LengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(ParserParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(ParserParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDecl}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(ParserParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDecl}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(ParserParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(ParserParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(ParserParser.ParenthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ParserParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ParserParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(ParserParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(ParserParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(ParserParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(ParserParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(ParserParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(ParserParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(ParserParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(ParserParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(ParserParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(ParserParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(ParserParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(ParserParser.IdExprContext ctx);
}