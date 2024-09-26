package Q1;

import java.util.Scanner;

public class MSOE_2007_2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Enter in a string: ");
        String s = input.nextLine().toLowerCase();
        String v = "aeiou";
        int cnt = 0;
        for (int lcv = 0; lcv < s.length(); lcv++)
            if (v.contains(s.substring(lcv, lcv+1))) cnt++;
        System.out.println("There are " + cnt + " vowel(s) in the string");
    }
}
/*
Enter in a string:
I HATE JONAH
There are 5 vowel(s) in the string
 */