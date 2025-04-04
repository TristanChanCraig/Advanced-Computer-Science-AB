package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MSOE_2009_8 {
    public static void print(String[][] mat) {
        for (String[] arr : mat) {
            for (String str : arr) System.out.print(str + " ");
            System.out.println();
        }
    }

    public static void nextTo(String[][] mat, int prevI, int prevJ, int i, int j) {
        if ((i < 0 || i > mat.length - 1) || (j < 0 || j > mat[0].length - 1)) return;
        if (Objects.equals(mat[i][j], "*") && !Objects.equals(mat[prevI][prevJ], "*")) {
            mat[i][j] = mat[prevI][prevJ];
            nextTo(mat, i, j, i - 1, j - 1);
            nextTo(mat, i, j, i - 1, j);
            nextTo(mat, i, j, i - 1, j + 1);
            nextTo(mat, i, j, i, j - 1);
            nextTo(mat, i, j, i, j + 1);
            nextTo(mat, i, j, i + 1, j - 1);
            nextTo(mat, i, j, i + 1, j);
            nextTo(mat, i, j, i + 1, j + 1);
        }
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/image1.txt"));
            var file2 = new Scanner(new File("Langdat/image2.txt"));

            int row = file.nextInt();
            int col = file.nextInt();
            String[][] first = new String[row][col];
            file.nextLine();
            for (int i = 0; i < row; i++) {
                String line = file.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    first[i][j] = line.substring(j, j+1);
                }
            }
            file.close();
            int row2 = file2.nextInt();
            int col2 = file2.nextInt();
            String[][] second = new String[row2][col2];
            file2.nextLine();
            for (int i = 0; i < row2; i++) {
                String line = file2.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    second[i][j] = line.substring(j, j+1);
                }
            }
            file2.close();

            for (int i = 0; i < first.length; i++) for (int j = 0; j < first[0].length; j++) if (first[i][j] == null) first[i][j] = "";
            for (int i = 0; i < second.length; i++) for (int j = 0; j < second[0].length; j++) if (second[i][j] == null) second[i][j] = "";

            var alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int index = 0;
            for (int i = 0; i < first.length - 1; i++) {
                for (int j = 0; j < first[0].length - 1; j++) {
                    if (Objects.equals(first[i][j], "*")) {
                        first[i][j] = alph.substring(index, index+1);
                        index++;
                        nextTo(first, i, j, i - 1, j - 1);
                        nextTo(first, i, j, i - 1, j);
                        nextTo(first, i, j, i - 1, j + 1);
                        nextTo(first, i, j, i, j - 1);
                        nextTo(first, i, j, i, j + 1);
                        nextTo(first, i, j, i + 1, j - 1);
                        nextTo(first, i, j, i + 1, j);
                        nextTo(first, i, j, i + 1, j + 1);
                    }
                }
            }
            print(first);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
