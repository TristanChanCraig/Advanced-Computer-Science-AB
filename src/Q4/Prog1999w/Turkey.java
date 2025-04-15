package Q4.Prog1999w;

public class Turkey extends Animal implements Comparable<Turkey> {
    private double value;

    public Turkey(int id, double weight, int cornCobs, int hayBales, int beans, int oats, double value) {
        super(weight, cornCobs, hayBales, beans, oats);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double getIncome() {
        return super.getIncome();
    }

    @Override
    public String toString() {
        return "Turkey{" +
                "value=" + value +
                '}';
    }

    public int compareTo(Turkey turkey) { return (int) (value - turkey.value); }
}
