package Q4.Prog1999w;

public class Cow extends Animal implements Comparable<Cow> {
    private int milk;
    private double milkPrice;

    public Cow(int id, double weight, int cornCobs, int hayBales, int beans, int oats, int milk, double milkPrice) {
        super(weight, cornCobs, hayBales, beans, oats);
        this.milk = milk;
        this.milkPrice = milkPrice;
    }

    public int getMilk() {
        return milk;
    }

    @Override
    public double getIncome() {
        return milk * milkPrice;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "milk=" + milk +
                ", milkPrice=" + milkPrice +
                '}';
    }

    public int compareTo(Cow cow) { return (int) (getProfit() - cow.getProfit()); } // idk
}
