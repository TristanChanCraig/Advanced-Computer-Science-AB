package Q4.Prog1999w;

public class Turkey extends Animal implements Comparable<Turkey> {
    private double value;

    public Turkey(int id, int weight, int cornCobs, int oats, double value) {
        super(weight, cornCobs, 0, 0, oats);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double getIncome() { return value * weight; }

    @Override
    public String toString() {
        return "Turkey{" +
                "value=" + value +
                '}';
    }

    public int compareTo(Turkey turkey) { return (int) (value - turkey.value); }
}
