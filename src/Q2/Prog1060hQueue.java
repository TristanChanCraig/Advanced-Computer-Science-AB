package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.Queue;

public class Prog1060hQueue {
    static class Inventory implements Comparable<Inventory> {
        private String size;
        private String name;
        private double miles;

        public Inventory(String size, String name, double miles) {
            this.size = size;
            this.name = name;
            this.miles = miles;
        }

        @Override
        public int compareTo(Inventory o) {
            return 0;
        }
    }
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
            var inv = new Queue<Inventory>();
            var rates = new Queue<>();
            var trans = new Queue<>();


            while (file1.hasNext()) {
                String temp = file1.next();
                double miles = file1.nextDouble();
                inv.enqueue(new Inventory(temp.substring(0, 1), temp.substring(1), miles));
            }
            file1.close();

            while (file2.hasNext()) {

            }
            file2.close();

            while (file3.hasNext()) {

            }
            file3.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
