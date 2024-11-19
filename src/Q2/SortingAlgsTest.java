package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import DataStructures.DynamicArray;
import Algorithms.SortingAlgorithms;

@SuppressWarnings("unchecked")
public class SortingAlgsTest {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/numsort.dat"));
            var nums = new DynamicArray<Integer>();

            while (file.hasNext()) {
                nums.add(file.nextInt());
            }
            file.close();

            var numsArray = nums.toArray();

            System.out.println("Original list: " + nums);
            SortingAlgorithms.mergeSort(numsArray);
            System.out.println("\nSorted list: " + Arrays.toString(numsArray));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

