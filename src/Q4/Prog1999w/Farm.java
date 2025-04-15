package Q4.Prog1999w;

import DataStructures.*;
import java.util.Random

public class Farm {
    private static Random rand;
    private double milkPrice;
    private int beans;
    private int oats;
    private int[][] riders;
    private Stack<Integer> cornCobs;
    private Queue<Integer> hayBales;
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
        hayBales = new CircularLinkedList<>();
        pigs = new Pig[500];
    }

    public void addCow(Cow cow) { cows.insert(cow.getId(), cow); }
    public void addTurkey(Turkey turkey) { turkeys.insert(turkey); }
    public void addHorse(Horse horse) { horses.add(horse); }
    public void addPig(Pig pig) { pigs[pig.getId()] = pig; }
    public void stockCorn() { }
}
