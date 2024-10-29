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
            while (file1.hasNext()) {
                int code = file1.nextInt();
                int quantity = file1.nextInt();
                double value = file1.nextDouble();
                qs.push(new Cl1071h(code, quantity, value));
                System.out.printf("%d\t\t%d\t\t%.2f\n", code, quantity, value);
            }
            file1.close();

            while (file2.hasNext()) {
                String c = file2.next();
                if (c.equalsIgnoreCase("B")) {
                    int code = file2.nextInt();
                    int quantity = file2.nextInt();
                    double cost = file2.nextDouble();
                } else {
                    int code = file2.nextInt();
                    int quantity = file2.nextInt();
                }
            }
            file2.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
