package Q1;
import DataStructures.QueueStack;
import DataStructures.Stack;

public class QueueStackTest {
    public static void main(String[] args) {
        QueueStack<Integer> qs = new QueueStack<>();
        Stack<Integer> q = new Stack<>();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        qs.push(4);
        qs.push(5);

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        System.out.println(qs.peek());
        System.out.println(q.peek());
        System.out.println();

        while (!qs.isEmpty()) System.out.println(qs.pop());
        System.out.println();

        while (!q.isEmpty()) System.out.println(q.pop());
    }
}
