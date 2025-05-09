package Q4.Prog1999w;

public class Pig extends Animal {
    private double value;

    public Pig(double weight, int cornCobs, int beans, int oats, double value) {
        super(weight, cornCobs, 0, beans, oats);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double getIncome() {
        return weight * value;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "value=" + value +
                '}';
    }

    public int compareTo(Pig pig) { return (int) (value - pig.getValue()); }
}
