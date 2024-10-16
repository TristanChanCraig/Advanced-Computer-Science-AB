package Q1.Pelican_42_7;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("$#,###.##");
        ArrayList<BankAccount> aryList = new ArrayList<BankAccount>();
        String name;

        do {
            Scanner kbReader = new Scanner(System.in);
            System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" ");
                BankAccount bA = new BankAccount(name, amount);
                aryList.add(bA);
            }
        } while (!name.equalsIgnoreCase("EXIT"));
        ListIterator<BankAccount> iter = aryList.listIterator();
        BankAccount bruh = iter.next();
        //while (iter.hasNext()) bruh = iter.next();

        //iter = aryList.listIterator();
        double maxBalance = bruh.balance;
        String maxName = bruh.name;
        while (iter.hasNext()) {
            bruh = iter.next();
            if (bruh.balance > maxBalance) {
                maxBalance = bruh.balance;
                maxName = bruh.name;
            }
        }
        System.out.println("The account with the largest balance belongs to " + maxName + ".");
        System.out.print("The amount is $" + maxBalance);
    }
}
/*
Please enter the name to whom the account belongs. ("Exit" to abort) my bad
Please enter the amount of the deposit. 12

Please enter the name to whom the account belongs. ("Exit" to abort) its jonahs fault
Please enter the amount of the deposit. -1021030321

Please enter the name to whom the account belongs. ("Exit" to abort) exit
The account with the largest balance belongs to my bad.
The amount is $12.0
 */