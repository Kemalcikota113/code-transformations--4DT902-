// Generated from c:/Users/Blin/Desktop/code transformation/A3/Parser.g4 by ANTLR 4.13.1

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
	 * Visit a parse tree produced by {@link ParserParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ParserParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStmt(ParserParser.FunctionCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(ParserParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignStmt(ParserParser.VarAssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignStmt(ParserParser.ArrayAssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(ParserParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(ParserParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(ParserParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link ParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ParserParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ParserParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(ParserParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ParserParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(ParserParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arrayInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInit(ParserParser.ArrayInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arrayVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVar(ParserParser.ArrayVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ParserParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#arrayAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(ParserParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ParserParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(ParserParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(ParserParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(ParserParser.CharExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(ParserParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(ParserParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccessExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpr(ParserParser.ArrayAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LengthExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthExpr(ParserParser.LengthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(ParserParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayDecl}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(ParserParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(ParserParser.ParenthesesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ParserParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(ParserParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(ParserParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(ParserParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(ParserParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(ParserParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(ParserParser.IdExprContext ctx);
}