import javax.swing.*;
import java.awt.*;

public class CalculatorApp extends CalculatorSettings {
    private JTextField firstField;
    private JTextField secondField;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    public CalculatorApp() {
    super();

    setTitle("Calculator");
    setSize(450, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    firstField = new JTextField();
    secondField = new JTextField();

    resultLabel = new JLabel("Result: ");

    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");

    firstField.setFont(uiFont);
    secondField.setFont(uiFont);
    resultLabel.setFont(uiFont);

    addButton.setFont(uiFont);
    subButton.setFont(uiFont);
    mulButton.setFont(uiFont);
    divButton.setFont(uiFont);

    mainPanel.add(new JLabel("First number: "));
    mainPanel.add(firstField);

    mainPanel.add(new JLabel("Second number: "));
    mainPanel.add(secondField);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(subButton);
    buttonPanel.add(mulButton);
    buttonPanel.add(divButton);

    mainPanel.add(buttonPanel);
    mainPanel.add(resultLabel);

    add(mainPanel);

    addButton.addActionListener(e -> calculate('+'));
    subButton.addActionListener(e -> calculate('-'));
    mulButton.addActionListener(e -> calculate('*'));
    divButton.addActionListener(e -> calculate('/'));

    mainPanel.setBackground(backgroundColor);
    buttonPanel.setBackground(backgroundColor);

    addButton.setBackground(buttonColor);
    subButton.setBackground(buttonColor);
    mulButton.setBackground(buttonColor);
    divButton.setBackground(buttonColor);

    resultLabel.setForeground(textColor);
}


    private void calculate(char op) {
        try {
            double first = Double.parseDouble(firstField.getText());
            double second = Double.parseDouble(secondField.getText());
            double result = 0.0;

            if (op == '+') {
                result = first + second;
            } else if (op == '-') {
                result = first - second;
            } else if (op == '*') {
                result = first * second;
            } else if (op == '/') {
                if (second == 0) {
                    resultLabel.setText("Cannot divide by zero");
                    return;
                }
                result = first / second;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid number!");
        }
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.setVisible(true);
    }
}
