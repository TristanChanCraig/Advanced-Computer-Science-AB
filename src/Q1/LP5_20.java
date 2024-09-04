package Q1;

import java.util.Scanner;

public class LP5_20 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String sen = input.nextLine();
        String vowels = "aeiouAEIOU";
        int cnt = 0;
        for (int lcv = 0; lcv < sen.length(); lcv++) if (vowels.contains(sen.substring(lcv, lcv + 1))) cnt++;
        System.out.print("The number of vowels in " + sen + "is " + cnt + ".");
    }
}
/*
Enter text: Java Programming Assignment
The number of vowels in Java Programming Assignmentis 8.
 */