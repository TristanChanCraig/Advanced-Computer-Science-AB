import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

            Eel mostFish = eels[0];
            for (int i = 1; i < eelCount; i++) {
                if (Eel[i] > mostFish)
                    mostFish = Eel[i];
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
