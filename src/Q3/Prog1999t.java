package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import DataStructures.Set;
import DataStructures.Dictionary;
import DataStructures.LinkedList;
import DataStructures.BinarySearchTree;
import DataStructures.CircularLinkedList;

record Eel(
        String firstName,
        String lastName,
        int[][] food,
        LinkedList<String> fishEaten
) implements Comparable<Eel> {
    public String getName() { return firstName + " " + lastName; }
    public int compareTo(Eel eel) { return this.fishEaten.size() - eel.fishEaten.size(); }
}

record Bunny (
        String name,
        int soldTo,
        Set<String> customers,
        Dictionary<Integer, String> hats,
        BinarySearchTree<Integer> numbers
) implements Comparable<Bunny> {
    public int compareTo(Bunny bunny) { return this.hats.size() - bunny.hats.size(); }
}

public class Prog1999t {
    public static boolean isNum(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999.txt"));

            int eelCount = Integer.parseInt(file.nextLine());
            var eels = new Eel[eelCount];
            for (int i = 0; i < eelCount; i++) {
                String line = file.nextLine();
                String[] temp = line.split(" ");
                int[][] food = new int[3][5];
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 5; k++)
                        food[j][k] = Integer.parseInt(temp[2 + k + (j*3)]);
                var fishEaten = new LinkedList<String>();
                int cnt = 17;
                var rand = new Random();
                while (!isNum(temp[cnt])) {
                    fishEaten.add(temp[cnt]);
                    cnt++;
                }
                eels[i] = new Eel(temp[0], temp[1], food, fishEaten);
            }

            var bunnies = new CircularLinkedList<Bunny>();
            var uniqCust = new Set<String>();
            String line = file.nextLine();
            while (!Objects.equals(line, "")) {
                String[] temp = line.split(" ");
                var customers = new Set<String>();
                int cnt = Integer.parseInt(temp[1]);
                for (int i = 2; i < cnt+2; i++) {
                    customers.insert(temp[cnt]);
                    uniqCust.insert(temp[cnt]);
                }
                var hats = new Dictionary<Integer, String>();
                for (int i = 2 + cnt + 1; i < temp.length; i+=2) hats.insert(Integer.valueOf(temp[i]), temp[i+1]);
                var numbers = new BinarySearchTree<Integer>();
                var rand = new Random();
                for (int j = 0; j < 100; j++) numbers.insert(rand.nextInt(100000)+1);
                bunnies.add(new Bunny(temp[0], Integer.parseInt(temp[1]), customers, hats, numbers));
                line = file.nextLine();
            }

            /*
            Which eel ate the most fish?
How much did it cost to feed all of the eels on the 2nd Tuesday?
If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?
If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3?
What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?
Did any of the eels eat a fish of the same name?
What day was the most expensive day to feed the eels? Monday, Tuesday, …
             */

            Eel mostFish = eels[0];
            for (int i = 1; i < eelCount; i++)
                if (eels[i].compareTo(mostFish) > 0)
                    mostFish = eels[i];

            int tuesCost = 0;
            int ateMostCount = 0;
            Eel ateMostEel = null;
            int week1mostCost = 0;
            Eel week1mostEel = null;
            int week2mostCost = 0;
            Eel week2mostEel = null;
            int week3mostCost = 0;
            Eel week3mostEel = null;
            LinkedList<String> longestFishes = new LinkedList<>();
            Set<String> diffFood = new Set<>();
            ArrayList<Eel> sameEels = new ArrayList<>();
            int mon = 0;
            int tues = 0;
            int wed = 0;
            int thur = 0;
            int fri = 0;

