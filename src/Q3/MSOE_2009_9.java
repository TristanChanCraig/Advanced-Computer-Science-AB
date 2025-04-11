package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2009_9 {
    static class Person {
        private int id;
        private int[] connections;
        private boolean[] did;


        Person(int id, int con) {
            this.id = id;
            connections = new int[con];
            did = new boolean[con];
        }
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE_2009_9.txt"));

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
                    if (mat[i][j] == 0) mat[i][j] = 9999;

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
                    int deg = mat[i][j];
                    if (deg != 0 && deg != 9999) {
                        for (int k = 0; k < mat[0].length; k++) {
                            int currDeg = mat[i][k];
                            if (currDeg + mat[j][k] < deg) deg = currDeg + mat[j][k];
                        }
                    }
                }
            }

            for (int[] i : mat) {
                for (int j : i) System.out.print(j + " ");
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
