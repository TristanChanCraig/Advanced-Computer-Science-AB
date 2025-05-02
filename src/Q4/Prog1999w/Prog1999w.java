package Q4.Prog1999w;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Prog1999w {
    private static LinkedList<Farm> farms;

    public static void initFiveRandomFarms() {
        farms = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            farms.add(new Farm());
        }
    }

    public static void main(String[] args) {
        initFiveRandomFarms();

        int totMilk = 0;
        int turkeyWeights = 0;
        double totalCost = 0;
        ArrayList<Cow> worstCows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var farm = farms.get(i);
            double dailyCost = farm.getHayBales() + farm.getCornCobs() + farm.getBeans() + farm.getOats();
            double dailyIncome = farm.getIncome();
            System.out.printf("Daily income of Farm %d is: %.2f\n", i, dailyIncome);
            double dailyProfit = farm.getProfit();
            System.out.printf("Daily profit of Farm %d is: %.2f\n", i, dailyProfit);
            System.out.printf("Daily cost of Farm %.2f is: ", dailyCost);
            totalCost += dailyCost;
            double totBales = farm.getHayBales() * 2.25;
            double totCobs = farm.getCornCobs() * .19;
            double totBeans = farm.getBeans() * .07;
            double totOats = farm.getOats() * .04;
            totMilk += farm.getMilk();
            var largest = Math.max(Math.max(Math.max(farm.getPigProfit(), farm.getCowProfit()), farm.getHorseProfit()), farm.getTurkeyProfit());
            if (largest == farm.getCowProfit()) System.out.printf("Animal with most profit in Farm %d: Cows\n", i);
            else if (largest == farm.getPigProfit()) System.out.printf("Animal with most profit in Farm %d: Pigs\n", i);
            else if (largest == farm.getHorseProfit()) System.out.printf("Animal with most profit in Farm %d: Horses\n", i);
            else System.out.printf("Animal with most profit in Farm %d: Turkeys\n", i);
            var largest2 = Math.max(Math.max(Math.max(totBales, totCobs), totBeans), totOats);
            if (largest2 == totBales) System.out.printf("Farm %d: Bales\n", i);
            else if (largest2 == totCobs) System.out.printf("Farm %d: Cobs\n", i);
            else if (largest2 == totBeans) System.out.printf("Farm %d: Beans\n", i);
            else System.out.printf("Farm %d: Oats\n", i);
            var animals = farms.get(i).getAllAnimals();
            for (int j = 0; j < animals.size(); j++) {
                var animal = animals.get(j);
                if (animal instanceof Turkey) turkeyWeights += animal.getWeight();
                if (animal instanceof Cow) {
                    if (worstCows.isEmpty()) worstCows.add((Cow) animal);
                    else {
                        if (animal.getProfit() > worstCows.get(0).getProfit()) worstCows.add((Cow) animal);
                        else {
                            for (int k = 0; k < worstCows.size(); k++) {
                                if (animal.getProfit() < worstCows.get(k).getProfit()) {
                                    worstCows.add(k, (Cow) animal);
                                    k--;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The cows from all the farms produced: " + totMilk + " milk");
        System.out.println("The weight of all the turkeys is: " + turkeyWeights);
        // return (2.25 * hayBales) + (.19 * cornCobs) + (.07 * beans) + (.04 * oats);
        System.out.println("The total cost of all the farms is: " + totalCost);
    }
}
