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

        System.out.println("Most profitable animals for each farm");
        for (int i = 0; i < 5; i++) {
            var farm = farms.get(i);
            var largest = Math.max(Math.max(Math.max(farm.getPigProfit(), farm.getCowProfit()), farm.getHorseProfit()), farm.getTurkeyProfit());
            if (largest == farm.getCowProfit()) System.out.printf("Farm %d: Cows\n", i);
            else if (largest == farm.getPigProfit()) System.out.printf("Farm %d: Pigs\n", i);
            else if (largest == farm.getHorseProfit()) System.out.printf("Farm %d: Horses\n", i);
            else System.out.printf("Farm %d: Turkeys\n", i);
        }
        System.out.println("Farm ");
    }
}
