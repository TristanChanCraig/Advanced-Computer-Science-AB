package DataStructures;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class Node implements Comparable<Node> {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public int compareTo(Node o) { return data.compareTo(o.data); }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        var temp = new Node(element);
        if (head == null) head = temp;
        else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void addFront(T element) {
        var temp = new Node(element);
        if (head != null) {
            temp.next = head;
            head.prev = temp;
        }
        head = temp;
        size++;
    }

    public void insert(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0 && head == null) {
            head = new Node(element);
            size++;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            var temp = new Node(element);
            temp.next = current.next.next;
            temp.prev = current;
            current.next = temp;
            size++;
        }
    }

    public void addSorted(T element) {
        // TODO: good luck :)
        var temp = new Node(element);
        if (head == null) {
            head = temp;
            tail = temp;
            size++;
        } else if (size == 1) {
            if (temp.compareTo(head) >= 0) {
                head.next = temp;
                temp.prev = head;
                tail = temp;
            } else {
                head.prev = temp;
                temp.next = head;
                head = temp;
            }
            size++;
        } else {
            for (Node current = head; current != null; current = current.next) {
                if (temp.compareTo(head) <= 0) {
                    head.prev = temp;
                    temp.next = head;
                    head = temp;
                    break;
                }
                if (temp.compareTo(current) <= 0) {
                    Node prevNode = current.prev;
                    prevNode.next = temp;
                    temp.prev = prevNode;
                    current.prev = temp;
                    temp.next = current;
                    break;
                }
                if (current.next == null) {
                    tail.next = temp;
                    temp.prev = tail;
                    tail = temp;
                    break;
                }
            }
            size++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        // TODO: the rest
        Node current = head;
        if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) current = current.next;
            current.next = current.next.next;
            current.next.prev = current;
        }
        size--;
    }

    public void removeWord(String word) {
        Node current = head;
        while (current != null) {
            if (current == head) {
                if (current.data.equals(word)) {
                    head = null;
                    break;
                }
            }
            if (current.next == null) {
                if (current.data.equals(word)) {
                    current.prev.next = null;
                    break;
                }
            }
            if (current.data.equals(word)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.data = element;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next)
            System.out.print(current.data + " ");
        System.out.println();
    }

    public void printReverse() {
        for (Node current = tail; current != null; current = current.prev)
            System.out.print(current.data + " ");
        System.out.println();
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void removeItem(T item) {
        Node current = head;
        while (current != null) {
            if (current == head) {
                if (current.data.equals(item)) {
                    head = null;
                    break;
                }
            }
            if (current.next == null) {
                if (current.data.equals(item)) {
                    current.prev.next = null;
                    break;
                }
            }
            if (current.data.equals(item)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
        size--;
    }

    public T pop() {
        Node current = head;
        while (current.next != null) current = current.next;
        current.prev.next = null;
        size--;
        return current.data;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
