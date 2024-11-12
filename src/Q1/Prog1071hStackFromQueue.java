package Q1;

import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

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

            System.out.println("Ending Merchandise Inventory:");
            QueueStack<Cl1071h> temp = new QueueStack<>();
            while (file2.hasNext()) {
                String c = file2.next();
                int code = file2.nextInt();
                int quantity = file2.nextInt();
                double cost = file2.nextDouble();
                while (code != qs.peek().getCode() && cost != qs.peek().getValue()) temp.push(qs.pop());
                if (!qs.isEmpty()) Cl1071h jon = qs.pop();
                if (c.equalsIgnoreCase("B")) {
                    if (jon.getValue() != cost) {
                        Cl1071h men = new Cl1071h(code, quantity, cost);
                        temp.push(men);
                    } else {
                        jon.buy(quantity);
                    }
                } else {
                    if (jon.getValue() != cost) {
                        Cl1071h men = new Cl1071h(code, quantity, cost);
                        temp.push(men);
                    } else {
                        jon.sell(quantity);
                    }
                }
                System.out.printf("%d\t\t%d\t\t%.2f\n", jon.getCode(), jon.getQuantity(), jon.getValue());
                while (!qs.isEmpty()) temp.push(qs.pop());
                while (!temp.isEmpty()) qs.push(temp.pop());
            }
            file2.close();

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

Ending Merchandise Inventory:
5		30		489.75
10		21		238.99
10		21		250.00
5		38		489.75
5		38		510.25
1		80		1298.00
9		2000		19.99
3		128		248.85
2		70		107.50
1		80		1305.75
1		110		1305.75
6		5		600.00
6		11		600.00
2		100		107.50
3		128		275.55
3		138		275.55
1		110		1325.00
1		110		1355.00
1		113		1355.00
9		2000		21.25
9		2140		21.25
2		100		111.25
2		108		111.25
7		30		87.50
4		5000		1.10
1		126		1355.00
 */