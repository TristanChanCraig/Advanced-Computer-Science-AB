package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class Prog705x {
    public static void main(String[] args) {
        var scannerOne = new Scanner("Langdat/prog705x.txt");
        var scannerTwo = new Scanner("Langdat/prog512h.dat");

        ArrayList<Integer> codes = new ArrayList<>();

        while (scannerOne.hasNextLine()) {
            codes.add(scannerOne.nextInt());
        }
    }
}
