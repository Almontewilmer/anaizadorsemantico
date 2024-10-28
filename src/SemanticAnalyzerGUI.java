import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemanticAnalyzerGUI extends JFrame {
    private SemanticAnalyzer analyzer = new SemanticAnalyzer();

    private JTextField variableNameField = new JTextField(10);
    private JTextField variableTypeField = new JTextField(10);
    private JTextField assignVarField = new JTextField(10);
    private JTextField assignTypeField = new JTextField(10);

    private JTextArea outputArea = new JTextArea(8, 30);

    public SemanticAnalyzerGUI() {
        setTitle("Analizador Semántico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Panel para declarar variables
        JPanel declarePanel = new JPanel();
        declarePanel.add(new JLabel("Variable:"));
        declarePanel.add(variableNameField);
        declarePanel.add(new JLabel("Tipo:"));
        declarePanel.add(variableTypeField);
        JButton declareButton = new JButton("Declarar");
        declarePanel.add(declareButton);

        // Panel para asignar valores
        JPanel assignPanel = new JPanel();
        assignPanel.add(new JLabel("Asignar a:"));
        assignPanel.add(assignVarField);
        assignPanel.add(new JLabel("Tipo de expresión:"));
        assignPanel.add(assignTypeField);
        JButton assignButton = new JButton("Asignar");
        assignPanel.add(assignButton);

        // Área de salida
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Eventos de los botones
        declareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String varName = variableNameField.getText();
                    String varType = variableTypeField.getText();
                    analyzer.declareVariable(varName, varType);
                    outputArea.append("Variable '" + varName + "' de tipo '" + varType + "' declarada.\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String varName = assignVarField.getText();
                    String exprType = assignTypeField.getText();
                    analyzer.analyzeAssignment(varName, exprType);
                    outputArea.append("Asignación válida para '" + varName + "'.\n");
                } catch (Exception ex) {
                    outputArea.append("Error: " + ex.getMessage() + "\n");
                }
            }
        });

        // Agregar componentes al JFrame
        add(declarePanel);
        add(assignPanel);
        add(scrollPane);
    }
}
