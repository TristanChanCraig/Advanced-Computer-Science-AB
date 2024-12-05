package Q2.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Algorithms.SortingAlgorithms;
import DataStructures.DynamicArray;

public class Problem1Part2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("C:\\Users\\chan.t3\\IdeaProjects\\Advanced-Computer-Science-AB\\src\\Q2\\AdventOfCode\\Input\\Problem1"));
            DynamicArray<Integer> f = new DynamicArray<>();
            DynamicArray<Integer> s = new DynamicArray<>();

            while (input.hasNext()) {
                f.add(input.nextInt());
                s.add(input.nextInt());
            }

            var fi = f.toArray();
            var se = s.toArray();

            int total = 0;
            for (int i = 0; i < fi.length; i++) {
                int cnt = 0;
                for (int j = 0; j < se.length; j++) {
                    if ((int)(fi[i]) == (int)(se[j])) cnt++;
                }
                total += ((int)fi[i] * cnt);
            }
            System.out.println(total);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
// 18567089