package DataStructures;

@SuppressWarnings("unchecked")
public class CircularQueue<T extends Comparable<T>> {
    protected T[] buffer;
    protected int head;
    protected int tail;
    protected int size;
    protected int capacity;

    public CircularQueue(int c) {
        capacity = c;
        buffer = (T[]) new Comparable[capacity];
        head = tail = size = 0;
    }

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
