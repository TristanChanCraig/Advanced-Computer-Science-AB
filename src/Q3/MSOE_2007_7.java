package Q3;

import java.util.Scanner;

public class MSOE_2007_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of digits in the odometer: ");
        int digits = input.nextInt();
        System.out.print("Current reading: ");
        int reading = input.nextInt();
        int total = 0;
        int digits2 = digits;
        for (int i = 0; i < digits2 / 2 + 1; i++) {
            int left = (int) Math.floor(reading / Math.pow(10, digits-1));
            if (left > reading % 10) {
                total += (left - reading % 10) * Math.pow(10, i);
            } else if (left < reading % 10) {
                int multiplier = (int) Math.pow(10, i);
                if (i == 0) {
                    multiplier = 0;
                    total += 10 + left - (reading % 10);
                    reading += 10 + left - (reading % 10);
                } else if (digits == 2) {
                    total += (10 + left - (reading % 10)) * multiplier + multiplier;
                    reading += (10 + left - (reading % 10)) * multiplier + multiplier;
                } else {
                    total += (10 + left - (reading % 10)) * multiplier;
                    reading += (10 + left - (reading % 10));
                }
                reading %= Math.pow(10, digits-1);
                reading /= 10;
                digits -= 2;
            }
        }
        System.out.println("Distance: " + total);
    }
}
