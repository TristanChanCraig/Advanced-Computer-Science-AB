package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MSOE_2024_9 {
    public static int recursion(String[][] map, int r, int c, int spiders) {
        try {
            if (map[r][c].equalsIgnoreCase("f")) return spiders;
            if (map[r][c].equalsIgnoreCase("s")) spiders++;
            int d1 = recursion(map, r, c + 1, spiders);
            int d2 = recursion(map, r + 1, c, spiders);
            int d3 = recursion(map, r + 1, c + 1, spiders);
            int d3 = recursion(map, r + 1, c + 1, spiders);
            int[] arr = {d2, d3, d5, d7, d8};
            Arrays.sort(arr);
            return arr[0];
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return 99999;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Langdat/9a.txt"));
        ArrayList<String> arrlist = new ArrayList<>();
        while (input.hasNext()) {
            arrlist.add(input.nextLine());
        }
        String[][] map = new String[arrlist.size()][arrlist.get(0).length()];
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) map[i][j] = arrlist.get(i).substring(j, j+1);
        System.out.println("The least amount of spiders to get to the food is " + recursion(map, 0, 0, 0));
        /*
        for (String[] r : map) {
            for (String c : r) System.out.print(c + " ");
            System.out.println();
        }
        */
    }
}
