package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.Scanner;

public class Prog602bStack {
    static class Cl602bStack {
        private int n;
        private double h;
        private int c;
        private double bc;
        private int sc;
        private double amt;

        private void calc() {
            if (h <= 5) {
                bc = 200;
            } else if (h <= 15) {
                bc = 200 + (50 * (h - 5));
            } else bc = 550 + (30 * (h - 15));

            switch (c) {
                case 0 -> sc = 0;
                case 1 -> sc = 50;
                default -> sc = 150;
            }

            amt = sc + bc;
        }

        public Cl602bStack(int num, double hours, int code) {
            n = num;
            h = hours;
            c = code;
            calc();
        }

        public double getAmtDue() { return amt; }
        public String toString() {
            return String.format("%d\t\t%.2f\t\t%d\t\t%.2f", n, h, c, amt);
        }
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            var stack = new Stack<Cl602bStack>();
            while (file.hasNext()) {
                int account = file.nextInt();
                double hours = file.nextDouble();
                int code = file.nextInt();
                stack.push(new Cl602bStack(account, hours, code));
            }
            file.close();

            System.out.println("Account\t\tHours\t\tCode\tAmount Due");
            while (!stack.isEmpty()) {
                var fred = stack.pop();
                System.out.println(fred.toString());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Account		Hours		Code	Amount Due
29118		15.02		0		550.60
23051		1.55		2		350.00
22841		27.90		2		1087.00
21352		5.84		0		242.00
20045		5.00		1		250.00
19111		12.00		2		700.00
17185		7.93		1		396.50
14063		17.06		1		661.80
1825		3.25		0		200.00
 */