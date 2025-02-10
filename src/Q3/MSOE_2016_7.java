package Q3;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import DataStructures.Set;

public class MSOE_2016_7 {
    public static int helper(int[][] skyscraper, int[][] clues, int n) {
        // Error 1
        for (int i = 0; i < n; i++) {
            var set = new Set<Integer>();
            for (int j = 0; j < skyscraper[i].length; j++) set.insert(skyscraper[i][j]);
            if (set.size() != skyscraper[i].length) return 1;
        }
        for (int j = 0; j < n; j++) {
            var set = new Set<Integer>();
            for (int i = 0; i < skyscraper[0].length; i++) set.insert(skyscraper[i][j]);
            if (set.size() != skyscraper[0].length) return 1;
        }
        // Error 2
        var bruh = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (skyscraper[i][j] == 0) {
                    for (int k = 1; k <= n; k++) {
                        var set = new Set<Integer>();
                        for (int l = 0; l < skyscraper[i].length; i++) set.insert(skyscraper[i][l]);
                        if (set.size() != skyscraper[0].length) bruh.add(false);
                        else bruh.add(true);

                        for (int l = 0; l < skyscraper[i].length; i++) set.insert(skyscraper[l][j]);
                        if (set.size() != skyscraper[0].length) bruh.add(false);
                        else bruh.add(true);
                    }
                }
            }
        }
        // if (!bruh.contains(true) || !bruh.size() == 0) return 2; // fix this shit
        // Error 3


        return 0;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner one = new Scanner(new File("Langdat/2016_7_1.txt"));
        Scanner two = new Scanner(new File("Langdat/2016_7_2.txt"));

        int n = Integer.parseInt(one.next());
        int[][] skyscraper = new int[n][n];
        int clue = Integer.parseInt(one.next());
        int[][] clues = new int[clue][3];
        for (int i = 0; i < clue; i++) for (int j = 0; j < 3; j++) clues[i][j] = Integer.parseInt(one.next());
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) skyscraper[i][j] = Integer.parseInt(two.next());

        switch (helper(skyscraper, clues, n)) {
            case 0 -> System.out.println("There are no errors");
            case 1 -> System.out.println("Error 1: The same number between 1 and N appears more than once in any row or column.");
            case 2 -> System.out.println("Error 2: There is an empty cell that cannot be filled with a number since all the numbers 1\n" +
                    "through N already appear in the 2N-2 cells in the same row and column.");
            case 3 -> System.out.println("Error 3: There is a row or column that is completely filled that does not present the number of\n" +
                    "specified faces.");
        }
    }
}
