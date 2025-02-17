package Q3.CS_161_LabJ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField outputField;
    private JButton a4Button;
    private JButton a1Button1;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton a7Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton divideButton;
    private JButton clearButton;
    private JButton a0Button;
    private JButton periodButton;
    private JButton equalButton;
    private JButton addButton;

    public CalculatorGUI() {
        // TODO
        var calc = new Calculator();
        outputField.setEditable(false);
        double num = 0;


    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
