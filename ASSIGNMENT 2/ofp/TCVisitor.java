package ofp;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import generated.ParserBaseVisitor;
import generated.ParserParser;

public class TCVisitor extends ParserBaseVisitor<OFPType> {
    private ParseTreeProperty<Scope> scopes;
    private Scope currentScope;

    public TCVisitor(ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
    }

    @Override
    public OFPType visitIntExpr(ParserParser.IntExprContext ctx) {
        return OFPType.intType;
    }

    @Override
    public OFPType visitFloatExpr(ParserParser.FloatExprContext ctx) {
        return OFPType.floatType;
    }

    @Override
    public OFPType visitBoolExpr(ParserParser.BoolExprContext ctx) {
        return OFPType.boolType; 
    }

    @Override
    public OFPType visitCharExpr(ParserParser.CharExprContext ctx) {
        return OFPType.charType; 
    }

    @Override
    public OFPType visitStringExpr(ParserParser.StringExprContext ctx) {
        return OFPType.stringType;
    }


    @Override
    public OFPType visitFunctionCall(ParserParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        Symbol functionSymbol = currentScope.resolve(functionName);
        
        if (functionSymbol == null || !(functionSymbol instanceof FunctionSymbol)) {
            System.err.println("Error: Function '" + functionName + "' is not declared.");
            return OFPType.errorType;
        }
        
        FunctionSymbol funcSym = (FunctionSymbol) functionSymbol;   // cast to FunctionSymbol object so that we can use the object functions
        if (ctx.expr().size() != funcSym.getParameters().size()) {
            System.err.println("Error: Function '" + functionName + "' expects " + funcSym.getParameters().size() + " arguments, but " + ctx.expr().size() + " were provided.");
            return OFPType.errorType;
        }
        
        // argument types
        for (int i = 0; i < ctx.expr().size(); i++) {
            OFPType argType = visit(ctx.expr(i));
            OFPType paramType = funcSym.getParameters().get(i).getType();

            if (argType.equals(OFPType.voidType)) {
                System.err.println("Error: Cannot pass void as an argument to function '" + functionName + "'.");
                return OFPType.errorType;
            }
            
            if (!argType.equals(paramType)) {
                System.err.println("Error: Argument type mismatch in function '" + functionName + "'. Expected '" + paramType + "', but got '" + argType + "'.");
                return OFPType.errorType;
            }
        }
        
        return funcSym.getReturnType();  // Return the function's return type
    }


    @Override
    public OFPType visitReturnStmt(ParserParser.ReturnStmtContext ctx) {
        Scope returnScope = scopes.get(ctx);
    
        if (returnScope == null) {
            System.err.println("Error: 'return' statement is outside of a valid scope.");
            return OFPType.errorType;
        }
    
        FunctionSymbol currentFunction = returnScope.getEnclosingScope().getFunctionSymbol();
    
        if (currentFunction == null) {
            System.err.println("Error: 'return' statement is used outside of a function at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine() + ".");
            return OFPType.errorType;
        }
    
        if (currentFunction.getReturnType().equals(OFPType.voidType)) {
            if (ctx.expr() != null) {
                System.err.println("Error: Cannot return a value from a void function.");
                return OFPType.errorType;
            }
        } else {
            if (ctx.expr() == null) {
                System.err.println("Error: Function '" + currentFunction.getName() + "' requires a return value.");
                return OFPType.errorType;
            }
    
            OFPType returnType = visit(ctx.expr());

            if (!returnType.equals(currentFunction.getReturnType())) {
                System.err.println("Error: Return type mismatch in function '" + currentFunction.getName() + "'. Expected '" + currentFunction.getReturnType() + "' but got '" + returnType + "'.");
                return OFPType.errorType;
            }
        }
    
        return null;
    }    

    @Override
    public OFPType visitBlock(ParserParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);  // Enter new scope
        super.visitBlock(ctx);
        currentScope = currentScope.getEnclosingScope();  // Exit the scope
        return null;
    }

    @Override
    public OFPType visitIdExpr(ParserParser.IdExprContext ctx) {
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);

        if (varSymbol == null) {
            System.err.println("Error: Variable '" + varName + "' not declared.");
            return OFPType.errorType;  // error
        }

