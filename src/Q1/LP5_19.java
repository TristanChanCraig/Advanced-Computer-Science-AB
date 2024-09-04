package Q1;

import java.util.Scanner;

public class LP5_19 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sen = input.nextLine();

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        sen = sen.substring(0 , sen.indexOf(str) - 1) + sen.substring(sen.indexOf(str) + str.length());
        System.out.print(sen);
    }
}
/*
Enter a sentence: I really hope you get an interview
Enter a string: really
I hope you get an interview
 */