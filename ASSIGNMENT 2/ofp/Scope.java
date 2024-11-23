package ofp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Scope {
    private Scope enclosingScope; // null if global (outermost) scope
    private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
    private List<Scope> childScopes = new ArrayList<>();

    private FunctionSymbol functionSymbol;

    public Scope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    public Scope getEnclosingScope() { 
        return enclosingScope;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void addChildScope(Scope child) {
        childScopes.add(child);
    }

    public List<Scope> getChildScopes() {
        return childScopes;
    }

    public void setFunctionSymbol(FunctionSymbol functionSymbol) {
        this.functionSymbol = functionSymbol;
    }

    public FunctionSymbol getFunctionSymbol() {
        return this.functionSymbol;
    }

    public void define(Symbol sym) { 
        if (symbols.containsKey(sym.getName())) {
            return;
        }
        symbols.put(sym.getName(), sym); 
    }

    // If a name cannot be resolved in this scope,
    // try enclosing/parent scope recursively.
    // If null is returned, name/identifier not found in the symbol table!
    public Symbol resolve(String name) {  
        Symbol sym = symbols.get(name);
        
        if (sym != null) {
            return sym;
        }

        if (enclosingScope != null) {
            return enclosingScope.resolve(name);
            
        }

        return null;
    }

    public Symbol localResolve(String name) {  
        Symbol sym = symbols.get(name);
        
        if (sym != null) {
            return sym;
        }

        return null;
    }

    // Print the contents of this scope
    @Override
    public String toString() {
        return symbols.keySet().toString();
    }
}