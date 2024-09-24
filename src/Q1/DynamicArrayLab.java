package Q1;
import java.util.*;

import Algorithms.SortingAlgorithms;
import DataStructures.DynamicArray;

public class DynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("============== Dynamic Array ==============");
        var dArray = new DynamicArray<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) dArray.add((int)(Math.random() + 100_000));
        long end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms"); // ns to ms

        start = System.nanoTime();
        dArray.sort();
        end = System.nanoTime();
        System.out.println("Dynamic Array sort: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) dArray.remove(0);
        end = System.nanoTime();
        System.out.println("Dynamic Array remove: " + (end-start)/1e6 + " ms");

        // TODO: check against ArrayList
        // sort with "arrayList.sort(null);"
        System.out.println("============== ArrayList ==============");
        var aList = new ArrayList<Integer>();
        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) aList.add((int)(Math.random() + 100_000));
        end = System.nanoTime();
        System.out.println("ArrayList add: " + (end-start)/1e6 + " ms"); // ns to ms

        start = System.nanoTime();
        aList.sort(null);
        end = System.nanoTime();
        System.out.println("ArrayList sort: " + (end-start)/1e6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) aList.remove(0);
        end = System.nanoTime();
        System.out.println("ArrayList remove: " + (end-start)/1e6 + " ms");
    }
}
/*
============== Dynamic Array ==============
Dynamic Array add: 7.689 ms
Dynamic Array sort: 5.9085 ms
Dynamic Array remove: 14166.2436 ms
============== ArrayList ==============
ArrayList add: 5.9844 ms
ArrayList sort: 2.4268 ms
ArrayList remove: 399.7786 ms
 */