package Q3;
import Algorithms.SortingAlgorithms;
import DataStructures.DynamicArray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog485aHeapSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog485a.dat"));
            var arrlist = new DynamicArray<String>();

            while (file.hasNext()) {
                arrlist.add(file.next());
            }
            file.close();

            System.out.println("Original List");
            for (int i = 0; i < arrlist.size(); i++) {
                System.out.print(arrlist.get(i) + " ");
                if ((i + 1) % 10 == 0) System.out.println();
            }
            System.out.println("\n");

            var arr = arrlist.toArray();
            SortingAlgorithms.heapSort(arr);

            System.out.println("Sorted List");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                if ((i + 1) % 10 == 0) System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
