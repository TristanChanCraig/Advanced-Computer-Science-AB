package Q3;

import java.util.Objects;
import java.util.Scanner;

public class MSOE_2021_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        var pond = input.nextInt();
        input.nextLine();
        var line = input.nextLine();
        var cups = line.split(" ");
        int cnt = 0;
        for (int i = 0; i < cups.length; i++) {
            if (pond >= 10) {
                pond -= Integer.parseInt(cups[i]);
                pond--;
                cnt++;
            }
        }
        System.out.println("Filled " + cnt + " ");
    }
}
/*
34
4 6 6 4 4 8 6
Filled 5
 */