package Q2.AdventOfCode;

import DataStructures.DynamicArray;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("C:\\Users\\chan.t3\\IdeaProjects\\Advanced-Computer-Science-AB\\src\\Q2\\AdventOfCode\\Input\\Problem3"));
            String memory = "";

            while(input.hasNext()) {
                memory += input.nextLine();
            }

            int total = 0;
            while (memory.contains("mul(\\d,\\d)")) {
                int index = memory.indexOf("mul(\\d,\\d)");
                memory = memory.substring(index);
                int l = memory.indexOf("(");
                int r = memory.indexOf(")");
                String[] temp = memory.substring(l, r+1).split(",");
                total += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
                memory = memory.substring(r+1);
            }

            System.out.println(total);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