            for (int i = 0; i < eels.length; i++) {
                int[][] food = eels[i].food();
                LinkedList<String> fishEaten = eels[i].fishEaten();
                tuesCost += food[1][1] * 2;
                int currAte = 0;
                int curr1cost = 0;
                int curr2cost = 0;
                int curr3cost = 0;
                for (int j = 0; j < 3; j++) {
                    mon += food[j][0];
                    tues += food[j][1];
                    wed += food[j][2];
                    thur += food[j][3];
                    fri += food[j][4];
                    for (int k = 0; k < 5; k++) {
                        if (j == 0) {
                            curr1cost += food[j][k];
                        } else if (j == 1) {
                            curr2cost += food[j][k];
                        } else {
                            curr3cost += food[j][k];
                        }
                        currAte += food[j][k];
                    }
                }
                if (currAte > ateMostCount || ateMostEel == null) {
                    ateMostCount = currAte;
                    ateMostEel = eels[i];
                }
                if (curr1cost > week1mostCost || week1mostEel == null) {
                    week1mostCost = curr1cost;
                    week1mostEel = eels[i];
                } else if (curr2cost > week2mostCost || week2mostEel == null) {
                    week2mostCost = curr2cost;
                    week2mostEel = eels[i];
                } else if (curr3cost > week3mostCost || week3mostEel == null) {
                    week3mostCost = curr3cost;
                    week3mostEel = eels[i];
                }
                String tempLong = fishEaten.get(0);
                for (int j = 0; j < fishEaten.size(); j++) {
                    if (tempLong.length() < fishEaten.get(j).length()) fishEaten.get(j);
                }
                boolean why = true;
                for (int j = 0; j < fishEaten.size() && why; j++) {
                    int tempLen = diffFood.size();
                    diffFood.insert(fishEaten.get(j));
                    if (tempLen == diffFood.size()) {
                        sameEels.add(eels[i]);
                        why = false;
                    }
                }
                longestFishes.add(tempLong);
            }

            Eel mostEelCost = week1mostEel;
            if (week2mostCost > week1mostCost && week2mostCost > week3mostCost) mostEelCost = week2mostEel;
            else if (week3mostCost > week1mostCost && week2mostCost < week3mostCost) mostEelCost = week3mostEel;


            System.out.println("Which eel ate the most fish? " + ateMostEel.getName());
            System.out.println("How much did it cost to feed all of the eels on the 2nd Tuesday? " + tuesCost);
            System.out.println("If fish cost 1 on Monday, 2 on Tuesday... all the way to 5 on Friday, which eel costs the most to feed?" + mostEelCost);
            System.out.println("If fish cost 1 on Monday, 2 on Tuesday... all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3? Week 1: " + week1mostEel.getName() + "\tWeek 2: " + week2mostEel.getName() + "\tWeek 3: " + week3mostEel.getName());
            System.out.print("What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?");
            String tempLong = longestFishes.get(0);
            int index = 0;
            for (int i = 0; i < longestFishes.size(); i++) {
                System.out.print(longestFishes.get(i) + " ");
                if (tempLong.length() < longestFishes.get(i).length()) {
                    tempLong = longestFishes.get(i);
                    index = i;
                }
            }
            System.out.println("\n" + eels[index].getName() + " ate the longest fish");
            System.out.println("Did any of the eels eat a fish of the same name?");
            for (int i = 0; i < sameEels.size(); i++) System.out.print(sameEels.get(i).getName() + " ");
            System.out.println("\nWhat day was the most expensive day to feed the eels? Monday, Tuesday...");
            int expDay = Math.max(Math.max(Math.max(Math.max(mon, tues), wed), thur), fri);
            if (expDay == mon) System.out.println("Monday");
            if (expDay == tues) System.out.println("Tuesday");
            if (expDay == wed) System.out.println("Wednesday");
            if (expDay == thur) System.out.println("Thursday");
            if (expDay == fri) System.out.println("Friday");


            /*
            Calculate the total number of unique individuals that the bunnies sold feet to.
Check the numbers in all of the bunny’s trees, total the largest and smallest number of each tree.
Calculate the total number of Magic Hats for all of the bunnies.
Calculate the bunny that has the most letters in all of its magic hats.
Which bunny has the single longest name for its magic hat.
Get rid of the bunny with the fewest number of magic hats.
The bunnies had a big sale but Jill and Pill were the only to show up and buy.  Add Jill to each of the Sets of purchasers and Pill to all of the odd bunnies as a purchaser.
The first bunny just purchased a magic hat with a number of 100 which polymorphs and the last bunny bought a magic hat with a number of 101 which shrinks.
The second bunny lost his second magic hat.
Fred is not allowed to be a customer of any bunny any more.  Delete Fred from the set of purchasers from all of the bunnies.
How many of the bunnies has Pill been a customer?

             */

            System.out.println("Calculate the total number of unique individuals that the bunnies sold feet to.");
            System.out.println(uniqCust.size());
            System.out.println("Check the numbers in all of the bunny’s trees, total the largest and smallest number of each tree.");
            var iter = bunnies.iterator();
            var curr = iter.next();
            var numHats = 0;
            while (curr != null) {
                var tree = curr.numbers();
                var hats = curr.hats();
                numHats += hats.size();
                // most and least num
                curr = iter.next();
            }
            System.out.println("Calculate the total number of Magic Hats for all of the bunnies.");
            System.out.println(numHats);
            System.out.println("Calculate the bunny that has the most letters in all of its magic hats.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
