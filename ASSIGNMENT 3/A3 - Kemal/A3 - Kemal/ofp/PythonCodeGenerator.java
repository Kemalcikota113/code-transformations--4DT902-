package ofp;

import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import generated.ParserBaseVisitor;
import generated.ParserParser;

public class PythonCodeGenerator extends ParserBaseVisitor<String> {
    private int depth = 0;
    private ParseTreeProperty<Scope> scopes;
    private Scope currentScope;

    // Reserved Python identifiers, if a variable takes tis name, it will be called for example ofp_False etc etc.
    private static HashSet<String> reservedIds = new HashSet<String>(Arrays.asList("False", "None", "True", "and", "as", "assert", "async", "await", "break", "class", "continue", "def", "del", "elif", "else", "except", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "nonlocal", "not", "or", "pass", "raise", "return", "try", "while", "with", "yield", "ArithmeticError", "AssertionError", "AttributeError", "BaseException", "BlockingIOError", "BrokenPipeError", "BufferError", "BytesWarning", "ChildProcessError", "ConnectionAbortedError", "ConnectionError", "ConnectionRefusedError", "ConnectionResetError", "DeprecationWarning", "EOFError", "Ellipsis", "EnvironmentError", "Exception", "False", "FileExistsError", "FileNotFoundError", "FloatingPointError", "FutureWarning", "GeneratorExit", "IOError", "ImportError", "ImportWarning", "IndentationError", "IndexError", "InterruptedError", "IsADirectoryError", "KeyError", "KeyboardInterrupt", "LookupError", "MemoryError", "NameError", "None", "NotADirectoryError", "NotImplemented", "NotImplementedError", "OSError", "OverflowError", "PendingDeprecationWarning", "PermissionError", "ProcessLookupError", "RecursionError", "ReferenceError", "ResourceWarning", "RuntimeError", "RuntimeWarning", "StopAsyncIteration", "StopIteration", "SyntaxError", "SyntaxWarning", "SystemError", "SystemExit", "TabError", "TimeoutError", "True", "TypeError", "UnboundLocalError", "UnicodeDecodeError", "UnicodeEncodeError", "UnicodeError", "UnicodeTranslateError", "UnicodeWarning", "UserWarning", "ValueError", "Warning", "ZeroDivisionError", "__build_class__", "__debug__", "__doc__", "__import__", "__loader__", "__name__", "__package__", "__spec__", "abs", "all", "any", "ascii", "bin", "bool", "bytearray", "bytes", "callable", "chr", "classmethod", "compile", "complex", "copyright", "credits", "delattr", "dict", "dir", "divmod", "enumerate", "eval", "exec", "exit", "filter", "float", "format", "frozenset", "getattr", "globals", "hasattr", "hash", "help", "hex", "id", "input", "int", "isinstance", "issubclass", "iter", "len", "license", "list", "locals", "map", "max", "memoryview", "min", "next", "object", "oct", "open", "ord", "pow", "print", "property", "quit", "range", "repr", "reversed", "round", "set", "setattr", "slice", "sorted", "staticmethod", "str", "sum", "super", "tuple", "type", "vars", "zip")); 


    // Get indentation for the current depth
    private String indent() {
       return " ".repeat(depth * 2);
    }
 
    // Generate safe Python identifiers to avoid clashes with reserved words
    private static String getSafeId(String id) {
       if (reservedIds.contains(id)) {
          return "ofp_" + id;  // Prefix with ofp_
       }
       return id;
    }
 
    public PythonCodeGenerator(ParseTreeProperty<Scope> scopes) {
       this.scopes = scopes;
    }

    // generella ID, INT, BOOL och andra datatyper, returnerar bara python versionen av hur dem ska se ut
    @Override
    public String visitIdExpr(ParserParser.IdExprContext ctx) {
        return getSafeId(ctx.ID().getText());
    }
    
    @Override
    public String visitIntExpr(ParserParser.IntExprContext ctx) {
        return ctx.INT().getText();
    }

    @Override
    public String visitFloatExpr(ParserParser.FloatExprContext ctx) {
        return ctx.FLOAT().getText();
    }

