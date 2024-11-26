package Q2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class arrlisttest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hi: ");
        String line = input.nextLine();
        String regex = line.replaceAll("(?<=.)(?=.)", "+");
        System.out.println(regex);
    }
}
