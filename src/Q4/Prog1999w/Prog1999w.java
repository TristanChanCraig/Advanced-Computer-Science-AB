package Q4.Prog1999w;

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
        int totBales = 0;
        int totCobs = 0;
        int totBeans = 0;
        int totOats;
        System.out.println("Most profitable animals for each farm");
        for (int i = 0; i < 5; i++) {
            var farm = farms.get(i);
            totBales += farm.getHayBales();
            totCobs = farm.getCornCobs();
            totBeans = farm.getBeans();
            totOats = farm.getOats();
            totMilk += farm.getMilk();
            var largest = Math.max(Math.max(Math.max(farm.getPigProfit(), farm.getCowProfit()), farm.getHorseProfit()), farm.getTurkeyProfit());
            if (largest == farm.getCowProfit()) System.out.printf("Farm %d: Cows\n", i);
            else if (largest == farm.getPigProfit()) System.out.printf("Farm %d: Pigs\n", i);
            else if (largest == farm.getHorseProfit()) System.out.printf("Farm %d: Horses\n", i);
            else System.out.printf("Farm %d: Turkeys\n", i);
            var animals = farms.get(i).getAllAnimals();
            for (int j = 0; j < animals.size(); j++) {
                var animal = animals.get(j);
                if (animal instanceof Turkey) turkeyWeights += animal.getWeight();
            }
        }
        System.out.println("The cows from all the farms produced: " + totMilk + " milk");
        System.out.println("The weight of all the turkeys is: " + turkeyWeights);
        // return (2.25 * hayBales) + (.19 * cornCobs) + (.07 * beans) + (.04 * oats);
    }
}
