package Q1;
import DataStructures.DoublyLinkedList;

public class TestDLLListRandom {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < 20; i++)
            list.addSorted((int)(Math.random() * 100)); // TODO: change to addSorted
        list.print();
        list.printReverse();

        // TODO: test the rest of the DLL methods
        list.add(5);
        list.print();
        list.addFront(5);
        list.print();
        list.insert(4, 6);
        list.print();
        list.remove(1);
        list.print();
        System.out.println(list.get(5));
        list.set(4, 7);
        list.print();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
/*
1 8 12 17 22 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95
95 92 91 86 83 77 73 67 63 51 50 44 36 29 24 22 17 12 8 1
1 8 12 17 22 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95 5
5 1 8 12 17 22 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95 5
5 1 8 12 6 22 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95 5
5 8 12 6 22 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95 5
24
5 8 12 6 7 24 29 36 44 50 51 63 67 73 77 83 86 91 92 95 5
22
false
 */