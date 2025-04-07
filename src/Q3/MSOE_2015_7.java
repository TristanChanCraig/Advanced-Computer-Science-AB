package Q3;

import java.util.Arrays;
import java.util.Scanner;

public class MSOE_2015_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be partitioned: ");
        int num = input.nextInt();
        input.close();

        System.out.print("The array is: ");
        int[] arr = new int[3];
        for (int i = 0; i <= num; i++) {
            int t1 = (i*(i+1))/2;
            for (int j = 0; j <= num; j++) {
                int t2 = (j*(j+1))/2;
                for (int k = 0; k <= num; k++) {
                    int t3 = (k*(k+1))/2;
                    if (t1 + t2 + t3 == num) {
                        arr = new int[]{t1, t2, t3};
                    }
                }
            }
        }
        for (int n : arr) System.out.print(n + " ");
    }
}
/*
Enter the number to be partitioned: 20
The array is: 10 10 0

Enter the number to be partitioned: 1
The array is: 1 0 0

Enter the number to be partitioned: 6
The array is: 6 0 0

Enter the number to be partitioned: 30
The array is: 28 1 1
 */