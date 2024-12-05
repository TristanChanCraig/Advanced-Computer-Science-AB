package Q2.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;
import DataStructures.DynamicArray;

public class Problem2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("C:\\Users\\chan.t3\\IdeaProjects\\Advanced-Computer-Science-AB\\src\\Q2\\AdventOfCode\\Input\\Problem2"));
            DynamicArray<String> dArr = new DynamicArray<>();

            while (input.hasNext()) {
                dArr.add(input.nextLine());
            }

            int total = 0;

            for (int i = 0; i < dArr.size(); i++) {
                boolean safe = true;
                String[] arr = dArr.get(i).split(" ");
                for (int j = 0; j < arr.length - 1; j++) {
                    int diff = Integer.parseInt(arr[j+1]) - Integer.parseInt(arr[j]);
                    if (diff > 3 || diff < 1) safe = false;
                    if (Integer.parseInt(arr[j+1]) - Integer.parseInt(arr[j]) < 0) safe = false;
                }
                if (safe) total++;
            }

            System.out.println(total);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
//