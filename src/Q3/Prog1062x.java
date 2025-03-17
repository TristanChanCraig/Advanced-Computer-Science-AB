package Q3;

import DataStructures.LRUCache;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1062x {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1062x.dat"));
            LRUCache<Integer, String > lrucache = new LRUCache<Integer, String>();

            while (file.hasNext()) {
                String[] temp = file.nextLine().split(" ");
                if (temp[0].equals("PUT")) {
                    lrucache.put(Integer.valueOf(temp[1]), temp[2]);
                    System.out.printf("PUT accepted. Key: %s, Value: %s\n", temp[1], temp[2]);
                } else if (temp[0].equals("GET")) {
                    String value = lrucache.get(Integer.valueOf(temp[1]));
                    if (value != null) System.out.printf("GET accepted. Key: %s, Value: %s\n", temp[1], value);
                    else System.out.printf("GET failed. Key: %s, Cache miss.\n", temp[1]);
                } else if (temp[0].equals("REPORT")) {
                    System.out.println("Cache State:");
                    lrucache.report();
                }
            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
PUT accepted. Key: 1, Value: A
PUT accepted. Key: 2, Value: B
PUT accepted. Key: 3, Value: C
GET accepted. Key: 1, Value: A
PUT accepted. Key: 4, Value: D
Cache State:
4:D -> 1:A -> 3:C -> END
GET failed. Key: 2, Cache miss.
Cache State:
4:D -> 1:A -> 3:C -> END
 */