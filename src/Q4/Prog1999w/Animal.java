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
        return 0;
    }

    public double getIncome() {
        return 0;
    }

    public double getProfit() {
        return 0;
    }

    public String toString() {
        return "";
    }
}
