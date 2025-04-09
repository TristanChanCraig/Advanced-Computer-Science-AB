package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MSOE_2009_9 { // use doubly linked lists?
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE_2009_9.txt"));

            int n = file.nextInt();
            while (file.hasNext()) {

            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
