package ofp;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import generated.ParserBaseListener;
import generated.ParserParser;

public class STListener extends ParserBaseListener {
    private Scope globalScope;
	private Scope currentScope;
	private FunctionSymbol currentFunctionSymbol = null;
	private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

	@Override 
	public void enterProg(ParserParser.ProgContext ctx) { 
		// Initialize global scope
        globalScope = new Scope(null); // Global scope has no enclosing scope
		currentScope = globalScope;
        scopes.put(ctx, globalScope);
	}

	@Override 
	public void enterMain(ParserParser.MainContext ctx) { 
		Symbol existingMain = globalScope.resolve("main");
		if (existingMain != null && existingMain instanceof FunctionSymbol) {
			System.err.println("Error: 'main' function is already declared in the global scope.");
			return;
		}

		currentFunctionSymbol = new FunctionSymbol("main", OFPType.voidType);
		globalScope.define(currentFunctionSymbol);

		currentScope = new Scope(globalScope); // Enclosed by the global scope
		globalScope.addChildScope(currentScope);
        scopes.put(ctx, currentScope);
	}

	@Override public void exitMain(ParserParser.MainContext ctx) { 
		currentScope = globalScope;
		currentFunctionSymbol = null;
	}

	@Override 
	public void enterFunctionDecl(ParserParser.FunctionDeclContext ctx) { 
		// function name and return type
        String functionName = ctx.ID(0).getText();
        String returnTypeStr = ctx.getChild(0).getText();
    	OFPType returnType = OFPType.getTypeFor(returnTypeStr);

		// checking if it's a misdeclared variable or function in the globalScope
		if (!(ctx.getChild(ctx.getChildCount() - 1) instanceof ParserParser.BlockContext)) {
			System.err.println("Error: Invalid function declaration for '" + functionName + "'. Expected a function body enclosed in '{ }'.");
			return;
		}

		Symbol existingSymbol = currentScope.resolve(functionName);
		if(existingSymbol instanceof FunctionSymbol) {
			System.err.println("Error: Function '" + functionName + "' is already declared within this scope.");
			return;
		}

        // new function symbol
        currentFunctionSymbol = new FunctionSymbol(functionName, returnType);

		currentScope.define(currentFunctionSymbol);
	
		// new scope for function body
        Scope functionScope = new Scope(currentScope); // Enclosed by current

		functionScope.setFunctionSymbol(currentFunctionSymbol);

		currentScope.addChildScope(functionScope);

		currentScope = functionScope;

		if(returnType.equals(OFPType.voidType)) {
			// function parameters to the function symbol
			if (ctx.TYPE().size() > 0) { // If parameters exist
				for (int i = 0; i < ctx.TYPE().size(); i++) {
					String paramTypeStr = ctx.TYPE(i).getText();					// get the string representation of the type
					String paramName = ctx.ID(i + 1).getText();						// get the string representation of the name
					OFPType paramType = OFPType.getTypeFor(paramTypeStr);			// get the OFPTyple from the string rep of the type
					Symbol paramSymbol = new Symbol(paramName, paramType);			// create a new symbol rep of the variable name and type
	
	
					Symbol existingParam = currentScope.localResolve(paramName);
					if (existingParam != null && !(existingSymbol instanceof FunctionSymbol)) {
						System.err.println("Error: Parameter '" + paramName + "' is already declared in function '" + functionName + "'.");
						return;
					}
	
					currentScope.define(paramSymbol);
					currentFunctionSymbol.addParameter(paramSymbol);		// add the parameter to the current FunctionSymbol list
				}
			}
		}
		else {
			// function parameters to the function symbol
			if (ctx.TYPE().size() > 1) { // If parameters exist
				for (int i = 1; i < ctx.TYPE().size(); i++) {
					String paramTypeStr = ctx.TYPE(i).getText();					// get the string representation of the type 
					String paramName = ctx.ID(i).getText();							// get the string representation of the name
					OFPType paramType = OFPType.getTypeFor(paramTypeStr);			// get the OFPTyple from the string rep of the type
					Symbol paramSymbol = new Symbol(paramName, paramType);			// create a new symbol rep of the variable name and type
	
	
					Symbol existingParam = currentScope.localResolve(paramName);
					if (existingParam != null && !(existingSymbol instanceof FunctionSymbol)) {
						System.err.println("Error: Parameter '" + paramName + "' is already declared in function '" + functionName + "'.");
						return;
					}
	
					currentScope.define(paramSymbol);
					currentFunctionSymbol.addParameter(paramSymbol);		// add the parameter to the current FunctionSymbol list
				}
			}
		}
		
        scopes.put(ctx, currentScope);
	}

	@Override 
	public void exitFunctionDecl(ParserParser.FunctionDeclContext ctx) {
        // currentScope = currentScope.getEnclosingScope();
		currentScope = globalScope;
        currentFunctionSymbol = null;
	}

	@Override 
	public void enterDecl(ParserParser.DeclContext ctx) { 
		String varName = ctx.ID().getText();
		OFPType varType = OFPType.getTypeFor(ctx.TYPE().getText());
		
		Symbol existingSymbol = currentScope.localResolve(varName);
		if(existingSymbol != null && !(existingSymbol instanceof FunctionSymbol)){
			System.err.println("Error: Variable '" + varName + "' is already declared within this scope.");
			return;
		}
		
		Symbol varSymbol = new Symbol(varName, varType);

		currentScope.define(varSymbol);
	}

	@Override 
	public void enterBlock(ParserParser.BlockContext ctx) { 
		Scope blockScope = new Scope(currentScope); // Enclosed by the current scope

		if (currentScope.getFunctionSymbol() != null) {		// adding the functionSymbol to the next block (if-stmt or while-stmt) to properly handle return-stmt in a nested block
			blockScope.setFunctionSymbol(currentScope.getFunctionSymbol());
		}

		currentScope.addChildScope(blockScope);
		currentScope = blockScope;
        scopes.put(ctx, blockScope);
	}

	@Override 
	public void exitBlock(ParserParser.BlockContext ctx) { 
		if(currentScope != globalScope){
			currentScope = currentScope.getEnclosingScope();
		}
	}

	@Override
	public void enterReturnStmt(ParserParser.ReturnStmtContext ctx) {
		if (currentFunctionSymbol != null) {
			scopes.put(ctx, currentScope);
		}
	}

	public ParseTreeProperty<Scope> getScope() {
		return scopes;
	}

	public Scope getGlobalScope() {
		return globalScope;
	}

	public void printSymbolTable() {
		System.out.println("===== Symbol Table =====");
		printScope(globalScope, 0);
	}

	private void printScope(Scope scope, int indentLevel) {
		String indent = "  ".repeat(indentLevel); 
		System.out.println(indent + "Scope: " + scope);

		for (Symbol symbol : scope.getSymbols().values()) {
			System.out.println(indent + "  Symbol: " + symbol.getName() + " (Type: " + symbol.getType() + ")");
		}

		for (Scope childScope : scope.getChildScopes()) {
			printScope(childScope, indentLevel + 1);
		}
	}

	
}
