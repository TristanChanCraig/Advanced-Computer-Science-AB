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

        public void setValue(int v) { value = v; }

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
            while (file2.hasNext()) {
                String c = file2.next();
                var temp = qs;
                if (c.equalsIgnoreCase("B")) {
                    int code = file2.nextInt();
                    int quantity = file2.nextInt();
                    double cost = file2.nextDouble();
                    while (code != temp.peek().getCode()) temp.pop();
                    Cl1071h jon = temp.pop();
                    jon.sell(quantity);
                    System.out.printf("%d\t\t%d\t\t%.2f\n", jon.getCode(), jon.getQuantity(), jon.getValue());
                } else {
                    int code = file2.nextInt();
                    int quantity = file2.nextInt();
                    while (code != temp.peek().getCode()) temp.pop();
                    Cl1071h jon = temp.pop();
                    jon.sell(quantity);
                    System.out.printf("%d\t\t%d\t\t%.2f\n", jon.getCode(), jon.getQuantity(), jon.getValue());
                }
            }
            file2.close();

            for (Cl1071h die = qs.pop(); !qs.isEmpty();) {
                System.out.printf("%d\t\t%d\t\t%.2f\n", die.getCode(), die.getQuantity(), die.getValue());
                die = qs.pop();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
