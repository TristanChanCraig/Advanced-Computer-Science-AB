package Q1;

import java.util.Scanner;

public class MSOE_2007_1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter in the first height: ");
        double h1 = input.nextDouble();
        System.out.print("Enter in the first shadow: ");
        double s1 = input.nextDouble();
        System.out.print("Enter in the second height: ");
        double h2 = input.nextDouble();
        System.out.printf("The unknown shadow is %.2f", (h2*s1) / h1);
    }
}
/*
Enter in the first height: 10
Enter in the first shadow: 100
Enter in the second height: 20
The unknown shadow is 200.00
 */