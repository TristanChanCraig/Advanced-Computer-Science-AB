package Q2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;
import DataStructures.DynamicArray;

@SuppressWarnings("unchecked")
public class Prog575aMergeSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog575a.dat"));
            DynamicArray<String> arrList = new DynamicArray<>();

            while (file.hasNext()) {
                arrList.add(file.nextLine());
            }
            file.close();

            var arr = arrList.toArray();

            System.out.print("Original list: " + arrList);
            SortingAlgorithms.mergeSort(arr);
            System.out.print("\nSorted list: " + Arrays.toString(arr));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Original list: [ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN]
Sorted list: [EIGHT, ELEVEN, FIVE, FOUR, NINE, ONE, SEVEN, SIX, TEN, THIRTEEN, THREE, TWELVE, TWO]
 */