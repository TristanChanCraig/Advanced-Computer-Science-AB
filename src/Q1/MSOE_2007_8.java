package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MSOE_2007_8 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/problem8.dat"));

            int[][] arr = new int[file.nextInt()][file.nextInt()];
            for (int lcv = 0; lcv < arr.length; lcv++)
                for (int lcv2 = 0; lcv2 < arr[0].length; lcv2++)
                    arr[lcv][lcv2] = file.nextInt();


            file.close();


            for (int lcv = 1; lcv < arr.length - 1; lcv++) {
                for (int lcv2 = 1; lcv2 < arr[0].length - 1; lcv2++) {
                    if (arr[lcv][lcv2] >= arr[lcv-1][lcv2-1] &&
                            arr[lcv][lcv2] >= arr[lcv-1][lcv2+1] &&
                            arr[lcv][lcv2] >= arr[lcv-1][lcv2] &&
                            arr[lcv][lcv2] >= arr[lcv][lcv2-1] &&
                            arr[lcv][lcv2] >= arr[lcv][lcv2+1] &&
                            arr[lcv][lcv2] >= arr[lcv+1][lcv2+1] &&
                            arr[lcv][lcv2] >= arr[lcv+1][lcv2] &&
                            arr[lcv][lcv2] >= arr[lcv+1][lcv2-1]) {
                        System.out.println("Row: " + lcv);
                        System.out.println("Column: " + lcv2);
                        System.out.println("Height: " + arr[lcv][lcv2]);
                        System.out.println();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Row: 1
Column: 4
Height: 27

Row: 1
Column: 6
Height: 94

Row: 2
Column: 3
Height: 27

Row: 3
Column: 1
Height: 36

Row: 3
Column: 8
Height: 31
 */