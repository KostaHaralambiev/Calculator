import javax.swing.*;
import java.awt.*;

public class CalculatorApp extends JFrame {
    private JTextField firstField;
    private JTextField secondField;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    public CalculatorApp() {
    setTitle("Calculator");
    setSize(450, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    firstField = new JTextField();
    secondField = new JTextField();

    resultLabel = new JLabel("Result: ");

    // ПЪРВО създаваме бутоните
    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");

    // После създаваме шрифта и го слагаме навсякъде
    Font font = new Font("Arial", Font.PLAIN, 18);

    firstField.setFont(font);
    secondField.setFont(font);
    resultLabel.setFont(font);

    addButton.setFont(font);
    subButton.setFont(font);
    mulButton.setFont(font);
    divButton.setFont(font);

    // Добавяме компонентите към панела
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

    // Закачаме слушателите
    addButton.addActionListener(e -> calculate('+'));
    subButton.addActionListener(e -> calculate('-'));
    mulButton.addActionListener(e -> calculate('*'));
    divButton.addActionListener(e -> calculate('/'));
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
