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
    private int turn;

    public JPanel getMainPanel() { return mainPanel; }

    public int checkLowestSpot(int column) {
        for (int i = 6; i >= 0; i--) if (board[i][column] == null) return i;
        return -1;
    }

    public void drop(int column, int turn) {
        String chip = (turn == 0) ? "○" : "⬤";
        int row = checkLowestSpot(column);
        if (row == 0 && column == 0) textField2.setText(chip);
        if (row == 0 && column == 1) textField3.setText(chip);
        if (row == 0 && column == 2) textField4.setText(chip);
        if (row == 0 && column == 3) textField5.setText(chip);
        if (row == 0 && column == 4) textField6.setText(chip);
        if (row == 0 && column == 5) textField7.setText(chip);
        if (row == 0 && column == 6) textField8.setText(chip);
        if (row == 1 && column == 0) textField9.setText(chip);
        if (row == 1 && column == 1) textField10.setText(chip);
        if (row == 1 && column == 2) textField11.setText(chip);
        if (row == 1 && column == 3) textField12.setText(chip);
        if (row == 1 && column == 4) textField13.setText(chip);
        if (row == 1 && column == 5) textField14.setText(chip);
        if (row == 1 && column == 6) textField15.setText(chip);
        if (row == 2 && column == 0) textField16.setText(chip);
        if (row == 2 && column == 1) textField17.setText(chip);
        if (row == 2 && column == 2) textField18.setText(chip);
        if (row == 2 && column == 3) textField19.setText(chip);
        if (row == 2 && column == 4) textField20.setText(chip);
        if (row == 2 && column == 5) textField21.setText(chip);
        if (row == 2 && column == 6) textField22.setText(chip);
        if (row == 3 && column == 0) textField23.setText(chip);
        if (row == 3 && column == 1) textField24.setText(chip);
        if (row == 3 && column == 2) textField25.setText(chip);
        if (row == 3 && column == 3) textField26.setText(chip);
        if (row == 3 && column == 4) textField27.setText(chip);
        if (row == 3 && column == 5) textField28.setText(chip);
        if (row == 3 && column == 6) textField29.setText(chip);
        if (row == 4 && column == 0) textField30.setText(chip);
        if (row == 4 && column == 1) textField31.setText(chip);
        if (row == 4 && column == 2) textField32.setText(chip);
        if (row == 4 && column == 3) textField33.setText(chip);
        if (row == 4 && column == 4) textField34.setText(chip);
        if (row == 4 && column == 5) textField35.setText(chip);
        if (row == 4 && column == 6) textField36.setText(chip);
        if (row == 5 && column == 0) textField37.setText(chip);
        if (row == 5 && column == 1) textField38.setText(chip);
        if (row == 5 && column == 2) textField39.setText(chip);
        if (row == 5 && column == 3) textField40.setText(chip);
        if (row == 5 && column == 4) textField41.setText(chip);
        if (row == 5 && column == 5) textField42.setText(chip);
        if (row == 5 && column == 6) textField43.setText(chip);
        turn = (turn == 0) ? 1 : 0;
    }

    public boolean winCondition() { return false; } // TODO:

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
        turn = 0;

        dropButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(0, turn);
            }
        });
        dropButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(1, turn);
            }
        });
        dropButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(2, turn);
            }
        });
        dropButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(3, turn);
            }
        });
        dropButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(4, turn);
            }
        });
        dropButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(5, turn);
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
