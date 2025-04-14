package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2009_9 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE_2009_9.txt"));
            var input = new Scanner(System.in);

            int n = file.nextInt();
            int[][] mat = new int[n][n];
            file.nextLine();
            while (file.hasNext()) {
                String[] temp = file.nextLine().split(" ");
                mat[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
                mat[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
            }
            file.close();
            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[0].length; j++)
                    if (mat[i][j] == 0 && i != j) mat[i][j] = 9999;

//            for (int i = 0; i < mat.length; i++) {
//                for (int j = 0; j < mat[0].length; j++) {
//                    int deg = mat[i][j];
//                    if (deg != 0 && deg != 9999) {
//                        for (int k = 0; k < mat[j].length; k++) {
//                            if (mat[j][k] != 0 && mat[j][k] != 9999) {
//                                mat[i][k] = mat[i][j] + mat[j][k];
//                            }
//                        }
//                    }
//                }
//            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    for (int k = 0; k < mat[0].length; k++) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }

            System.out.print("Person 1: ");
            int a = input.nextInt();
            System.out.print("Person 2: ");
            int b = input.nextInt();
            System.out.print("Distance: " + mat[a][b]);

//            for (int[] i : mat) {
//                for (int j : i) System.out.print(j + " ");
//                System.out.println();
//            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Person 1: 3
Person 2: 5
Distance: 9999

Person 1: 2
Person 2: 4
Distance: 3

Person 1: 5
Person 2: 5
Distance: 0
 */