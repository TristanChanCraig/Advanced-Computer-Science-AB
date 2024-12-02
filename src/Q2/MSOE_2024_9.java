package Q2;

import java.util.Scanner;

public class MSOE_2024_9 {
    public int recursion(String[][] map, int r, int c, int spiders) {
        if (map[r][c].equalsIgnoreCase("f")) return spiders;
        if (map[r][c].equalsIgnoreCase("s")) spiders++;
        try {
            int d1 = recursion(map, r - 1, c - 1, spiders);
            int d2 = recursion(map, r - 1, c - 1, spiders);
            int d3 = recursion(map, r - 1, c - 1, spiders);
            int d4 = recursion(map, r - 1, c - 1, spiders);
            int d5 = recursion(map, r - 1, c - 1, spiders);
            int d6 = recursion(map, r - 1, c - 1, spiders);
            int d7 = recursion(map, r - 1, c - 1, spiders);
            int d8 = recursion(map, r - 1, c - 1, spiders);
            int d9 = recursion(map, r - 1, c - 1, spiders);
        } catch (IndexOutOfBoundsException e) {
            return 99999;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] map = new String[30][30];
        String temp = input.nextLine();
        int cnt = 0;
        int eR;
        int eC;
        while (!temp.equals("")) {
            for (int i = 0; i < temp.length(); i++) {
                map[cnt][i] = temp.substring(i, i+1);
                if (map[cnt][i].equalsIgnoreCase(">")) {
                    eR = cnt;
                    eC = i;
                }
            }
            temp = input.nextLine();
            cnt++;
        }
    }
}
