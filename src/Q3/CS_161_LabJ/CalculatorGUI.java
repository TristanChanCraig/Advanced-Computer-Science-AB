package Q3.CS_161_LabJ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
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
    private static boolean period = false;
    private static int numAfterPeriod = 0;
    private static String num = "";
    private static Calculator calc = new Calculator();

    public static void clearCalc(JTextField outputField) {
        calc.clear();
        period = false;
        numAfterPeriod = 0;
        num = "";
        outputField.setText("");
    }
    public static void addDigit(JTextField outputField, double digit) {
        num += (int)digit;
        if (!period) {
            outputField.setText(num);
        }
        else {
            outputField.setText(num);
            numAfterPeriod++;
        }

    }
    public static boolean addDecimal(JTextField outputField) {
        num += ".";
        outputField.setText(num);
        return true;
    }
    public static double getDisplayValue(String num) {
        return Double.parseDouble(num);
    }
    public static void applyOperation(JTextField outputField, int op) {
        calc.applyOperation(getDisplayValue(num), op);
        num = "";
        outputField.setText("");
        if (op == 0) {
            String temp = String.valueOf(calc.getValue());
            if (temp.substring(temp.length()-2).equals(".0")) {
                period = false;
                num = String.valueOf((int)calc.getValue());
                numAfterPeriod = 0;
            }
            else {
                num = String.valueOf(calc.getValue());
                numAfterPeriod = num.split("\\.")[1].length();
            }
            outputField.setText(num);
        }
    }

    public JPanel getMainPanel() { return mainPanel; }

    public CalculatorGUI() {
        calc = new Calculator();
        outputField.setEditable(false);

        a0Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 0);
            }
        });
        a1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 1);
            }
        });
        a2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 2);
            }
        });
        a3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 3);
            }
        });
        a4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 4);
            }
        });
        a5Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 5);
            }
        });
        a6Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 6);
            }
        });
        a7Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 7);
            }
        });
        a8Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 8);
            }
        });
        a9Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDigit(outputField, 9);
            }
        });
        divideButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyOperation(outputField, 4);
            }
        });
        multiplyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyOperation(outputField, 3);
            }
        });
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyOperation(outputField, 1);
            }
        });
        subtractButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyOperation(outputField, 2);
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
                period = addDecimal(outputField);
            }
        });
        equalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyOperation(outputField, 0);
            }
        });
    }
}
