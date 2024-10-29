package DataStructures;

public class QueueStack<T extends Comparable<T>> {
    private final Queue<T> stack;

    public QueueStack()    { stack = new Queue<>(); }

    public void push(T element) { stack.enqueue(element); }
    public T pop()              { return stack.dequeue(); }
    public T peek()             { return stack.peek(); }
    public int size()           { return stack.size(); }
    public boolean isEmpty()    { return stack.isEmpty(); }
}
