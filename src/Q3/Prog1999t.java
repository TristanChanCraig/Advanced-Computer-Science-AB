package Q3;

import java.io.File;
import java.io.IOException;
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

            int eelCount = file.nextInt();
            var eels = new Eel[eelCount];
            for (int i = 0; i < eelCount; i++) {
                String line = file.nextLine();
                String[] temp = line.split(" ");
                int[][] food = new int[3][5];
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 5; k++)
                        food[j][k] = Integer.parseInt(temp[2 + j + k]);
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
            String line = file.nextLine();
            while (!Objects.equals(line, "")) {
                String[] temp = line.split(" ");
                var customers = new Set<String>();
                int cnt = 2;
                while (!isNum(temp[cnt])) {
                    customers.insert(temp[cnt]);
                    cnt++;
                }
                var hats = new Dictionary<Integer, String>();
                for (int i = cnt; i < temp.length; i+=2) hats.insert(Integer.valueOf(temp[i]), temp[i+1]);
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

            for (int i = 0; i < eels.length; i++) {
                int[][] food = eels[i].food();
                LinkedList<String> fishEaten = eels[i].fishEaten();
                tuesCost += food[1][1] * 2;
                int currAte = 0;
                int curr1cost = 0;
                int curr2cost = 0;
                int curr3cost = 0;
                for (int j = 0; j < 3; j++) {
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
            }

            Eel mostEelCost = week1mostEel;
            if (week2mostCost > week1mostCost && week2mostCost > week3mostCost) mostEelCost = week2mostEel;
            else if (week3mostCost > week1mostCost && week2mostCost < week3mostCost) mostEelCost = week3mostEel;


            System.out.println("Which eel ate the most fish? " + ateMostEel);
            System.out.println("How much did it cost to feed all of the eels on the 2nd Tuesday? " + tuesCost);
            System.out.println("If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?" + mostEelCost);
            System.out.println("If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3? Week 1: " + week1mostEel + "\tWeek 2: " + week2mostEel + "\tWeek 3: " + week3mostEel);
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
