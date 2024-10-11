package Q1;

import java.util.Scanner;

public class Pelican_37_8 {
    static class LinearFunction implements LinearFunctionMethods {
        private double m;
        private double b;
        private double root;

        public LinearFunction(double slope, double yIntc) {
            m = slope;
            b = yIntc;
            root = 0;
        }


        @Override
        public double getSlope() { return m; }

        @Override
        public double getYintercept() { return b; }

        @Override
        public double getRoot() { return (-1 * b) / getSlope(); }

        @Override
        public double getYvalue(double x) { return (m * x) + b; }

        @Override
        public double getXvalue(double y) { return (y - b) / m; }


    }

    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in);

        System.out.print("What is the slope of your line? ");
        double slope = kbReader.nextDouble();

        System.out.print("What is the y-intercept of your line? ");
        double yIntc = kbReader.nextDouble();

        LinearFunction line = new LinearFunction(slope, yIntc);
        System.out.println("\nSlope of this line is: " + line.getSlope());
        System.out.println("Y-intercept of this line is: " + line.getYintercept());
        System.out.println("Root of this line is: " + line.getRoot());

        System.out.print("\nWhat is an x value for which you wish to solve for y? ");
        double x = kbReader.nextDouble();
        double yValue = line.getYvalue(x);
        System.out.println("The y value corresponding to x = " + x + " is " + yValue);

        System.out.print("\nWhat is a y value for which you wish to solve for x? ");
        double y = kbReader.nextDouble();
        double xValue = line.getXvalue(y);
        System.out.println("The x value corresponding to y = " + y + " is " + xValue);
    }
}
/*
What is the slope of your line? -3
What is the y-intercept of your line? 2.5

Slope of this line is: -3.0
Y-intercept of this line is: 2.5
Root of this line is: 0.8333333333333334

What is an x value for which you wish to solve for y? -4.61
The y value corresponding to x = -4.61 is 16.330000000000002

What is a y value for which you wish to solve for x? 5.0
The x value corresponding to y = 5.0 is -0.8333333333333334

Process finished with exit code 0
 */