package Q2;
import DataStructures.BinarySearchTree;

public class BigBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 1; i <= 100; i++) {
            tree.insert(i);
            System.out.print(i + " ");
        }
        System.out.println("\n");

        tree.printPreorder();
        tree.printInOrder();
        tree.printPostorder();

        System.out.println(tree.size() + "\n");

        System.out.println(tree.search(32) + "\n");
    }
}
