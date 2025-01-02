package Q2.Prog1999s;

import DataStructures.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1999s {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999s.txt"));

            int num = file.nextInt();
            BinarySearchTree recipeCatalog = new BinarySearchTree<>();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                String[] i1 = temp2[1].split(":");
                String[] i2 = temp2[2].split(":");
                String[] i3 = temp2[3].split(":");
                recipeCatalog.insert(new Recipe(temp2[0], i1[0], i2[0], i3[0], Integer.parseInt(i1[1]), Integer.parseInt(i2[1]), Integer.parseInt(i3[1])));
            }

            num = file.nextInt();
            IngredientItem[] inventoryBuffer = new IngredientItem[num];
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                inventoryBuffer[i] = new IngredientItem(temp2[0], Integer.parseInt(temp2[1])
            }

            num = file.nextInt();
            DoublyLinkedList shipmentManager = new DoublyLinkedList();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                // TODO: do the ingredient batch thing
            }

            Queue processOrders = new Queue<>();

            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
