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
                num[index]++;
            }
            file.close();

            for (int lcv = 0; lcv < histo.length; lcv++) {
                System.out.print(lcv + " - " + lcv+1 + " ")
                for (int lcv = 0; lcv < histo[lcv]; lcv++) {
                    System.out.print("*");
                }
                System.out.println();
            }
          
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