    @Override
    public String visitBoolExpr(ParserParser.BoolExprContext ctx) {
        if ("true".equals(ctx.BOOL().getText())) {
            return "True";
        } else {
            return "False";
        } 
    }

    @Override
    public String visitCharExpr(ParserParser.CharExprContext ctx) {
        return ctx.CHAR().getText();
    }

    @Override
    public String visitStringExpr(ParserParser.StringExprContext ctx) {
        return ctx.STRING().getText();
    }

    // globala koden, (yttersta scope)
    @Override
    public String visitProg(ParserParser.ProgContext ctx) {
        StringBuilder progStmt = new StringBuilder();

        // alla funktioner först
        for (int i = 0; i < ctx.functionDecl().size(); i++) {
            progStmt.append(visit(ctx.functionDecl(i)));
        }

        // sista main programmet så det blir inline
        if (ctx.main() != null) {
            progStmt.append(visit(ctx.main()));
        }

        return progStmt.toString();
    }

    // Visit main program entry point. tis piece of code in pyton will always be inline and on te bottom
    @Override
    public String visitMain(ParserParser.MainContext ctx) {
        StringBuilder mainStmt = new StringBuilder();

        mainStmt.append("#\n# Program entry point - main\n#\n");
        
        int previousDepth = depth;
        depth = -1;

        mainStmt.append(visit(ctx.block()));

        depth = previousDepth;

        return mainStmt.toString();
    }

    // vanlig funktions deklaration (inte main) i ofp -> TYPE ID '(' (TYPE ID ( ',' TYPE ID )* )? ')' block
    //                                       i python -> def ID '(' (ID ( ',' ID )* )? ')' ':' kod 
    @Override
    public String visitFunctionDecl(ParserParser.FunctionDeclContext ctx) {
        StringBuilder functionDeclStmt = new StringBuilder();

        // Get the function name and make it safe for Python
        String functionName = getSafeId(ctx.ID(0).getText());

        // Retrieve the function symbol from the scope
        currentScope = scopes.get(ctx);
        FunctionSymbol functionSymbol = (FunctionSymbol) currentScope.resolve(ctx.ID(0).getText());

        // Start the function declaration: def functionName(params):
        // line in 21 in parser.g4
        functionDeclStmt.append(indent())
                    .append("def ")
                    .append(functionName)
                    .append("(");

        // Add function parameters from the FunctionSymbol
        List<Symbol> params = functionSymbol.getParameters();
        for (int i = 0; i < params.size(); i++) {
            String paramName = getSafeId(params.get(i).getName());
            functionDeclStmt.append(paramName);
            if (i < params.size() - 1) {
                functionDeclStmt.append(", ");
            }
        }

        functionDeclStmt.append("):\n");

        // Visit the function body (the block of statements)
        functionDeclStmt.append(visit(ctx.block()));

        functionDeclStmt.append("\n");

        return functionDeclStmt.toString();
    }

    // function(a, b, c)
    // this ctx has access to the whole ofp functionCall statement
    @Override
    public String visitFunctionCall(ParserParser.FunctionCallContext ctx) {
        StringBuilder functionCallStmt = new StringBuilder();
        
        // Get the function name and make it safe for Python
        String functionName = getSafeId(ctx.ID().getText());

        // Start the function call: functionName(arguments)
        functionCallStmt.append(functionName).append("(");

        // Visit the arguments
        for (int i = 0; i < ctx.expr().size(); i++) {
            functionCallStmt.append(visit(ctx.expr(i)));
            if (i < ctx.expr().size() - 1) {
                functionCallStmt.append(", ");
            }
        }

        functionCallStmt.append(")");

        return functionCallStmt.toString();
    }

    // this is called when ofp encounters a functioncall, but ctx dies not have access to the whole functionCall statement
    @Override
    public String visitFunctionCallStmt(ParserParser.FunctionCallStmtContext ctx) {
        return indent() + visit(ctx.functionCall()) + "\n";
    }

    // Visit return statement
    @Override
    public String visitReturnStmt(ParserParser.ReturnStmtContext ctx) {
        StringBuilder returnStmt = new StringBuilder();

        returnStmt.append(indent()).append("return ");
        returnStmt.append(visit(ctx.expr()));
        returnStmt.append("\n");

        return returnStmt.toString();
    }

