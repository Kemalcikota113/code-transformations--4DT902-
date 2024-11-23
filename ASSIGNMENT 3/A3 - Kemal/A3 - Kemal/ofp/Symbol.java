package ofp;

public class Symbol {
    String name;
    OFPType type;

    public Symbol(String name, OFPType type) { 
        this.name = name;
        this.type = type;
    }

    public String getName() {  
        return name;
    }

    public OFPType getType() {  
        return type;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" + "type: " + type;
    }

}

