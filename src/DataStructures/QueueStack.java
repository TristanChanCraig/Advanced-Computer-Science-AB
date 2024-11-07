package DataStructures;

import java.util.ArrayList;

public class QueueStack<T extends Comparable<T>> {
    private Queue<T> stack;

    public QueueStack()    { stack = new Queue<>(); }

    public void push(T element) {
        stack.enqueue(element);
        for (int i = 1 ; i < stack.size() ; i++) stack.enqueue(stack.dequeue());
    }
    public T pop() {
        return stack.dequeue();
    }
    public T peek() {
        return stack.peek();
    }
    public boolean isEmpty()    { return stack.isEmpty(); }

    public int size() {return stack.size();}
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
/*
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
        var peeked = temp.get(temp.size()-1);
        for (int lcv = temp.size()-1; lcv > 0; lcv--) stack.enqueue(temp.remove(lcv));
        return peeked;
    }
 */