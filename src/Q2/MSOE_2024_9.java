package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MSOE_2024_9 {
    public static int recursion(String[][] map, int r, int c, int spiders, String d, int m) {
        if (m  >= map.length * map[0].length) {
            System.out.println("what");
            return spiders;
        }
        try {
            if (map[r][c].equalsIgnoreCase("f")) {
                return spiders;
            }
            if (map[r][c].equalsIgnoreCase("s")) spiders++;
            int d1 = 0;
            int d2 = 0;
            int d3 = 0;
            int d4 = 0;
            int d5 = 0;
            int d6 = 0;
            int d7 = 0;
//            if (m  >= map.length * map[0].length) {
//                System.out.println("what");
//                return spiders;
//            }
            if (d.equalsIgnoreCase("u")) {
                d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                d3 = recursion(map, r, c + 1, spiders, "r", m+1);
                d4 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("ur")) {
                d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("ul")) {
                 d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c, spiders, "d", m+1);
            } else if (d.equalsIgnoreCase("d")) {
                 d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("dr")) {
                 d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("dl")) {
                 d1 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("r")) {
                 d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r, c + 1, spiders, "r", m+1);
                 d5 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            } else if (d.equalsIgnoreCase("l")) {
                 d1 = recursion(map, r + 1, c + 1, spiders, "ur", m+1);
                 d2 = recursion(map, r + 1, c, spiders, "u", m+1);
                 d3 = recursion(map, r + 1, c - 1, spiders, "ul", m+1);
                 d4 = recursion(map, r - 1, c, spiders, "d", m+1);
                 d5 = recursion(map, r, c - 1, spiders, "l", m+1);
                 d6 = recursion(map, r - 1, c - 1, spiders, "dl", m+1);
                 d7 = recursion(map, r - 1, c + 1, spiders, "dr", m+1);
            }
            if (map[r][c].equalsIgnoreCase(">")) {
                int[] arr = {d1, d2, d3, d4, d5, d6, d7};
                Arrays.sort(arr);
                return arr[0];
            }
        } catch (IndexOutOfBoundsException e) {
            spiders = 9999999;
        }
        return spiders;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Langdat/9a.txt"));
        ArrayList<String> arrlist = new ArrayList<>();
        while (input.hasNext()) {
            arrlist.add(input.nextLine());
        }
        int eR = 0;
        int eC = 0;
        String[][] map = new String[arrlist.size()][arrlist.get(0).length()];
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            map[i][j] = arrlist.get(i).substring(j, j+1);
            if (map[i][j].equalsIgnoreCase(">")) {
                eR = i;
                eC = j;
            }
        }
        System.out.println("The least amount of spiders to get to the food is " + recursion(map, eR, eC, 0, "r", 0));
        /*
        for (String[] r : map) {
            for (String c : r) System.out.print(c + " ");
            System.out.println();
        }
        */
    }
}
