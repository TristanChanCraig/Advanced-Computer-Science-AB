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

    public IntLinkedList() {
        head = null;
    }

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

    public void printList() {
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

            public boolean hasNext() {
                return current != null;
            }

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

    public void add(int n, int pos) {
        int cnt = 0;
        Node temp = head;
        Node t = new Node(n);

        if (head == null) {
            head = new Node(n);
            return;
        }
        pos--;
        while (temp.next != null && pos != 0) {
            temp = temp.next;
            pos--;
        }
        var current = temp;
        temp = temp.next;
        current.next = t;
        t.next = temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

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

    public int getByIndex(int pos) {
        if (pos < 0 || pos > getCount() || head == null) return -1;
        Node temp = head;
        int cnt = 0;
        if (cnt == pos) return temp.data;
        while (temp.next != null) {
            cnt++;
            temp = temp.next;
            if (cnt == pos) return temp.data;
        }
        return -1;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp = null;
    }

    public int countLess10() {
        int cnt = 0;
        for (int lcv = 0; lcv < getCount(); lcv++)
            if (getByIndex(lcv) < 10)
                cnt++;
        return cnt;
    }

    public void removeIndex(int num) {
        int cnt = 1;
        Node temp = head;
        while (temp.next != null) {
            if (getByIndex(cnt) == num) {
                temp = temp.next.next;
                break;
            }
            temp = temp.next;
            cnt++;
        }
    }

    public void clear() {
        head = null;
    }

    public boolean contains(int n) {
        Node temp = head;
        boolean there = false;
        while (temp.next != null) {
            if (temp.data == n) there = true;
            temp = temp.next;
        }
        return there;
    }

    public IntLinkedList getReverse() {
        IntLinkedList list = new IntLinkedList();
        for (int i = 0; i <= getSize(); i++) {
            list.addFront(getByIndex(i));
        }
        return list;
    }

    public double avg() {
        double avg = 0;
        for (int lcv = 0; lcv < getCount(); lcv++) {
            avg += getByIndex(lcv);
        }
        return avg / getCount();
    }

    public int min() {
        int min = getByIndex(0);
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getByIndex(lcv) < min) min = getByIndex(lcv);
        }
        return min;
    }

    public int max() {
        int max = getByIndex(0);
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getByIndex(lcv) > max) max = getByIndex(lcv);
        }
        return max;
    }

    public int indexOfMax() {
        int max = getByIndex(1);
        int index = 0;
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getByIndex(lcv) > max) {
                max = getByIndex(lcv);
                index = lcv;
            }
        }
        return max;
    }

    public int lastIndexOfMax() {
        int max = getByIndex(1);
        int index = 0;
        for (int lcv = 1; lcv < getCount(); lcv++) {
            if (getByIndex(lcv) > max) {
                max = getByIndex(lcv);
                index = lcv;
            } else if (max == getByIndex(lcv)) index = lcv;
        }
        return index;
    }

//    private int partition(int low, int high) {
//        int pivot = getByIndex(high);
//        int i = low - 1;
//        for (int j = low; j < high - 1; j++) {
//            if (getByIndex(j) <= pivot) {
//                i++;
//                swap(i, j);
//            }
//        }
//        swap(i + 1, high);
//        return i + 1;
//    }
//
//    public void quickSort(int low, int high) {
//        if (low < high) {
//            int pivot = partition(low, high);
//            quickSort(low, pivot - 1);
//            quickSort(pivot + 1, high);
//        }
//    }
//
//
//
    public void swap(int i, int j) {
        int temp = getByIndex(i);
        replaceSpot(i, getByIndex(j));
        replaceSpot(j, temp);
    }

    public void selectionSort() {
        int minIndex;
        for (int lcv = 0; lcv < getSize(); ++lcv) {
            minIndex = lcv;
            for (int lcv2 = lcv + 1; lcv2 < getSize(); ++lcv2) {
                if (getByIndex(lcv2) < getByIndex(minIndex)) {
                    minIndex = lcv2;
                }
            }
            swap(lcv, minIndex);
        }
    }

    public void replaceSpot(int pos, int num) {
        int cnt = 0;
        Node temp = head;
        while (temp.next != null) {
            if (cnt == pos) {
                temp.data = num;
                break;
            }
            temp = temp.next;
            cnt++;
        }
    }

    public int lose58() {
        int numCnt = 0;
        Node temp = head;
        while (head == temp) {
            if (temp.data == 58) {
                numCnt++;
                temp = temp.next;
                head = temp;
            } else break;
        }
        while (temp.next != null) {
            temp = temp.next;
            if (temp.next.data == 58) {
                numCnt++;
                temp.next = temp.next.next;
            }
        }
        return numCnt;
    }

    public int getEvenCount() {
        int evenCnt = 0;
        Node temp = head;
        while (temp.next != null) {
            if (temp.data % 2 == 0) evenCnt++;
            temp = temp.next;
        }
        return evenCnt;
    }

    public void removeOdds() {
        Node temp = head;
        while (head == temp) {
            if (temp.data % 2 == 1) {
                temp = temp.next;
                head = temp;
            } else temp = temp.next;
        }
        while (temp.next != null) {
            if (temp.next.data % 2 == 1) {
                temp.next = temp.next.next;
            } else temp = temp.next;
        }
    }

    public int getSize() {
        int cnt = 0;
        Node temp = head;
        while (temp.next != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}