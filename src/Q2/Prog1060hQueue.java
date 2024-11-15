package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.Queue;

public class Prog1060hQueue {
    static class Rates {
        private String size;
        private double cday;
        private double cmile;

        public Rates(String size, double cday, double cmile) {
            this.size = size;
            this.cday = cday;
            this.cmile = cmile;
        }
    }

    public static void main(String[] args) {
        try {
            var file1 = new Scanner(new File("Langdat/invntory.dat"));
            var file2 = new Scanner(new File("Langdat/rates.dat"));
            var file3 = new Scanner(new File("Langdat/transact.dat"));

            Queue<String> size = new Queue<>();
            Queue<String> name = new Queue<>();
            Queue<Double> miles = new Queue<>();
            Queue[] qs = {size, name, miles};
            while (file1.hasNext()) {
                String temp = file1.next();
                size.enqueue(temp.substring(0, 1));
                name.enqueue(temp.substring(1));
                miles.enqueue(file1.nextDouble());
            }
            file1.close();

            Rates[] rates = new Rates[100];
            int i = 0;
            while (file2.hasNext()) {
                String temp = file2.next();
                rates[i] = new Rates(temp.substring(0, 1), Integer.parseInt(temp.substring(1)), file2.nextDouble());
                i++;
            }
            file2.close();

            Queue<String> rented = new Queue<>();
            while (file3.hasNext()) {
                String temp = file3.next();
                String code;
                switch (temp.substring(0,1)) {
                    case "L":
                        code = temp.substring(1, 2);
                        break;
                    case "R":
                        code = temp.substring(1, 2);
                        break;
                    case "A":
                        code = temp.substring(1, 2);
                        int days = Integer.parseInt(temp.substring(2, 3));
                        break;
                    case "C":

                        break;
                    default:
                        System.out.println("Not a valid transaction!");
                }
            }
            file3.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
