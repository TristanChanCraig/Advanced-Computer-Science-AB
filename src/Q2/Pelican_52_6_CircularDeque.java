package Q2;

import DataStructures.CircularDeque;
import java.util.LinkedList;


public class Pelican_52_6_CircularDeque {
    public static void main(String[] args) {
        CircularDeque<Integer> cq = new CircularDeque<>(50);
        for (int i = 1; i <= 50; i++) cq.enqueueLast(i);
        for (int i = 1; i <= 50; i++) {
            int value = cq.dequeueFirst();
            System.out.print(value + " ");
            cq.enqueue(value);
        }
        System.out.println();
        for (int i = 0; i < 40; i++) cq.enqueueLast(cq.dequeueFirst());

        for (int i = 1; i <= 50; i++) {
            int value = cq.dequeueFirst();
            System.out.print(value + " ");
            cq.enqueue(value);
        }
    }
}
/*
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
41 42 43 44 45 46 47 48 49 50 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40
 */