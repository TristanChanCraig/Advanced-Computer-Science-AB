package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MSOE_2007_9 {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            var file = new Scanner(new File("Langdat/problem9.dat"));

            while (file.hasNext()) {
                int num = file.nextInt();
                int index = num/2;
                arr[index]++;
            }
            file.close();

            for (int lcv = 0; lcv < arr.length; lcv++) {
                System.out.print(lcv + " - " + lcv+1 + " ");
                for (int lcv2 = 0; lcv2 < arr[lcv]; lcv2++) {
                    System.out.print("*");
                }
                System.out.println();
            }
          
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
