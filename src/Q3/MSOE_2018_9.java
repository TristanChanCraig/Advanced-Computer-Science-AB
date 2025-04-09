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
            int numeric = ((int) c) - 32;
            String binary = Integer.toBinaryString(numeric);
            while (binary.length() != 6) binary = "0" + binary;
            strBinary += binary;
        }
        String strKey = "000000" + Integer.toBinaryString(key);
        String newStrBinary = "";
        for (int i = 0; i < strBinary.length(); i++) {
            if (i < strKey.length()) newStrBinary += strBinary.charAt(i) ^ strKey.charAt(i);
            else newStrBinary += strBinary.charAt(i) ^ strKey.charAt(i % (strKey.length()-1)); // fix
        }
        System.out.println(newStrBinary);
        String newLine = "";
        for (int i = 0; i < newStrBinary.length(); i+=6) {
            int ascii = Integer.parseInt(newStrBinary.substring(i, i+6), 2) + 32;
            char c = (char) ascii;
            newLine += c;
        }

        System.out.println(strBinary);
        System.out.println(strKey);
        System.out.print(newLine);
//        line = String.valueOf(binary ^ k);
//        System.out.println(line);
//        System.out.println(binary);
//        System.out.println(k);
    }
}
/*
Welcome to MSOE
8675309
Math.pow(Integer.parseInt(strBinary.substring(strBinary.length()-1-i, strBinary.length()-i)), i)
 */