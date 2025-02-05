package Q3;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSOE_2016_7 {
    public static int helper(int[][] skyscraper, int[][] clues, int n) {
        int error = 0;
        // Error 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        // Error 2
        // Error 3

        return error;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner one = new Scanner(new File("Langdat\2016_7_1.txt"));
        Scanner two = new Scanner(new File("Langdat\2016_7_2.txt"));

        int n = Integer.parseInt(one.next());
        int[][] skyscraper = new int[n][n];
        int clue = Integer.parseInt(one.next());
        int[][] clues = new int[clue][3];
        for (int i = 0; i < clue; i++) for (int j = 0; j < 3; j++) clues[i][j] = Integer.parseInt(one.next());
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) skyscraper[i][j] = Integer.parseInt(two.next());


    }
}
