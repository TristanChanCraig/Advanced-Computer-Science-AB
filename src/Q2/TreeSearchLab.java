package Q2;
import DataStructures.BinarySearchTree;

public class TreeSearchLab {
    public static void main(String[] args) {
        // Test set for BFS and DFS
        var tree = new BinarySearchTree<Integer>();
        var rand = new java.util.Random(42);
        for (int i = 0; i < 100; i++) tree.insert(rand.nextInt(100));

        System.out.println("BFS:");
        tree.breadthFirstSearch();

        System.out.println("\nDFS:");
        tree.depthFirstSearch();

        System.out.println("\nPreorder:"); // PREORDER
        tree.printPreorder();

        System.out.println("\nPostorder:");
        tree.printPostorder();
    }
}
