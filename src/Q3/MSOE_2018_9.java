package Q3;

import java.util.Locale;
import java.util.Scanner;

public class MSOE_2018_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter plain cipher or text: ");
        String line = input.nextLine().toUpperCase();
        System.out.print("Enter key: ");
        int key = input.nextInt();
        String strBinary = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            strBinary += Integer.toBinaryString(c);
        }
        String strKey = Integer.toBinaryString(key);
        for (int i = 0; i < strKey.length(); i++) {

        }

        line = String.valueOf(binary ^ k);
        System.out.println(line);
        System.out.println(binary);
        System.out.println(k);
    }
}
/*
Welcome to MSOE
8675309
Math.pow(Integer.parseInt(strBinary.substring(strBinary.length()-1-i, strBinary.length()-i)), i)
 */