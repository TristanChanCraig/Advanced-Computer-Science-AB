package Q4.Prog1999w;

public abstract class Animal implements IFarm {
    protected double weight;
    protected int id;
    protected int cornCobs;
    protected int hayBales;
    protected int beans;
    protected int oats;

    public Animal(double weight, int cornCobs, int hayBales, int beans, int oats) {
        this.weight = weight;
        this.cornCobs = cornCobs;
        this.hayBales = hayBales;
        this.beans = beans;
        this.oats = oats;
    }

    public int getId() {
        return id;
    }
    public double getWeight() {
        return weight;
    }

    public int getCornCobs() {
        return cornCobs;
    }

    public int getHayBales() {
        return hayBales;
    }

    public int getBeans() {
        return beans;
    }

    public int getOats() {
        return oats;
    }

    public double getCost() {
        return (2.25 * hayBales) + (.19 * cornCobs) + (.07 * beans) + (.04 * oats);
    }

    public abstract double getIncome();

    public double getProfit() { return getIncome() - getCost(); }

    public String toString() {
        return "";
    }
}
