package Q3;

import DataStructures.Set;

import java.util.Scanner;

public class Prog213bSet {
    static class Cl213b implements Comparable<Cl213b> {
        private int num;
        private double price;
        private double amt;

        private void calc() {
            if (num < 100) {
                price = 5.95;
            } else if (num < 200) {
                price = 5.75;
            } else if (num < 300) {
                price = 5.40;
            } else {
                price = 5.15;
            }
            amt = num * price;
        }

        public Cl213b(int n) {
            num = n;
            price = 0;
            amt = 0;
            calc();
        }

        public String toString() {
            return String.format("Price: $%.2f\nAmount Due: $%.2f\n", price, amt);
        }

        @Override
        public int compareTo(Cl213b o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Cl213b> set = new Set<Cl213b>();
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter quantity: ");
            int num = input.nextInt();
            Cl213b bro = new Cl213b(num);
            System.out.println(bro.toString());
            set.insert(bro);
        }
    }
}
/*
Enter quantity: 50
Price: $5.95
Amount Due: $297.50

Enter quantity: 199
Price: $5.75
Amount Due: $1144.25

Enter quantity: 200
Price: $5.40
Amount Due: $1080.00

Enter quantity: 475
Price: $5.15
Amount Due: $2446.25
 */