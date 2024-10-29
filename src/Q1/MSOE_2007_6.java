package Q1;
import java.lang.Math;
import java.util.Scanner;

public class MSOE_2007_6 {
    public static double f(double x) {
        return Math.exp(-x*x/2) / Math.sqrt(2*Math.PI);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the A: ");
        double a = input.nextDouble();

        System.out.print("Enter the B: ");
        double b = input.nextDouble();

        System.out.print("Enter the N: ");
        double n = input.nextDouble();

        double h = (b - a) / n;
        double area = 0.0;
        for (int lcv = 0; lcv <= n; lcv++) {
            area += f(a + lcv*h);
        }
        area *= h;
        System.out.println("The area is: " + area);
    }
}