    // Visit block of statements
    @Override
    public String visitBlock(ParserParser.BlockContext ctx) {
        StringBuilder blockStmt = new StringBuilder();

        // add depth, visit code, then remove depth.
        // works for all blocks
        depth++;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String stmt = visit(ctx.getChild(i));
            if (stmt != null && !stmt.isEmpty()) {
                blockStmt.append(indent()).append(stmt);
            }
        }
        depth--;

        return blockStmt.toString();
    }

    // Visit declarations, for example int a = 5;
    // line 25 in parser.g4
    @Override
    public String visitDecl(ParserParser.DeclContext ctx) {
        String varName = getSafeId(ctx.ID().getText()); // vänsterled
        String expr = ctx.expr() != null ? visit(ctx.expr()) : "None"; // högerled

        // indent + (TYPE + vänsterled) + = + högerled + newline
        return indent() + varName + " = " + expr + "\n";
    }

    // Visit assignment, for example a = 5;
    //line 31 in parser.g4
    @Override
    public String visitAssign(ParserParser.AssignContext ctx) {
        String varName = getSafeId(ctx.ID().getText());
        String expr = visit(ctx.expr());

        return indent() + varName + " = " + expr + "\n";
    }

    // Visit array initialization, for example int[] a = new int[5];
    @Override
    public String visitArrayInit(ParserParser.ArrayInitContext ctx) {
        StringBuilder arrayInit = new StringBuilder();

        // if ofp: int[] f = new int[10]; -> python: f = [0]*size 
        if ("new".equals(ctx.getChild(0).getText())) {
            String size = visit(ctx.expr(0));
            arrayInit.append("[0]*").append(size);
        }
        else {
            // else ofp: float[] f = {9.3,8.8,17.5,1.0,2.1,3.2, 4.4}; -> python: f = [9.3, 8.8, 17.5, 1.0, 2.1, 3.2, 4.4] 
            arrayInit.append("[");
            for (int i = 0; i < ctx.expr().size(); i++) {
                if (i > 0) {
                    arrayInit.append(", ");
                }
                arrayInit.append(visit(ctx.expr(i)));
            }
            arrayInit.append("]");
        }

        return arrayInit.toString();
    }

    // Visit array declaration, for example int[] a;
    @Override
    public String visitArrayVar(ParserParser.ArrayVarContext ctx) {
        StringBuilder arrayAccessStmt = new StringBuilder();

        String arrayName = getSafeId(ctx.ID().getText());

        arrayAccessStmt.append(arrayName)
                       .append("[")
                       .append(visit(ctx.expr()))
                       .append("]");

        // f[expr?]

        return arrayAccessStmt.toString();
    }

    // Visit array access, for example a[0] = 5;
    // line 33  in parser.g4
    @Override
    public String visitArrayAssign(ParserParser.ArrayAssignContext ctx) {
        StringBuilder arrayAssignStmt = new StringBuilder();

        String arrayVarStmt = visit(ctx.arrayVar());

        String valueExpr = visit(ctx.expr());

        arrayAssignStmt.append(indent())
                       .append(arrayVarStmt)
                       .append(" = ")
                       .append(valueExpr)
                       .append("\n");

        return arrayAssignStmt.toString();
    }

    // visit .length expression, for example a.length; will be translated to len(a)
    @Override
    public String visitLengthExpr(ParserParser.LengthExprContext ctx) {
        StringBuilder lengthExpr = new StringBuilder();

        String expr = visit(ctx.expr());

        lengthExpr.append("len(")
                  .append(expr)
                  .append(")");

        return lengthExpr.toString();
    }

    // Visit unary expression, for example -5;
    @Override
    public String visitUnaryExpr(ParserParser.UnaryExprContext ctx) {
        StringBuilder unaryExpr = new StringBuilder();

        unaryExpr.append("-");

        unaryExpr.append(visit(ctx.expr()));

        return unaryExpr.toString();
    }

    // Visit print statement, for example print(5);
    // needs two different implementations for print and println
    @Override
    public String visitPrintStmt(ParserParser.PrintStmtContext ctx) {
        StringBuilder printStmt = new StringBuilder();

        // print will not add a newline at the end. tis is te same as print(, end="") in pyton
        if ("print".equals(ctx.getChild(0).getText())) {
            printStmt.append(indent()).append("print(");

            if (ctx.expr() != null) {
                printStmt.append(visit(ctx.expr()));
            }

            printStmt.append(", end='')");
        } 
        // println will add a newline at te end. tis is te same as print() in python
        else if ("println".equals(ctx.getChild(0).getText())) {
            printStmt.append(indent()).append("print(");

            if (ctx.expr() != null) {
                printStmt.append(visit(ctx.expr()));
            }

            printStmt.append(")");
        }

        printStmt.append("\n");

        return printStmt.toString();
    }
    
    // Visit parentheses expression, for example (5+5);
    public String visitParenthesesExpr(ParserParser.ParenthesesExprContext ctx) {
        StringBuilder parenthesesExpr = new StringBuilder();

        parenthesesExpr.append("(")
                       .append(visit(ctx.expr()))
                       .append(")");

        return parenthesesExpr.toString();
    }

    // Visit add/sub expression, for example 5+5;
    @Override
    public String visitAddSubExpr(ParserParser.AddSubExprContext ctx) {
        StringBuilder addSubExpr = new StringBuilder();

        addSubExpr.append(visit(ctx.expr(0)))
                  .append(" ")
                  .append(ctx.getChild(1).getText())
                  .append(" ")
                  .append(visit(ctx.expr(1)));

        return addSubExpr.toString();
    }

    // Visit mult expression, for example 5*5;
    @Override
    public String visitMultExpr(ParserParser.MultExprContext ctx) {
        StringBuilder multExpr = new StringBuilder();

        multExpr.append(visit(ctx.expr(0)))
                .append(ctx.getChild(1).getText())
                .append(visit(ctx.expr(1)));

        return multExpr.toString();
    }
    
    // Visit comparison expression, for example 5<5;
    @Override
    public String visitComparisonExpr(ParserParser.ComparisonExprContext ctx) {
        StringBuilder comparisonExpr = new StringBuilder();

        comparisonExpr.append(visit(ctx.expr(0)))
                      .append(" ")
                      .append(ctx.getChild(1).getText())
                      .append(" ")
                      .append(visit(ctx.expr(1)));

        return comparisonExpr.toString();
    }


    @Override
    public String visitIfStmt(ParserParser.IfStmtContext ctx) {
        StringBuilder ifStmt = new StringBuilder();

        ifStmt.append(indent())
              .append("if ")
              .append(visit(ctx.expr()))
              .append(":\n");

        ifStmt.append(visit(ctx.block(0)));

        if (ctx.block(1) != null) {
            if (ctx.block(1).getChild(0) instanceof ParserParser.IfStmtContext) {
                ParserParser.IfStmtContext elif = (ParserParser.IfStmtContext) ctx.block(1).stmt(0);
                
                depth*=2; // weird way to increase depth, but it works.
                ifStmt.append(indent()).append("elif ");
                depth/=2;

                ifStmt.append(visit(elif.expr()))
                      .append(":\n")
                      .append(visit(elif.block(0)));

                if (elif.block(1) != null) {
                    depth*=2;
                    ifStmt.append(indent()).append("else:\n");
                    depth/=2;
                    ifStmt.append(visit(elif.block(1)));
                }

            } 
            // double check if it is an else statement
            else {
                depth*=2;
                ifStmt.append(indent()).append("else:\n");
                depth/=2;
                ifStmt.append(visit(ctx.block(1)));
                
            }
        }

        return ifStmt.toString();
    }

    // while (x>0) {content}  --> while x>0: content
    @Override
    public String visitWhileStmt(ParserParser.WhileStmtContext ctx) {
        StringBuilder whileStmt = new StringBuilder();

        whileStmt.append(indent())
                 .append("while ")
                 .append(visit(ctx.expr()))
                 .append(":\n");

        whileStmt.append(visit(ctx.block()));

        return whileStmt.toString();
    }

}
