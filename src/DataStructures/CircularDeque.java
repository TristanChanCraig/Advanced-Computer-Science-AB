package DataStructures;

public class CircularDeque<T extends Comparable<T>> extends CircularQueue<T> {
    public CircularDeque(int c) {
        super(c);
    }

    public void enqueueLast(T element) {
        enqueue(element);
    }

    public void enqueueFirst(T element) {
        head = (head  - 1 + capacity) % capacity;
        buffer[head] = element;
        size++;
    }

    public T dequeueLast() {
        tail = (tail  - 1 + capacity) % capacity;
        T element = buffer[tail];
        size--;
        return element;
    }

    public T dequeueFirst() {
        return dequeue();
    }
}
