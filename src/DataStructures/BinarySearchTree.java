package DataStructures;

public class BinarySearchTree<T extends Comparable<T>> {
    protected class Node implements Comparable<Node> {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public int compareTo(Node o) { return data.compareTo(o.data); }
    }

    protected Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private Node insert(Node node, T element) {
        if (node == null) return new Node(element);
        if (element.compareTo(node.data) < 0)
            node.left = insert(node.left, element);
        else if (element.compareTo(node.data) > 0)
            node.right = insert(node.right, element);
        return node;
    }

    public void delete(T element) {
        root = delete(root, element);
    }

    private Node delete(Node node, T element) {
        if (node == null) return null;
        if (element.compareTo(node.data) < 0) node.left = delete(node.left, element);
        else if (element.compareTo(node.data) > 0) node.right = delete(node.right, element);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    public T getRootData() { return root.data; }

    public boolean search(T element) { return search(root, element); }

    private boolean search(Node node, T element) {
        if (node == null) return false;
        if (element.compareTo(node.data) < 0) return search(node.left, element);
        else if (element.compareTo(node.data) > 0) return search(node.right, element);
        return true;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    public void printInOrder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public void printPreorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void printPostorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public int size() {
        return totalNodes(root);
    }

    private int totalNodes(Node node) {
        if (node == null) return 0;
        int l = totalNodes(node.left);
        int r = totalNodes(node.right);
        return 1 + l + r;
    }

    public int intTotal() {
        return getIntTotal(root);
    }

    private int getIntTotal(Node node) {
        if (node == null) return 0;
        return (Integer)node.data + getIntTotal(node.left) + getIntTotal(node.right);
    }

    public void invert() { root = invert(root); }
    public int height() { return height(root); }
    public int width() { return width(root); }

    private Node invert(Node node) {
        if (node == null) return null;
        Node left = invert(node.left);
        node.left = invert(node.right);
        node.right = left;
        return node;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int width(Node node) {
        if (node == null) return 0;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(node);
        int max = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            max = Math.max(max, count);
            while (count --> 0) {
                Node current = queue.dequeue();
                if (current.left != null) queue.enqueue(current.left);
                if (current.right != null) queue.enqueue(current.right);
            }
        }
        return max;
    }

    public void takeOutClosestHalfAverage(double avg) {
        T goofy = (T)takeOutClosestHalfAverage(avg, root);
        delete(goofy);
        System.out.println("Removed = " + goofy);
    }

    private Integer takeOutClosestHalfAverage(double avg, Node node) {
        if (node == null) return 99999999;
        double half = avg / 2;
        double first = Math.abs(((Integer)node.data - half));
        double second = takeOutClosestHalfAverage(avg, node.right);
        double third = takeOutClosestHalfAverage(avg, node.right);
        int close = 0;
        if (first < second) {
            if (first < third) close = (Integer)node.data;
            else close = (int)Math.round(second); // node . right
        } else {
            if (second < third) close = (int)Math.round(second);
            else close = (int)Math.round(third); // node . left
        }
        return close;
    }

    public void breadthFirstSearch() {
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.data + " ");
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
        System.out.println();
    }

    public void depthFirstSearch() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        System.out.println();
    }

    // Prog1999s
    public Node getRoot() {
        return root;
    }

    public Node getLeft(Node node) {
        return node.left;
    }

    public Node getRight(Node node) {
        return node.right;
    }

    public T getData(Node node) {
        return node.data;
    }

    public T findString(String s) {
        var node = root;
        var queue = new Queue<Node>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            var cnt = queue.size();
            while (cnt --> 0) {
                var curr = queue.dequeue();
                if (s.compareTo(String.valueOf(curr.data)) == 0) node = curr;
                if (curr.left != null) queue.enqueue(curr.left);
                if (curr.right != null) queue.enqueue(curr.right);
            }
        }
        return node.data;
    }

    public T getElement(T element) {
        return getElement(root, element);
    }

    private T getElement(Node node, T element) {
        if (node == null) return null;
        if (element.compareTo(node.data) < 0)
            return getElement(node.left, element);
        else if (element.compareTo(node.data) > 0)
            return getElement(node.right, element);
        else
            return node.data;
    }

    public Integer max(Node node) {
        int max = (Integer)node.data;
        if(node.left != null) {
            max = Math.max(max, max(node.left));
        }
        if(node.right != null) {
            max = Math.max(max, max(node.right));
        }
        return max;
    }

}
