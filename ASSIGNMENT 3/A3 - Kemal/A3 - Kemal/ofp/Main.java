package ofp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import org.antlr.v4.gui.Trees;

import generated.ParserLexer;
import generated.ParserParser;
 
public class Main  {
    public static void main(String[] args)  {

        String testDir = "C:/Users/kemal/Downloads/A3 - Kemal/A3 - Kemal/OFPFiles/";
        String testProgram = testDir + "strings.ofp";
        
        // Check if input ends with ".ofp"
        if ( !testProgram.endsWith(".ofp") ) {
            System.out.println("\nPrograms most end with suffix .ofp! Found "+testProgram);
            System.exit(-1);
        }
        System.out.println("Reading test program from: "+testProgram);
        
        // Parse input program
        System.out.println("\nParsing started");
        ParserParser parser = null;
        ParserParser.ProgContext root = null;
        try {
            CharStream inputStream = CharStreams.fromFileName(testProgram);
            ParserLexer lexer = new ParserLexer( inputStream );		
            parser = new ParserParser(new BufferedTokenStream(lexer));	
            root = parser.prog();
        } catch (IOException e) {				
            e.printStackTrace();
        } 
        System.out.println("\nParsing completed");
        
        // // Display tree
        // Trees.inspect(root, parser);

        // Indented tree print using a custom listener
        // ParseTreeWalker walker0 = new ParseTreeWalker();
        // PrintListener printListener = new PrintListener(); // PrintListener implementswalker.walk(printListener, root); // BaseListener
        // walker0.walk(printListener, root);

        //Symbol table construction using a listener ... (This lecture)
        ParseTreeWalker walker = new ParseTreeWalker();
        STListener stListener = new STListener();
        walker.walk(stListener, root);

        // optional
        stListener.printSymbolTable();

        ParseTreeProperty<Scope> scopes = stListener.getScope();
        
        //Symbol reference checking using a listener ... (This lecture)
        IDListener idListener = new IDListener(scopes, stListener.getGlobalScope());
        walker.walk(idListener, root);

        idListener.reportErrors();

        //Type checking using a visitor ... (Next lecture)
        TCVisitor tcVisitor = new TCVisitor(scopes);
        tcVisitor.visit(root);

        // Python
        System.out.println("\nGenerating Python code...");
        
        String baseFileName = testProgram.substring(testProgram.lastIndexOf('/') + 1, testProgram.lastIndexOf('.'));
        String outputPythonFile = testDir + baseFileName + ".py";

        PythonCodeGenerator pythonCodeGenerator = new PythonCodeGenerator(scopes);
        String generatedPythonCode = pythonCodeGenerator.visit(root);

        try {
            Files.write(Paths.get(outputPythonFile), generatedPythonCode.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Python code generated and written to: " + outputPythonFile);
        } catch (IOException e) {
            System.err.println("Error writing Python code to file: " + e.getMessage());
        }

    }
}