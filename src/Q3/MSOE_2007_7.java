package Q3;

import java.util.Scanner;

public class MSOE_2007_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of digits in the odometer: ");
        int digits = input.nextInt();
        System.out.print("Current reading: ");
        int reading = input.nextInt();

        int closestPalindrome = Integer.MAX_VALUE;
        StringBuilder currPalindrome = new StringBuilder();
        currPalindrome.append("0".repeat(Math.max(0, digits / 2)));
        for (int j = 1; j < 10*digits/2-1; j++) {
            currPalindrome.replace(currPalindrome.length()/2-1-(j/10+1), currPalindrome.length()/2+1, String.valueOf(j));
            currPalindrome.append(currPalindrome.reverse());
            int curr = Integer.parseInt(String.valueOf(currPalindrome));
            if (reading - curr < reading - closestPalindrome) closestPalindrome = curr;
        }
        System.out.println(closestPalindrome);
    }
}
