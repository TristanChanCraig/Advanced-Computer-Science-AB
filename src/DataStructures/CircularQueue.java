package DataStructures;

public class CircularQueue<T extends Comparable<T>> extends Queue<T> {
    private T[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public void enqueue(T element) {
        if (isFull()) System.out.print("Queue Full");
        else {
            buffer[tail] = element;
            tail = (tail + 1) % capacity;
            size++;
        }
    }
    public T dequeue() {
        var temp = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return temp;
    }
    public boolean isFull() { return size == capacity; }
    public boolean isEmpty() { return size == 0;  }
    public T peek() { return buffer[head]; }
}
