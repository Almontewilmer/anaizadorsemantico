public class SemanticAnalyzer {
    private SymbolTable symbolTable = new SymbolTable();

    public void declareVariable(String name, String type) throws Exception {
        symbolTable.addVariable(name, type);
    }

    public void analyzeAssignment(String varName, String expressionType) throws Exception {
        String declaredType = symbolTable.getType(varName);
        if (!declaredType.equals(expressionType)) {
            throw new Exception("Error: Se esperaba '" + declaredType + "' pero se encontró '" + expressionType + "'.");
        }
    }
}
