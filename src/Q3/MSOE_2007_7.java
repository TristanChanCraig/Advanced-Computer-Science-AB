package Q3;

import java.util.Scanner;

public class MSOE_2007_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of digits in the odometer: ");
        int digits = input.nextInt();
        System.out.print("Current reading: ");
        int reading = input.nextInt();
        for (int i = 1; i < digits; i++) {
            int left = (int) Math.floor(reading / Math.pow(10, digits-1));
            if (left > reading % 10) {

            }
        }
    }
}
