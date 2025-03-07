package Q3;

import java.util.Scanner;

public class MSOE_2007_4 {
    public static double xy(String d, int num) {
        switch (d) {
            case "N" -> { return num/800.0; }
            case "E" -> { return num/1200.0; }
            case "S" -> { return num/-800.0; }
            case "W" -> { return num/-1200.0; }
            default -> { return 0.0; }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Address 1: ");
        String address1 = input.nextLine();
        System.out.print("Address 2: ");
        String address2 = input.nextLine();

        String[] temp1 = address1.split(" ");
        String[] temp2 = address2.split(" ");

        double x1 = xy(temp1[1], Integer.parseInt(temp1[0]));
        double y1 = xy(temp1[3], Integer.parseInt(temp1[2]));
        double x2 = xy(temp2[1], Integer.parseInt(temp2[0]));
        double y2 = xy(temp2[3], Integer.parseInt(temp2[2]));

        double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

        System.out.print(address1 + " to " + address2 + " = " + dist + " miles");
    }
}
/*
Address 1: 100 S 25 E
Address 2: 310 N 445 W
100 S 25 E to 310 N 445 W = 0.6450263775829465 miles

Address 1: 517 N 3876 W
Address 2: 6788 S 123 W
517 N 3876 W to 6788 S 123 W = 9.651993722153987 miles
 */