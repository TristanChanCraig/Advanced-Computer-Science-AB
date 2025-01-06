package Q2.Prog1999s;

import DataStructures.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog1999s {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999s.txt"));

            int num = file.nextInt();
            BinarySearchTree recipeCatalog = new BinarySearchTree<>();
            for (int i = 0; i < num; i++) {
                String name = file.next();
                String temp = file.nextLine();
                recipeCatalog.insert(new Recipe(name, new IngredientBatch(temp)));
            }

            num = file.nextInt();
            IngredientItem[] inventoryBuffer = new IngredientItem[num];
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                inventoryBuffer[i] = new IngredientItem(temp2[0], Integer.parseInt(temp2[1]));
            }

            num = file.nextInt();
            DoublyLinkedList shipmentManager = new DoublyLinkedList();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                shipmentManager.add(new IngredientBatch(temp));
            }

            num = file.nextInt();
            Queue processOrders = new Queue<>();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                processOrders.enqueue(new Order(temp2[0], Integer.parseInt(temp2[1])));
            }

            num = file.nextInt();
            Deque deque = new Deque<>();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                switch (temp2[0]) {
                    case "ADD_FRONT":
                        deque.enqueueFront(temp2[1]);
                        break;
                    case "ADD_BACK":
                        deque.enqueueRear(temp2[1]);
                        break;
                    case "REMOVE_FRONT":
                        deque.dequeueFront();
                        break;
                    case "REMOVE_BACK":
                        deque.dequeueRear();
                        break;
                }
            }

            num = file.nextInt();
            Stack stack = new Stack();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                stack.push(temp2[1]);
            }

            file.close();

            // remove from shipment manager add to inventory buffer
            for (int i = 0; i < inventoryBuffer.length; i++) {
                IngredientItem item = inventoryBuffer[i];
                for (int j = 0; j < shipmentManager.size(); j++) {
                    IngredientBatch e = (IngredientBatch) shipmentManager.get(j);
                    ArrayList<IngredientItem> ings = e.getIngredients();
                    for (int k = 0; k < ings.size(); k++) {
                        IngredientItem item2 = ings.get(k);
                        if (item.getName().equalsIgnoreCase(item2.getName())) {
                            item.addCnt(item2.getCnt());
                        }
                    }
                }
            }

            while (!processOrders.isEmpty()) {
                Order order = (Order) processOrders.dequeue();
                int amt = order.getAmt();
                String name = order.getName();
                Recipe recipe = getRecipe(name, recipeCatalog);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Recipe getRecipe(String name, BinarySearchTree recipes) {
        var node = recipes.getRoot();
        var left = recipes.getLeft(node);
        var right = recipes.getRight(node);
        while (left != null && right != null) {

        }
    }

    public static T getRecipeNode(T node, String name, BinarySearchTree recipes) {

    }
}
