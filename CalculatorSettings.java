import javax.swing.*;
import java.awt.*;

public class CalculatorSettings extends JFrame {
    
    protected Font uiFont;
    protected Color backgroundColor;
    protected Color buttonColor;
    protected Color textColor;

    public CalculatorSettings() {
        uiFont = new Font("Arial", Font.PLAIN, 18);
        backgroundColor = Color.WHITE;
        buttonColor = new Color(230, 230, 230);
        textColor = Color.BLACK;
    }
}
