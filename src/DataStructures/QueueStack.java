package DataStructures;

import java.util.ArrayList;

public class QueueStack<T extends Comparable<T>> {
    private Queue<T> stack;

    public QueueStack()    { stack = new Queue<>(); }

    public void push(T element) { stack.enqueue(element); }
    public T pop() {
        var temp = new ArrayList<T>();
        while (!stack.isEmpty()) temp.add(stack.dequeue());
        var popped = temp.remove(temp.size()-1);
        for (int lcv = temp.size()-1; lcv >= 0; lcv--) stack.enqueue(temp.remove(lcv));
        return popped;
    }
    public T peek() {
        var temp = new ArrayList<T>();
        while (!stack.isEmpty()) temp.add(stack.dequeue());
        var popped = temp.remove(temp.size()-1);
        for (int lcv = temp.size()-1; lcv > 0; lcv--) stack.enqueue(temp.remove(lcv));
        stack.enqueue(popped);
        return popped;
    }
    public boolean isEmpty()    { return stack.isEmpty(); }
}
// First-In Last-Out

/*
var temp = new Queue<T>();
        while (!stack.isEmpty()) {
            T jeff = stack.dequeue();
            if (!stack.isEmpty()) {
                temp.enqueue(jeff);
            }
        }
        stack = temp;

        T removed = stack.dequeue();
        var temp2 = new Queue<T>();

        while (!stack.isEmpty()) {
            T jeff = stack.dequeue();
            if (!stack.isEmpty()) {
                temp2.enqueue(jeff);
            }
        }
        stack = temp2;

        return removed;
 */