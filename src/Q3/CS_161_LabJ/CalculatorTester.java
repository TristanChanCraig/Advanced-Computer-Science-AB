package Q3.CS_161_LabJ;

import javax.swing.*;

/**
 * Tests an AddingMachine
 * 
 * @author joel
 */
public class CalculatorTester
{
	public static void main(String[] args)
	{
		var frame = new JFrame("Calculator");
		frame.setContentPane(new CalculatorGUI().getMainPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
