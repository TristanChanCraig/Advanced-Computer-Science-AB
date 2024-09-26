package Q1;

import java.util.Scanner;

public class MSOE_2007_3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter in the first angle in degrees: ");
        double A = input.nextDouble();
        System.out.print("Enter in the second angle in degrees: ");
        double B = input.nextDouble();
        System.out.print("Enter in the third angle in degrees: ");
        double C = input.nextDouble();
        System.out.print("Enter in the side opposite of the third angle: ");
        double c = input.nextDouble();

        if (A + B + C <= 179.0 || A + B + C >= 181.0) {
            System.out.println("The angles do not add up to 180");
        } else {
            double r = c * Math.sin(Math.toRadians(A / 2)) * Math.sin(Math.toRadians(B / 2)) * (1.0 / Math.cos(Math.toRadians(C / 2)));
            System.out.printf("The radius of the inscribed circle is %.2f", r);
        }
    }
}
