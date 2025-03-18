package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MSOE_2009_8 {
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
                for (int j = 0; j < col; j++) {
                    first[i][j] = line.substring(j, j+1);
                }
            }
            file.close();
            int row2 = file.nextInt();
            int col2 = file.nextInt();
            String[][] second = new String[row2][col2];
            file2.nextLine();
            for (int i = 0; i < row2; i++) {
                String line = file2.nextLine();
                for (int j = 0; j < col2; j++) {
                    second[i][j] = line.substring(j, j+1);
                }
            }
            file2.close();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
