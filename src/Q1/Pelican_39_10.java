package Q1;

import java.util.Scanner;

public class Pelican_39_10 {
    public static int modFibonacci(int num) {
        if (num == 0) return 3;
        if (num == 1) return 5;
        if (num > 2) return modFibonacci(num - 1) + modFibonacci(num - 2) + modFibonacci(num - 3);
        return modFibonacci(num - 1) + modFibonacci(num - 2);

    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();

        System.out.printf("Term #%d is %d", n, modFibonacci(n));
    }
}
/*
Enter number: 5
Term #5 is 53

Enter number: 6
Term #6 is 98
 */