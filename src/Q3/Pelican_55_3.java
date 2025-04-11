package Q3;

import DataStructures.PriorityQueue;

public class Pelican_55_3 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer iw;

        iw = 8;
        pq.enqueue(iw);

        iw = 2;
        pq.enqueue(iw);

        iw = 1;
        pq.enqueue(iw);

        iw = 9;
        pq.enqueue(iw);

        iw = 5;
        pq.enqueue(iw);

        iw = 4;
        pq.enqueue(iw);

        while (!pq.isEmpty()) System.out.println(pq.dequeue());
    }
}
/*
9
8
5
4
2
1
 */