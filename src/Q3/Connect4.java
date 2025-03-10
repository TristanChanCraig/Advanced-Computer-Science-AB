package Q3;

import Q3.CS_161_LabJ.CalculatorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connect4 {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JTextField textField31;
    private JTextField textField32;
    private JTextField textField33;
    private JTextField textField34;
    private JTextField textField35;
    private JTextField textField36;
    private JTextField textField37;
    private JTextField textField38;
    private JTextField textField39;
    private JTextField textField40;
    private JTextField textField41;
    private JTextField textField42;
    private JTextField textField43;
    private JButton dropButton;
    private JButton dropButton1;
    private JButton dropButton2;
    private JButton dropButton3;
    private JButton dropButton4;
    private JButton dropButton5;
    private JButton dropButton6;
    private JButton resetButton;
    private JPanel mainPanel;
    private final String[][] board = new String[6][7];

    public JPanel getMainPanel() { return mainPanel; }

    public int checkLowestSpot(int column) {
        for (int i = 6; i >= 0; i--) if (board[i][column] == null)
    }

    public Connect4() {
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
        textField8.setEditable(false);
        textField9.setEditable(false);
        textField10.setEditable(false);
        textField11.setEditable(false);
        textField12.setEditable(false);
        textField13.setEditable(false);
        textField14.setEditable(false);
        textField15.setEditable(false);
        textField16.setEditable(false);
        textField17.setEditable(false);
        textField18.setEditable(false);
        textField19.setEditable(false);
        textField20.setEditable(false);
        textField21.setEditable(false);
        textField22.setEditable(false);
        textField23.setEditable(false);
        textField24.setEditable(false);
        textField25.setEditable(false);
        textField26.setEditable(false);
        textField27.setEditable(false);
        textField28.setEditable(false);
        textField29.setEditable(false);
        textField30.setEditable(false);
        textField31.setEditable(false);
        textField32.setEditable(false);
        textField33.setEditable(false);
        textField34.setEditable(false);
        textField35.setEditable(false);
        textField36.setEditable(false);
        textField37.setEditable(false);
        textField38.setEditable(false);
        textField39.setEditable(false);
        textField40.setEditable(false);
        textField41.setEditable(false);
        textField42.setEditable(false);
        textField43.setEditable(false);

        dropButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args)
    {
        var frame = new JFrame("Connect 4");
        frame.setContentPane(new Connect4().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
