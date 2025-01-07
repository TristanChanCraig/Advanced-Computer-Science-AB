package Q2.Prog1999s;

import DataStructures.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Prog1999s {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999s.txt"));

            int num = file.nextInt();
            file.nextLine();
            BinarySearchTree recipeCatalog = new BinarySearchTree<>();
            for (int i = 0; i < num; i++) {
                String name = file.next();
                String temp = file.nextLine().trim();
                recipeCatalog.insert(new Recipe(name, new IngredientBatch(temp)));
            }

            num = file.nextInt();
            file.nextLine();
            IngredientItem[] inventoryBuffer = new IngredientItem[num];
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                inventoryBuffer[i] = new IngredientItem(temp2[0], Integer.parseInt(temp2[1]));
            }

            num = file.nextInt();
            file.nextLine();
            DoublyLinkedList shipmentManager = new DoublyLinkedList();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                shipmentManager.add(new IngredientBatch(temp));
            }

            num = file.nextInt();
            file.nextLine();
            Queue processOrders = new Queue<>();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                processOrders.enqueue(new Order(temp2[0], Integer.parseInt(temp2[1])));
            }

            num = file.nextInt();
            file.nextLine();
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
            file.nextLine();
            Stack stack = new Stack();
            for (int i = 0; i < num; i++) {
                String temp = file.nextLine();
                String[] temp2 = temp.split(" ");
                stack.push(temp2[1]);
            }

            file.close();

            // remove from shipment manager add to inventory buffer
            var items = new ArrayList<IngredientItem>();
            for (int j = 0; j < shipmentManager.size(); j++) {
                IngredientBatch e = (IngredientBatch) shipmentManager.get(j);
                ArrayList<IngredientItem> ings = e.getIngredients();
                for (IngredientItem item2 : ings) {
                    var found = false;
                    for (IngredientItem item : inventoryBuffer) {
                        if (item.getName().equalsIgnoreCase(item2.getName())) {
                            item.addCnt(item2.getCnt());
                            found = true;
                        }
                    }
                    if (!found) items.add(item2);
                }
            }
            var ogSize = inventoryBuffer.length;
            inventoryBuffer = Arrays.copyOf(inventoryBuffer, ogSize + items.size());
            for (int i = 0; i < items.size(); i++) inventoryBuffer[ogSize+i] = items.get(i);

            while (!processOrders.isEmpty()) {
                Order order = (Order) processOrders.dequeue();
                int amt = order.getAmt();
                String name = order.getName();
                Recipe recipe = (Recipe) recipeCatalog.findString(name);
                var ings = recipe.getIngredients().getIngredients();
                for (IngredientItem item : ings) {
                    for (var n : inventoryBuffer) {
                        if (n.getName().equals(item.getName())) {
                            n.subtractCnt(item.getCnt() * amt); // TODO: fix amount subtracted
                            break;
                        }
                    }
                }
            }

            System.out.println("FINAL:");
            for (IngredientItem ingredientItem : inventoryBuffer)
                System.out.println(ingredientItem.getName() + " " + ingredientItem.getCnt());
            System.out.println("\nFEATURED MEALS:");
            while (!deque.isEmpty()) System.out.println(deque.dequeueFront());
            System.out.println("\nTOP OF RECENTLY VIEWED:");
            System.out.print(stack.pop());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
