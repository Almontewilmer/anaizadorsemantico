import java.util.HashMap;

public class SymbolTable {
    private HashMap<String, String> symbols = new HashMap<>();

    public void addVariable(String name, String type) throws Exception {
        if (symbols.containsKey(name)) {
            throw new Exception("La variable '" + name + "' ya está declarada.");
        }
        symbols.put(name, type);
    }

    public String getType(String name) throws Exception {
        if (!symbols.containsKey(name)) {
            throw new Exception("La variable '" + name + "' no está declarada.");
        }
        return symbols.get(name);
    }
}
