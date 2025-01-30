package Q3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MSOE_2014_5 {
    public static int calc(int num) {
        var arr = new ArrayList<Integer>();
        int res = 1;
        int i = 2;
        while (num != 1) {
            while (num % i == 0) {
                num /= i;
                arr.add(i);
            }
            i++;
        }
        var unique = arr.stream().distinct().toList();
        for (int e : arr) res *= e;
        for (int n : unique) res /= n;
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = input.nextInt();
        System.out.print("The prime factorization is: " + calc(num));
    }
}
/*
Enter a positive integer: 44100
The prime factorization is: 210

Enter a positive integer: 1960
The prime factorization is: 28
 */