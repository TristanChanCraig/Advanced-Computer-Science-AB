package Q1;

import DataStructures.QueueStack;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class Prog1071hStackFromQueue {
    static class Cl1071h implements Comparable<Cl1071h> {
        private int code;
        private int quantity;
        private double value;

        public Cl1071h(int c, int q, double v) {
            code = c;
            quantity = q;
            value = v;
        }

        public int getCode() {
            return code;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getValue() {
            return value;
        }

        public void buy(int amt) { quantity += amt; }

        public void sell(int amt) { quantity -= amt; }

        @Override
        public int compareTo(Cl1071h o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        try {
            var file1 = new Scanner(new File("Langdat/bginvtry.txt"));
            var file2 = new Scanner(new File("Langdat/buysell.txt"));
            QueueStack<Cl1071h> qs = new QueueStack<>();
            System.out.println("Merchandise Inventory:");
            while (file1.hasNext()) {
                int code = file1.nextInt();
                int quantity = file1.nextInt();
                double value = file1.nextDouble();
                qs.push(new Cl1071h(code, quantity, value));
                System.out.printf("%d\t\t%d\t\t%.2f\n", code, quantity, value);
            }
            file1.close();
            System.out.println();
            System.out.println(qs.size());
            System.out.println(qs.peek().code);

            System.out.println("Ending Merchandise Inventory:");
            QueueStack<Cl1071h> temp = new QueueStack<>();
            while (file2.hasNext()) {
                String c = file2.next();
                int code = file2.nextInt();
                int quantity = file2.nextInt();
                if (c.equalsIgnoreCase("B")) {
                    double value = file2.nextDouble();
                    boolean e = true;
                    var jon = new Cl1071h(code, quantity, value);
                    while (qs.isEmpty()) {
                        var jack = qs.pop();
                        if (jack.getValue() == value && jack.getCode() == code) {
                            jon.buy(quantity);
                            e = false;
                            qs.push(jon);
                            break;
                        } else {
                            temp.push(jack);
                        }
//                        System.out.println(qs.size() + " yeet");
                    }
                    if (e) {
                        temp.push(new Cl1071h(code, quantity, value));
                    }
//                    var tem = temp.pop();
//                    System.out.println(temp.peek() + " " + tem);
//                    temp.push(tem);
                    while (!temp.isEmpty()) qs.push(temp.pop());
                } else {
                    while (!qs.isEmpty()) {
                        var bro = qs.pop();
                        if (bro.getCode() == code) {
                            if (bro.getQuantity() - quantity <= 0) {
                                quantity -= bro.getQuantity();

                            } else {
                                bro.sell(quantity);
                                qs.push(bro);
                                break;
                            }
                        } else {
                            temp.push(bro);
                        }

                    }
                    while (!temp.isEmpty()) qs.push(temp.pop());
                }
//                System.out.printf("%d\t\t%d\t\t%.2f\n", jon.getCode(), jon.getQuantity(), jon.getValue());
//                while (!qs.isEmpty()) temp.push(qs.pop());
//                System.out.println(qs.size());
            }
            file2.close();
            ArrayList<Cl1071h> te = new ArrayList<>();
            while (!qs.isEmpty()) { te.add(qs.pop()); }

            for (int i = te.size() - 1; i >= 0; i--) {
                System.out.printf("%d\t\t%d\t\t%.2f\n", te.get(i).getCode(), te.get(i).getQuantity(), te.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Merchandise Inventory:
1		50		1298.00
2		50		107.50
3		100		248.85
4		5000		1.07
5		20		489.75
6		5		586.24
7		30		84.23
8		600		24.73
9		1500		19.99
10		15		238.99

10
10
Ending Merchandise Inventory:
1		13		1298.00
3		72		248.85
4		5000		1.07
5		2		489.75
6		4		586.24
7		30		84.23
8		600		24.73
9		1000		19.99
10		9		238.99
10		15		250.00
5		20		510.25
3		15		275.55
9		10		21.25
2		2		111.25
7		10		87.50
4		750		1.10

Process finished with exit code 0

 */