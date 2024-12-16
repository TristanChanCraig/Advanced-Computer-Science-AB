package Q2;
import DataStructures.BinarySearchTree;
import java.util.random.*;

public class BigBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 1; i <= 50; i++) {
            int num = (int)(Math.random() * 99 + 1);
            tree.insert(num);
            System.out.print(num + " ");
        }
        System.out.println("\n");

        tree.printPreorder();
        tree.printInOrder();
        tree.printPostorder();

        System.out.println(tree.size() + "\n");

        System.out.println(tree.search(32) + "\n");

        tree.insert(51);
        tree.insert(102);
        tree.printInOrder();

        double avg = (double)tree.intTotal() / tree.size();
        tree.takeOutClosestHalfAverage(avg);

        System.out.println(tree.height());
        System.out.println();

        System.out.println(tree.width());
        System.out.println();

        tree.invert();
        tree.printInOrder();

        tree.breadthFirstSearch();
        System.out.println();

        tree.depthFirstSearch();
    }
}
