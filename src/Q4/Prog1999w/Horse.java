package Q4.Prog1999w;

public class Horse extends Animal implements Comparable<Horse> {
    private String name;
    private double riderCost;
    private int[][] numRiders;

    public Horse(String name, double riderCost, double weight, int cornCobs, int hayBales, int beans, int oats, int[][] numRiders) {
        super(weight, cornCobs, hayBales, beans, oats);
        this.name = name;
        this.riderCost = riderCost;
        this.numRiders = numRiders;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getIncome() {
        int income = 0;
        for (int[] row : numRiders) for (int riders : row) income += riders * riderCost;
        return income;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", riderCost=" + riderCost +
                ", numRiders=" + numRiders +
                '}';
    }

    public int compareTo(Horse horse) { return Double.compare(getProfit(), horse.getProfit()); } // idk
}
