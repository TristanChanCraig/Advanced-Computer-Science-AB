package Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NEWMSOE_2024_9 {
    public static boolean validLoc(int r, int c, String[][] maze) { return (!maze[r][c].equalsIgnoreCase("s")); }

    public static int goofy(String[][] map, int spiders) {
        int cnt = 0;
        while (cnt <= spiders) {

        }
        return cnt;
    }

    public static boolean solvable(String[][] map) {
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Langdat/9a.txt"));
        ArrayList<String> arrlist = new ArrayList<>();
        while (input.hasNext()) {
            arrlist.add(input.nextLine());
        }
        int eR = 0;
        int eC = 0;
        int spiders = 0;
        String[][] map = new String[arrlist.size()][arrlist.get(0).length()];
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) {
            map[i][j] = arrlist.get(i).substring(j, j+1);
            if (map[i][j].equalsIgnoreCase(">")) {
                eR = i;
                eC = j;
            }
            if (map[i][j].equalsIgnoreCase(">")) spiders++;
        }
        System.out.println("The least amount of spiders to get to the food is " + goofy(map, spiders));
    }
}
