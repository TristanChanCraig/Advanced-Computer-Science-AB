package Q1;
import DataStructures.IntLinkedList;

import java.sql.SQLOutput;

public class BigLinkedList {
    public static void main(String[] args) {
        var list = new IntLinkedList();
        for (int i = 0; i < 200; i++)
            list.addFront((int)(Math.random()*100 + 1));
        // TODO: the rest
        var iter = list.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

        list.addFront(9);
        list.printList();
        list.addLast(2);
        list.printList();
        System.out.println(list.getCount());
        list.add(3, 2); // its broke
        list.printList();
        System.out.println(list.isEmpty());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getByIndex(4));
        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();
        System.out.println(list.countLess10());
        list.removeIndex(2);
        list.printList();
        System.out.println(list.contains(86));
        list.getReverse().printList();
        System.out.println(list.avg());
        System.out.println(list.min());
        System.out.println(list.max());
        System.out.println(list.indexOfMax());
        System.out.println(list.lastIndexOfMax());
        list.quickSort(0, list.getSize());
        list.printList();
        System.out.println(list.lose58());
        System.out.println(list.getEvenCount());
        list.removeOdds();
        list.printList();


    }
}
/*
97 76 36 38 87 52 72 26 93 84 41 76 54 58 91 6 100 29 47 92 63 48 33 95 56 50 2 58 60 81 54 46 25 36 57 66 23 64 79 76 33 52 4 91 63 10 52 14 39 77 67 59 31 47 35 9 4 25 8 23 82 59 37 26 62 60 41 32 11 77 93 24 78 26 73 59 88 61 11 93 59 47 17 8 20 39 36 86 54 78 42 27 45 95 36 81 49 100 61 92 29 7 96 51 61 3 60 35 12 4 49 38 66 94 32 45 41 74 18 56 33 10 67 56 68 40 37 52 35 53 99 84 12 2 52 27 71 59 28 16 12 94 47 80 8 53 58 29 16 19 41 26 38 87 28 5 86 51 41 8 6 40 8 75 11 23 51 2 42 22 9 88 66 34 81 81 24 28 24 20 49 49 90 91 44 32 79 41 83 77 73 60 45 1 92 13 83 40 68 22
9 97 76 36 38 87 52 72 26 93 84 41 76 54 58 91 6 100 29 47 92 63 48 33 95 56 50 2 58 60 81 54 46 25 36 57 66 23 64 79 76 33 52 4 91 63 10 52 14 39 77 67 59 31 47 35 9 4 25 8 23 82 59 37 26 62 60 41 32 11 77 93 24 78 26 73 59 88 61 11 93 59 47 17 8 20 39 36 86 54 78 42 27 45 95 36 81 49 100 61 92 29 7 96 51 61 3 60 35 12 4 49 38 66 94 32 45 41 74 18 56 33 10 67 56 68 40 37 52 35 53 99 84 12 2 52 27 71 59 28 16 12 94 47 80 8 53 58 29 16 19 41 26 38 87 28 5 86 51 41 8 6 40 8 75 11 23 51 2 42 22 9 88 66 34 81 81 24 28 24 20 49 49 90 91 44 32 79 41 83 77 73 60 45 1 92 13 83 40 68 22
9 97 76 36 38 87 52 72 26 93 84 41 76 54 58 91 6 100 29 47 92 63 48 33 95 56 50 2 58 60 81 54 46 25 36 57 66 23 64 79 76 33 52 4 91 63 10 52 14 39 77 67 59 31 47 35 9 4 25 8 23 82 59 37 26 62 60 41 32 11 77 93 24 78 26 73 59 88 61 11 93 59 47 17 8 20 39 36 86 54 78 42 27 45 95 36 81 49 100 61 92 29 7 96 51 61 3 60 35 12 4 49 38 66 94 32 45 41 74 18 56 33 10 67 56 68 40 37 52 35 53 99 84 12 2 52 27 71 59 28 16 12 94 47 80 8 53 58 29 16 19 41 26 38 87 28 5 86 51 41 8 6 40 8 75 11 23 51 2 42 22 9 88 66 34 81 81 24 28 24 20 49 49 90 91 44 32 79 41 83 77 73 60 45 1 92 13 83 40 68 22 2
201
9 97 76 36 38 87 52 72 26 93 84 41 76 54 58 91 6 100 29 47 92 63 48 33 95 56 50 2 58 60 81 54 46 25 36 57 66 23 64 79 76 33 52 4 91 63 10 52 14 39 77 67 59 31 47 35 9 4 25 8 23 82 59 37 26 62 60 41 32 11 77 93 24 78 26 73 59 88 61 11 93 59 47 17 8 20 39 36 86 54 78 42 27 45 95 36 81 49 100 61 92 29 7 96 51 61 3 60 35 12 4 49 38 66 94 32 45 41 74 18 56 33 10 67 56 68 40 37 52 35 53 99 84 12 2 52 27 71 59 28 16 12 94 47 80 8 53 58 29 16 19 41 26 38 87 28 5 86 51 41 8 6 40 8 75 11 23 51 2 42 22 9 88 66 34 81 81 24 28 24 20 49 49 90 91 44 32 79 41 83 77 73 60 45 1 92 13 83 40 68 22 2
false
9
2
38
2
2
0
2
false

NaN
0
0
-1
0
2
0
0
2
 */