package Q3;

import java.util.Arrays;
import java.util.Scanner;

public class MSOE_2015_7 {
    public static int[] helper(int start, int[] arr, int target) {
        if (start >= 3) return arr;
        int cnt = 0;
        for (int i = start; i < 3; i++) cnt += arr[i];
        if (cnt == target) return arr;
        for (int i = target; i >= 0; i--) {
            double t = i*(i+1)/(double)2;
            if (t % 1 == 0 && t < target) {
                int[] temp = Arrays.copyOf(arr, 3);
                temp[start] = (int) t;
                int[] e = helper(start+1, temp, (int) (target-t));
                int c = 0;
                for (int j = 0; j < 3; j++) c += arr[j];
                if (c == target) return arr;
            }
        }
        return new int[3];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be partitioned: ");
        int num = input.nextInt();
        input.close();

        System.out.print("The array is: ");
        int[] arr = helper(0, new int[3], num);
        for (int n : arr) System.out.print(n + " ");
    }
}