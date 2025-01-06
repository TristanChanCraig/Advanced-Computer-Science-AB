package Q2.Prog1999s;

public class Order implements Comparable<Order>{
    private String n;
    private int q;

    public Order(String name, int qty) {
        n = name;
        q = qty;
    }

    public int getAmt() {
        return q;
    }

    public String getName() {
        return n;
    }

    @Override
    public int compareTo(Order o) {
        return n.compareTo(o.n);
    }
}
