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
/*
Original List
80 75 50 50 50 50 60 60 40 40
25 45 50 45 45 50 50 50 20 20
10 85 85 100 100 50 50 100 10 90
10 70 70 70 70 60 60 60 90 90
80 20 10 40 5 95 50 50 50

Sorted List
10 10 10 10 100 100 100 20 20 20
25 40 40 40 45 45 45 5 50 50
50 50 50 50 50 50 50 50 50 50
50 60 60 60 60 60 70 70 70 70
75 80 80 85 85 90 90 90 95
 */