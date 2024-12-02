package Q2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class arrlisttest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First: ");
        String f = input.nextLine();
        System.out.print("Second: ");
        String s = input.nextLine();
        String regex = f.replaceAll("(?<=.)(?=.)", "+");
        System.out.println(f);
        System.out.println(s);
        System.out.println(regex);

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        boolean mFound = m.find();
        if (mFound) {
            System.out.println("first in second");
        } else {
            System.out.println("first not in second");
        }
    }
}