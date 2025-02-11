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

                        var set2 = new Set<Integer>();
                        for (int l = 0; l < skyscraper[i].length; i++) set2.insert(skyscraper[l][j]);
                        if (set2.size() != skyscraper[0].length) bruh.add(false);
                        else bruh.add(true);
                    }
                }
            }
        }
         if (bruh.contains(false)) return 2;
        // Error 3
        for (int i = 0; i < clues.length; i++) {
            int d = clues[i][0];
            int index = clues[i][1];
            int buildings = clues[i][2];
            int cnt = 1;
            switch (d) {
                case 0:
                    for (int j = skyscraper.length-2; j >= 0; j--) if (skyscraper[j][index] > skyscraper[j+1][index]) cnt++;
                    break;
                case 1:
                    for (int j = skyscraper.length-2; j >= 0; j--) if (skyscraper[index][j] > skyscraper[index][j+1]) cnt++;
                    break;
                case 2:
                    for (int j = 1; j < skyscraper.length; j++) if (skyscraper[j][index] > skyscraper[j-1][index]) cnt++;
                    break;
                case 3:
                    for (int j = 1; j < skyscraper.length; j++) if (skyscraper[index][j] > skyscraper[index][j-1]) cnt++;
                    break;
            }
            if (cnt != buildings) return 3;
        }

        // Default
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
