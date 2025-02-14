package Q3;
import DataStructures.Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Pelican_54_7 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Langdat/HeapData.in"));
        var heap = new PriorityQueue<String>();
        while (input.hasNext()) heap.add(input.next());

        var arr = new String[heap.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = heap.remove();

        for (int i = 0; i < arr.length; i++) {
            if (i == 1 || i == 3 || i == 15 || i == 7) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }
}
/*
A
C D
G M N P
Q S T U W Z
 */