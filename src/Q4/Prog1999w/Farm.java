package Q4.Prog1999w;

import DataStructures.*;

import java.util.ArrayList;
import java.util.Random;

public class Farm {
    static class CornCob implements Comparable<CornCob> {
        public int cobs;
        CornCob(int cobs) {
            this.cobs = cobs;
        }

        public int compareTo(CornCob o) {
            return cobs - o.cobs;
        }
    }

    static class HayBale implements Comparable<HayBale> {
        public int bales;
        HayBale(int bales) {
            this.bales = bales;
        }

        public int compareTo(HayBale o) {
            return bales - o.bales;
        }
    }

    private static Random rand;
    private double milkPrice;
    private int beans;
    private int oats;
    private int[][] riders;
    private Stack<CornCob> cornCobs;
    private Queue<HayBale> hayBales;
    private Dictionary<Integer, Cow> cows;
    private Set<Turkey> turkeys;
    private CircularLinkedList<Horse> horses;
    private Pig[] pigs;

    public Farm() {
        rand = new Random();
        cornCobs = new Stack<>();
        hayBales = new Queue<>();
        cows = new Dictionary<>();
        turkeys = new Set<>();
        horses = new CircularLinkedList<>();
        pigs = new Pig[500];
    }

    public void addCow(Cow cow) { cows.insert(cow.getId(), cow); }
    public void addTurkey(Turkey turkey) { turkeys.insert(turkey); }
    public void addHorse(Horse horse) { horses.add(horse); }
    public void addPig(Pig pig) { pigs[pig.getId()] = pig; }
    public int stockCorn() {
        var corn = rand.nextInt(1000, 1250);
        cornCobs.push(new CornCob(corn));
        return corn;
    }
    public int stockHay() {
        var bale = rand.nextInt(1000, 1250);
        hayBales.enqueue(new HayBale(bale));
        return bale;
    }
    public void addCornCob() { }
    public void addHayBale() { }
    public void removeCornCob() { cornCobs.pop(); }
    public void removeHayBale() { hayBales.dequeue(); }
    public int getCornCobs() {
        var temp = new Stack<CornCob>();
        int cnt = 0;
        while (!cornCobs.isEmpty()) {
            CornCob cornCob = cornCobs.pop();
            cnt += cornCob.cobs;
            temp.push(cornCob);
        }
        cornCobs = temp;
        return cnt;
    }
    public int getHayBales() {
        var temp = new Queue<HayBale>();
        int cnt = 0;
        while (!hayBales.isEmpty()) {
            HayBale hayBale = hayBales.dequeue();
            cnt += hayBale.bales;
            temp.enqueue(hayBale);
        }
        hayBales = temp;
        return cnt;
    }
    public int getBeans() { return beans; }
    public int getOats() { return oats; }
    public double getMilkPrice() { return milkPrice; }
    public int getNumHorseRiders() {
        int cnt = 0;
        for (int[] e : riders)
            for (int rider : e)
                cnt += rider;
        return cnt;
    }
    public double getCost() {
        for (int i = 0; i < cows.size(); i++) {

        }
    }
    public double getIncome() {

    }
    public double getProfit() {

    }
    public ArrayList<> getAllAnimals() {

    }
    public int compareTo(Farm f) {}

}
