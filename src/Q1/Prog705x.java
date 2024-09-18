package Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog705x {
    public static void main(String[] args) throws FileNotFoundException {
        var scannerOne = new Scanner(new File("Langdat/prog705x.txt"));
        var scannerTwo = new Scanner(new File("Langdat/prog512h.dat"));

        ArrayList<String> codes = new ArrayList<>();
        ArrayList<String[]> lines = new ArrayList<>();
        String result = "";

        while (scannerOne.hasNextLine()) {
            codes.add(scannerOne.nextLine());
        }

        while (scannerOne.hasNextLine()) {
            String l = scannerTwo.nextLine();
            String line[] = l.split(" ");
            lines.add(line);
        }

        for (String code : codes) {
            int line = 0;
            if (code.substring(0,1).equalsIgnoreCase("0")) {
                line = Integer.parseInt(code.substring(1, 2)) - 1;
            } else line = Integer.parseInt(code.substring(0, 2)) - 1;
            int word = Integer.parseInt(code.substring(2, 3)) - 1;
            int charc = Integer.parseInt(code.substring(3, 4)) - 1;
            String[] l = lines.get(line);
            String w = l[word];
            String c = w.substring(charc, charc+1);
            result += c;
        }

        System.out.println(result);
    }
}
