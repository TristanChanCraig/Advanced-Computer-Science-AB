package DataStructures;

import java.util.Iterator;

public class IntLinkedList implements Iterable<Integer> {
    private class Node {
        int data;
        Node next; // Pointer/reference to the next node

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public IntLinkedList() { head = null; }

    public void addFront(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;

            public boolean hasNext() { return current != null; }

            public Integer next() {
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public int getCount() {
        int cnt = 0;
        Node temp = head;
        while (temp.next != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public boolean isEmpty() { return head == null; }

    public int getFirst() {
        return head.data;
    }

    public int getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int getSpot(int pos) {
        if (pos < 0 || pos > getCount()) return -1;
        int cnt = 0;
        Node temp = head;
        int num = 0;
        while (temp.next != null) {
            if (cnt == pos) num = temp.data;
            temp = temp.next;
            cnt++;
        }
        return num;
    }

    public void removeFirst() {
        Node temp = head;
        while (temp.next != null) {
            head = temp.next;
            temp = head;
        }
    }

    public void removeLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp = null;
    }

    public int countLess10() {
        int cnt = 0;
        for (int lcv = 0; lcv < getCount(); lcv++)
            if (getSpot(lcv) < 10)
                cnt++;
        return cnt;
    }

    public void removeIndex(int num) {
        int cnt = 0;
        Node temp = head;
        while (temp.next != null) {
            if (cnt == num) temp = null;
            temp = temp.next;
            cnt++;
        }
    }

    public void clear() {
        Node temp = head;
        while (temp.next != null) {
            temp = null;
            temp = temp.next;
        }
    }

    public boolean contains(int n) {
        Node temp = head;
        boolean there = false;
        while (temp.next != null) {
            if (temp.data == n) there = true;
            temp = temp.next;
        }
        print();
        return there;
    }

    public IntLinkedList getReverse() {
        IntLinkedList list = new IntLinkedList();
        Node temp = head;
        for (int lcv = 0; lcv < getCount(); lcv++) {
            list.addFront(temp.data);
            temp = temp.next;
        }
        return list;
    }

    public double avg() {
        double avg = 0;
        for (int lcv = 0; lcv < getCount(); lcv++) {
            avg += getSpot(lcv);
        }
        return avg / getCount();
    }

    public int min() {
        int min = getSpot(0);
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getSpot(lcv) < min) min = getSpot(lcv);
        }
        return min;
    }

    public int max() {
        int max = getSpot(0);
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getSpot(lcv) > max) max = getSpot(lcv);
        }
        return max;
    }

    public int indexOfMax() {
        int max = getSpot(1);
        int index = 0;
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getSpot(lcv) > max) {
                max = getSpot(lcv);
                index = lcv;
            }
        }
        return max;
    }

    public int lastIndexOfMax() {
        int max = getSpot(1);
        int index = 0;
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getSpot(lcv) > max) {
                max = getSpot(lcv);
                index = lcv;
            } else if (max == getSpot(lcv)) index = lcv;
        }
        return index;
    }

    public void sort() {
        for ()
    }
}
