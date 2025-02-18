package Q3.CS_161_LabJ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CalculatorGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField outputField;
    private JButton a4Button;
    private JButton a1Button;
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

    public static void clearCalc(JTextField outputField) {
        outputField.setText("0");
    }
    public static void addDigit(JTextField outputField, int digit, Calculator calc) {
        calc.add(calc.getValue()*10+digit);
    }
    public static String addDecimal(JTextField outputField, Calculator calc) {

    }
    public static String addOperation(JTextField outputField, String op, Calculator calc) {

    }
    public static double getDisplayValue(String num) {
        return Double.parseDouble(num);
    }
    public static String applyOperation(JTextField outputField, Calculator calc) {

    }

    public CalculatorGUI() {
        // TODO
        var calc = new Calculator();
        outputField.setEditable(false);

        a0Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 0, calc);
            }
        });
        a1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 1, num);
            }
        });
        a2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 2, num);
            }
        });
        a3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 3, num);
            }
        });
        a4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 4, num);
            }
        });
        a5Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 5, num);
            }
        });
        a6Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 6, num);
            }
        });
        a7Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 7, num);
            }
        });
        a8Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 8, num);
            }
        });
        a9Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDigit(outputField, 9, num);
            }
        });
        divideButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addOperation(outputField, "/", num);
            }
        });
        multiplyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addOperation(outputField, "*", num);
            }
        });
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addOperation(outputField, "+", num);
            }
        });
        subtractButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addOperation(outputField, "-", num);
            }
        });
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearCalc(outputField);
            }
        });
        periodButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = addDecimal(outputField, num);
            }
        });
        equalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num = applyOperation(outputField, num);
            }
        });
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
