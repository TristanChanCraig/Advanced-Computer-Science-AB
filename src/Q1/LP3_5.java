package Q1;

import java.util.Scanner;

public class LP3_5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter the change in cents: ");
        int change = input.nextInt();
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;

        while (change > 24) {
            change -= 25;
            q++;
        }

        while (change > 9) {
            change -= 10;
            d++;
        }

        while (change > 4) {
            change -= 5;
            n++;
        }

        p = change;

        System.out.println("The minimum number of coins is: ");
        System.out.println("Quarters: " + q);
        System.out.println("Dimes: " + d);
        System.out.println("Nickels: " + n);
        System.out.println("Pennies: " + p);
    }
}
/*
Enter the change in cents: 212
The minimum number of coins is:
Quarters: 8
Dimes: 1
Nickels: 0
Pennies: 2
 */