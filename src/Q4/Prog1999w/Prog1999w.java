package Q4.Prog1999w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import Algorithms.SortingAlgorithms.*;

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
        double[] turkeyProfit = new double[5];
        double[] pigProfit = new double[5];
        double weights = 0;
        for (int i = 0; i < 5; i++) {
            var farm = farms.get(i);
            double dailyCost = farm.getHayBales() + farm.getCornCobs() + farm.getBeans() + farm.getOats();
            double dailyIncome = farm.getIncome();
            System.out.printf("Daily income of Farm %d is: %.2f\n", i, dailyIncome);
            double dailyProfit = farm.getProfit();
            System.out.printf("Daily profit of Farm %d is: %.2f\n", i, dailyProfit);
            System.out.printf("Daily cost of Farm %d is: %.2f\n", i, dailyCost);
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
                if (animal != null) weights += animal.getWeight();
                if (animal instanceof Turkey) turkeyWeights += animal.getWeight();
                if (animal instanceof Cow) {
                    if (worstCows.isEmpty()) worstCows.add((Cow) animal);
                    else {
                        boolean added = false;
                        for (int k = 0; k < worstCows.size(); k++) {
                            if (animal.getProfit() < worstCows.get(k).getProfit()) {
                                worstCows.add(k, (Cow) animal);
                                added = true;
                                break;
                            }
                        }
                        if (!added) worstCows.add((Cow) animal);
                    }
                }
            }
            for (int j = 0; j < animals.size(); j++) {
                var animal = animals.get(j);
                for (int k = 0; k < worstCows.size(); k++) {
                    if (animal instanceof Cow && animal.getId() == worstCows.get(k).getId()) {
                        farm.removeCow(animal.getId());
                    }
                }
            }
            pigProfit[i] = farm.getPigProfit();
            turkeyProfit[i] = farm.getTurkeyProfit();
        }
        double[] temp = Arrays.copyOf(pigProfit, 5);
        for (int i = 0; i < temp.length-1; i++)
            for (int j = 0; j < temp.length - i - 1; j++)
                if (temp[j] > temp[j+1]) {
                    double t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }

        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 5; i++)
                if (temp[j] == pigProfit[i]) farms.get(i).removePigs();

        temp = Arrays.copyOf(turkeyProfit, 5);
        for (int i = 0; i < temp.length-1; i++)
            for (int j = 0; j < temp.length - i - 1; j++)
                if (temp[j] > temp[j+1]) {
                    double t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }


            for (int i = 0; i < 5; i++)
                if (temp[0] == turkeyProfit[i]) {
                    farms.get(i).removeHalfTurkeys();
                }


        System.out.println("The cows from all the farms produced: " + totMilk + " milk");
        System.out.println("The weight of all the turkeys is: " + turkeyWeights);
        // return (2.25 * hayBales) + (.19 * cornCobs) + (.07 * beans) + (.04 * oats);
        System.out.println("The total cost of all the farms is: " + totalCost);
        System.out.println("The total weight of all the animals is: " + weights);
    }
}
/*
Daily income of Farm 0 is: 13585.73
Daily profit of Farm 0 is: 13435.30
Daily cost of Farm 0 is: 16861.00
Animal with most profit in Farm 0: Pigs
Farm 0: Bales
Daily income of Farm 1 is: 13702.95
Daily profit of Farm 1 is: 13552.24
Daily cost of Farm 1 is: 20028.00
Animal with most profit in Farm 1: Pigs
Farm 1: Bales
Daily income of Farm 2 is: 17885.92
Daily profit of Farm 2 is: 17710.50
Daily cost of Farm 2 is: 18525.00
Animal with most profit in Farm 2: Pigs
Farm 2: Bales
Daily income of Farm 3 is: 14665.33
Daily profit of Farm 3 is: 14509.91
Daily cost of Farm 3 is: 17927.00
Animal with most profit in Farm 3: Pigs
Farm 3: Bales
Daily income of Farm 4 is: 15960.76
Daily profit of Farm 4 is: 15811.83
Daily cost of Farm 4 is: 18071.00
Animal with most profit in Farm 4: Pigs
Farm 4: Bales
The cows from all the farms produced: 3541 milk
The weight of all the turkeys is: 1983
The total cost of all the farms is: 91412.0
The total weight of all the animals is: 94699.0

 */