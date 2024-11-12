package Q2;
import DataStructures.Queue;
import Q1.Prog602bStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Prog602bQueue {
    static class Cl602b implements Comparable<Cl602b> {
        private int num;
        private double h;
        private int c;
        private double amt;

        private void calc() {
            if (h > 15) amt = 550 + (30 * (h - 15));
            else if (h > 5) amt = 200 + (50 * (h - 5));
            else amt = 200;

            switch (c) {
                case 1 -> amt += 50;
                case 2 -> amt += 150;
                default -> amt += 0;
            }
        }

        Cl602b(int accountNumber, double hours, int code) {
            num = accountNumber;
            h = hours;
            c = code;
            calc();
        }

        @Override
        public int compareTo(Cl602b o) {
            return 0;
        }

        public String toString() {
            return String.format("%d\t\t%.2f\t\t%d\t\t%.2f", num, h, c, amt);
        }
    };

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            var q = new Queue<Cl602b>();
            while (file.hasNext()) {
                int account = file.nextInt();
                double hours = file.nextDouble();
                int code = file.nextInt();
                q.enqueue(new Cl602b(account, hours, code));
            }
            file.close();

            System.out.println("Account\t\tHours\t\tCode\tAmount Due");
            while (!q.isEmpty()) {
                var fred = q.dequeue();
                System.out.println(fred.toString());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Account		Hours		Code	Amount Due
1825		3.25		0		200.00
14063		17.06		1		661.80
17185		7.93		1		396.50
19111		12.00		2		700.00
20045		5.00		1		250.00
21352		5.84		0		242.00
22841		27.90		2		1087.00
23051		1.55		2		350.00
29118		15.02		0		550.60
 */