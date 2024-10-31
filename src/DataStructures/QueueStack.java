package DataStructures;

public class QueueStack<T extends Comparable<T>> {
    private final Queue<T> stack;

    public QueueStack()    { stack = new Queue<>(); }

    public void push(T element) { stack.enqueue(element); }
    public T pop()              {
        var temp = new Queue<T>();
        while (int lcv = 0; lcv < stack.size() - 1; lcv++) temp.enqueue(stack.dequeue());
        return temp;
    }
    public T peek()             { return stack.peek(); }
    public int size()           { return stack.size(); }
    public boolean isEmpty()    { return stack.isEmpty(); }
}
// First-In Last-Out or Last-In First-Out