        return varSymbol.getType();  // variable's type
    }

    @Override
    public OFPType visitDecl(ParserParser.DeclContext ctx) {
        String varName = ctx.ID().getText();
        OFPType exprType = visit(ctx.expr());
        OFPType varType = OFPType.getTypeFor(ctx.TYPE().getText());
        
        if (ctx.expr() != null) {

            if (exprType.equals(OFPType.voidType)) {
                System.err.println("Error: Cannot assign void type to variable '" + varName + "'.");
                return OFPType.errorType;
            }

            if ((varType.equals(OFPType.intArrType) || varType.equals(OFPType.floatArrType) || varType.equals(OFPType.charArrType)) && (exprType.equals(OFPType.intType) || exprType.equals(OFPType.floatType) || exprType.equals(OFPType.charType))) {

                if(!(!(varType.equals(OFPType.intArrType) && exprType.equals(OFPType.intType)) || !(varType.equals(OFPType.floatArrType) && exprType.equals(OFPType.floatType)) || !(varType.equals(OFPType.charArrType) && exprType.equals(OFPType.charType)))) {
                    System.err.println("Error: Type mismatch in array assignment. Expected '" + varType + "' but got '" + exprType + "'.");
                    return OFPType.errorType;
                }
 
            }
            else if (!varType.equals(exprType)) {
                System.err.println("Error: Type mismatch in assignment. Expected '" + varType + "' but got '" + exprType + "'.");
                return OFPType.errorType;
            }
        }

        Symbol varSymbol = new Symbol(varName, varType);
        currentScope.define(varSymbol);

        return varType;
    }

    @Override
    public OFPType visitAssign(ParserParser.AssignContext ctx) {
        OFPType exprType = visit(ctx.expr());   // type of expression being assigned 
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);

        if (exprType != null && exprType.equals(OFPType.voidType)) {
            System.err.println("Error: Cannot assign the result of a void function.");
            return OFPType.errorType;
        }

        if (varSymbol == null) {
            System.err.println("Error: Variable '" + varName + "' not declared.");
            return OFPType.errorType;
        }

        OFPType varType = varSymbol.getType();

        if ((varType.equals(OFPType.intArrType) || varType.equals(OFPType.floatArrType) || varType.equals(OFPType.charArrType)) && (exprType.equals(OFPType.intArrType) || exprType.equals(OFPType.floatArrType) || exprType.equals(OFPType.charArrType))) {
        
            // Check if array types match
            if (!varType.equals(exprType)) {
                System.err.println("Error: Type mismatch in array assignment. Expected '" + varType + "' but got '" + exprType + "'.");
                return OFPType.errorType;
            }
        }
        else if (!varType.equals(exprType)) {
            System.err.println("Error: Type mismatch in assignment. Expected '" + varType + "' but got '" + exprType + "'.");
            return OFPType.errorType;
        }

        return exprType;
    }

    @Override
    public OFPType visitArrayInit(ParserParser.ArrayInitContext ctx) {
        if (ctx.getChild(0).getText().equals("new")) {
            // Handle new TYPE[expr]
            OFPType arrayType = OFPType.getTypeFor(ctx.TYPE().getText());
            OFPType sizeType = visit(ctx.expr(0));

            // Ensure int
            if (!sizeType.equals(OFPType.intType)) {
                System.err.println("Error: Array size must be of type int.");
                return OFPType.errorType;
            }

            // Ensure array type
            if (!arrayType.equals(OFPType.intType) && !arrayType.equals(OFPType.floatType) && !arrayType.equals(OFPType.charType)) {
                System.err.println("Error: Invalid array type at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine() + "." );
                return OFPType.errorType;
            }

            return arrayType;
        } else {
            // Handle { expr, ... }
            OFPType firstExprType = visit(ctx.expr(0));

            for (int i = 1; i < ctx.expr().size(); i++) {
                OFPType elementType = visit(ctx.expr(i));
                if (!elementType.equals(firstExprType)) {
                    System.err.println("Error: All elements in the array must have the same type.");
                    return OFPType.errorType;
                }
            }

            // Determine array type based on elements
            if (firstExprType.equals(OFPType.intType)) {
                return OFPType.intArrType;
            } else if (firstExprType.equals(OFPType.floatType)) {
                return OFPType.floatArrType;
            } else if (firstExprType.equals(OFPType.charType)) {
                return OFPType.charArrType;
            } else {
                System.err.println("Error: Invalid element type in array initialization.");
                return OFPType.errorType;
            }
        }
    }

    @Override
    public OFPType visitArrayVar(ParserParser.ArrayVarContext ctx) {
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);

        if (varSymbol == null) {
            System.err.println("Error: Array '" + varName + "' not declared.");
            return OFPType.errorType;
        }

        OFPType varType = varSymbol.getType();
        if (!varType.equals(OFPType.intArrType) && !varType.equals(OFPType.floatArrType) && !varType.equals(OFPType.charArrType)) {
            System.err.println("Error: '" + varName + "' is not an array.");
            return OFPType.errorType;
        }

        OFPType indexType = visit(ctx.expr());
        if (!indexType.equals(OFPType.intType)) {
            System.err.println("Error: Array index must be of type int.");
            return OFPType.errorType;
        }

        if (varType.equals(OFPType.intArrType)) {
            return OFPType.intType;
        }

        if (varType.equals(OFPType.floatArrType)) {
            return OFPType.floatType;
        }
        
        if (varType.equals(OFPType.charArrType)) {
            return OFPType.charType;
        }

        return null;  // code should not reach this!
    }

    @Override
    public OFPType visitArrayAssign(ParserParser.ArrayAssignContext ctx) {
        OFPType indexType = visit(ctx.arrayVar().expr());  // Check the array index
        if (!indexType.equals(OFPType.intType)) {
            System.err.println("Error: Array index must be of type int.");
        }

        String varName = ctx.arrayVar().ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);
        if (varSymbol == null) {
            System.err.println("Error: Array '" + varName + "' not declared.");
            return OFPType.errorType;
        }

        OFPType arrayType = varSymbol.getType();
        OFPType exprType = visit(ctx.expr());  // Type of expression to assign

        if (arrayType.equals(OFPType.intArrType) && !exprType.equals(OFPType.intType)) {
            System.err.println("Error: Cannot assign non-int to int array.");
        } 
        else if (arrayType.equals(OFPType.floatArrType) && !exprType.equals(OFPType.floatType)) {
            System.err.println("Error: Cannot assign non-float to float array.");
        } 
        else if (arrayType.equals(OFPType.charArrType) && !exprType.equals(OFPType.charType)) {
            System.err.println("Error: Cannot assign non-char to char array.");
        }

        return null;
    }

    @Override
    public OFPType visitLengthExpr(ParserParser.LengthExprContext ctx) {
        OFPType exprType = visit(ctx.expr());

        if (exprType == null) {
            System.err.println("Error: Invalid expression type in length operation.");
            return OFPType.errorType;
        }

        // string or array type only
        if (!exprType.equals(OFPType.stringType) && !exprType.equals(OFPType.intArrType) && !exprType.equals(OFPType.floatArrType) && !exprType.equals(OFPType.charArrType)) {
            System.err.println("Error: Length can only be applied to strings or arrays.");
            return OFPType.errorType;
        }

        return OFPType.intType;  // Length is always an int
    }

    @Override
    public OFPType visitUnaryExpr(ParserParser.UnaryExprContext ctx) {
        OFPType exprType = visit(ctx.expr());
        if (!exprType.equals(OFPType.intType) && !exprType.equals(OFPType.floatType)) {
            System.err.println("Error: Unary minus can only be applied to int or float types.");
            return OFPType.errorType;
        }
        return exprType;
    }

    // may seem redundant but we dont want to print for example "void foo(){}" -> "print(foo());"
    @Override
    public OFPType visitPrintStmt(ParserParser.PrintStmtContext ctx) {
        if (ctx.expr() != null) {
            OFPType exprType = visit(ctx.expr());
            if (exprType == null) {
                System.err.println("Error: Invalid type in print statement.");
                return OFPType.errorType;
            }
        }
        return null;
    }

    public OFPType visitParenthesesExpr(ParserParser.ParenthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public OFPType visitAddSubExpr(ParserParser.AddSubExprContext ctx) {
        OFPType leftType = visit(ctx.expr(0));
        OFPType rightType = visit(ctx.expr(1));

        if (leftType.equals(OFPType.errorType) || rightType.equals(OFPType.errorType)) {
            System.err.println("Error: Invalid arithmetic expression.");
            return OFPType.errorType;
        }

        if (leftType.equals(OFPType.voidType) || rightType.equals(OFPType.voidType)) {
            System.err.println("Error: Cannot use a void function in an arithmetic expression.");
            return OFPType.errorType;
        }

        if (!leftType.equals(rightType)) {
            System.err.println("Error: Type mismatch in expression. Both sides must have the same type.");
            return OFPType.errorType;
        }

        if (!leftType.equals(OFPType.intType) && !leftType.equals(OFPType.floatType)) {
            System.err.println("Error: Addition and subtraction are only allowed for int or float types.");
            return OFPType.errorType;
        }

        return leftType;
    }

    @Override
    public OFPType visitMultExpr(ParserParser.MultExprContext ctx) {
        OFPType leftType = visit(ctx.expr(0));
        OFPType rightType = visit(ctx.expr(1));

        if (leftType.equals(OFPType.errorType) || rightType.equals(OFPType.errorType)) {
            System.err.println("Error: Invalid multiplication/division expression.");
            return OFPType.errorType;
        }

        if (leftType.equals(OFPType.voidType) || rightType.equals(OFPType.voidType)) {
            System.err.println("Error: Cannot use a void function in a multiplication/division expression.");
            return OFPType.errorType;
        }
        
        if (!leftType.equals(rightType)) {
            System.err.println("Error: Type mismatch in expression. Both sides must have the same type.");
            return OFPType.errorType;
        }

        if (!leftType.equals(OFPType.intType) && !leftType.equals(OFPType.floatType) || !rightType.equals(OFPType.intType) && !rightType.equals(OFPType.floatType)) {
            System.err.println("Error: Multiplication is only allowed for int or float types.");
            return OFPType.errorType;
        }

        return leftType;
    }


    @Override
    public OFPType visitComparisonExpr(ParserParser.ComparisonExprContext ctx) {
        OFPType leftType = visit(ctx.expr(0));
        OFPType rightType = visit(ctx.expr(1));

        if (leftType.equals(OFPType.errorType) || rightType.equals(OFPType.errorType)) {
            System.err.println("Error: Invalid comparison expression.");
            return OFPType.errorType;
        }

        if (!leftType.equals(rightType)) {
            if(leftType.equals(OFPType.intArrType) || leftType.equals(OFPType.floatArrType) || leftType.equals(OFPType.charArrType) || leftType.equals(OFPType.stringType) || rightType.equals(OFPType.intArrType) || rightType.equals(OFPType.floatArrType) || rightType.equals(OFPType.charArrType) || rightType.equals(OFPType.stringType)){
                if (!(ctx.getParent() instanceof ParserParser.LengthExprContext)) {
                    System.err.println("Error: Type mismatch in comparison. Both sides must have the same type.");
                    return OFPType.errorType;
                }
            }
        }

        if (!leftType.equals(OFPType.intType) && !leftType.equals(OFPType.floatType) && !leftType.equals(OFPType.charType)) {
            if (leftType.equals(OFPType.stringType)) {
                if (ctx.getChild(1).getText().equals(">") || ctx.getChild(1).getText().equals("<")) {
                    System.err.println("Error: Cannot use '>' or '<' with string type.");
                    return OFPType.errorType;
                }
            } else {
                System.err.println("Error: Comparison operators can only be used with int, float, or char types.");
                return OFPType.errorType;
            }
        }

        return OFPType.boolType;
    }

    @Override
    public OFPType visitIfStmt(ParserParser.IfStmtContext ctx) {
        OFPType conditionType = visit(ctx.expr());
        if (!conditionType.equals(OFPType.boolType)) {
            System.err.println("Error: Condition in if-statement must be of type bool.");
            return OFPType.errorType;
        }
        return super.visitIfStmt(ctx);
    }

    @Override
    public OFPType visitWhileStmt(ParserParser.WhileStmtContext ctx) {
        OFPType conditionType = visit(ctx.expr());
        if (!conditionType.equals(OFPType.boolType)) {
            System.err.println("Error: Condition in while-statement must be of type bool.");
            return OFPType.errorType;
        }
        return super.visitWhileStmt(ctx);
    }


}
