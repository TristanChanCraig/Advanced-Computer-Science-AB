package Q1;
import Algorithms.SortingAlgorithms;

import Algorithms.SortingAlgorithms;

public class Pelican_40_1 {
    public static  void main(String[] args) {
        Integer[] theArray = {4,2,5,1,3,18,0,9,6};
        Integer[] bArr = {4,2,5,1,3,18,0,9,6};
        Integer[] sArr = {4,2,5,1,3,18,0,9,6};
        Integer[] iArr = {4,2,5,1,3,18,0,9,6};

        System.out.print("Original Array: ");
        for (Integer b : theArray) {
            System.out.print(b + " ");
        }
        System.out.println();

        System.out.print("Bubble Sort: ");
        SortingAlgorithms.bubbleSort(bArr);
        for (Integer r : bArr) {
            System.out.print(r + " ");
        }
        System.out.println();

        System.out.print("Selection Sort: ");
        SortingAlgorithms.bubbleSort(sArr);
        for (Integer u : sArr) {
            System.out.print(u + " ");
        }
        System.out.println();

        System.out.print("Insertion Sort: ");
        SortingAlgorithms.bubbleSort(iArr);
        for (Integer h : iArr) {
            System.out.print(h + " ");
        }

    }
}
/*
Original Array: 4 2 5 1 3 18 0 9 6
Bubble Sort: 0 1 2 3 4 5 6 9 18
Selection Sort: 0 1 2 3 4 5 6 9 18
Insertion Sort: 0 1 2 3 4 5 6 9 18
 */