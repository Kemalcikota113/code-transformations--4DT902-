package ofp;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import generated.ParserBaseListener;
import generated.ParserParser;

public class IDListener extends ParserBaseListener {
    private ParseTreeProperty<Scope> scopes;
    private Scope currentScope;
    private Scope globalScope;
    private int IDErrorCount = 0;  // count semantic errors

    public IDListener(ParseTreeProperty<Scope> scopes, Scope globalScope) {
        this.scopes = scopes;
        this.globalScope = globalScope;
    }

    // entering new scope (block, function, etc.)
    @Override
    public void enterBlock(ParserParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);  // Update currentScope
    }

    // exiting scope
    @Override
    public void exitBlock(ParserParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();  // back to enclosing scope
    }

    // identifier usage check (for variables)
    @Override
    public void enterIdExpr(ParserParser.IdExprContext ctx) {
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);
        
        if (varSymbol == null) {
            System.err.println("Error: Variable '" + varName + "' is not declared in this scope at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine() + ".");
            IDErrorCount++;
        }
    }

    // function calls
    @Override
    public void enterFunctionCall(ParserParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        Symbol functionSymbol = currentScope.resolve(functionName);
        
        if (functionSymbol == null || !(functionSymbol instanceof FunctionSymbol)) {
            System.err.println("Error: Function '" + functionName + "' is not declared.");
            IDErrorCount++;
        } else {
            // number of arguments
            FunctionSymbol funcSym = (FunctionSymbol) functionSymbol;
            if (ctx.expr().size() != funcSym.getParameters().size()) {
                System.err.println("Error: Function '" + functionName + "' expects " + funcSym.getParameters().size() + " arguments but " + ctx.expr().size() + " were provided.");
                IDErrorCount++;
            }
        }
    }

    // assignments (variable existence check, no assignment in global scope)
    @Override 
    public void enterAssign(ParserParser.AssignContext ctx) { 
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);

        if (varSymbol == null) {
            System.err.println("Error: Variable '" + varName + "' is not declared in this scope at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine() + ".");
            IDErrorCount++;
        } else {
            if (currentScope == globalScope) { // assignments in global scope
                System.err.println("Error: Assignment to variable '" + varName + "' is not allowed in the global scope.");
                IDErrorCount++;
            } else {
                //System.out.println("Assignment to variable '" + varSymbol + "' in Scope: " + currentScope);
            }
        }
    }

    // Handle array variable assignment
    @Override 
    public void enterArrayVar(ParserParser.ArrayVarContext ctx) {
        String varName = ctx.ID().getText();
        Symbol varSymbol = currentScope.resolve(varName);

        if (varSymbol == null) {
            System.err.println("Error: Variable '" + varName + "' is not declared in this scope at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine() + ".");
            IDErrorCount++;
        } else {
            //System.out.println("Array variable assignment to '" + varSymbol + "' in Scope: " + currentScope);
        }
    }

    public void reportErrors() {
        System.out.println("Semantic analysis completed with " + IDErrorCount + " errors.\n");
    }
}
