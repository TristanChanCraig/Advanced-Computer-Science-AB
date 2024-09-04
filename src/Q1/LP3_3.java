package Q1;

import java.util.Scanner;

public class LP3_3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter cost of rent: ");
        double rent = input.nextInt();

        System.out.print("Enter cost of tuition: ");
        double tut = input.nextInt();

        System.out.print("Enter cost of books: ");
        double books = input.nextInt();

        System.out.print("Enter the scholarship money: ");
        double ss = input.nextInt();

        double cost = rent + tut + books - ss;

        System.out.printf("The cost of college is $%.2f", cost);
    }
}
/*
Enter cost of rent: 2500
Enter cost of tuition: 20000
Enter cost of books: 1000
Enter the scholarship money: 2000
The cost of college is $21500.00
 */