package Q1;
import Utils.Console;

public class LP3_13 {
    public static void main(String[] args) {
        String ans = Console.input("Enter p for Principal or a for Amount");
        if (ans.equals("p")) {
            int p = Console.input("Enter the principal: ");
            int y = Console.input("Enter the number of years: ");
            double i = Console.input("Enter the interest rate: ");

            double v = p * (1 + y * i);
            System.out.printf("The value after the term is: $%.2f", v);
        } else {
            int a = Console.input("Enter the amount: ");
            int y = Console.input("Enter the number of years: ");
            double i = Console.input("Enter the interest rate: ");

            double v = a / (1 + y * i);
            System.out.printf("The principal after the term is: $%.2f", v);
        }
    }
}
/*
Enter the principal: 5000
Enter the number of years: 5
Enter the interest rate: .06
The value after the term is: $6500.00
 */