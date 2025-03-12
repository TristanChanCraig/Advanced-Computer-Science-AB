package Q3.Prog215hMap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prog215hMap {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog215h.txt"));

            Map<Integer, Cl215h> map = new HashMap<>();

            int ppl = 0;
            while (input.hasNext()) {
                ArrayList<Double> gah = new ArrayList<Double>();
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());
                gah.add(input.nextDouble());

                Cl215h meep = new Cl215h(gah);
                map.put(ppl, meep);
                meep.calc();
                ppl++;
            }

            for (int lcv = 0; lcv < map.size(); lcv++) {
                Cl215h eck = map.get(lcv);
                eck.setCnt(lcv+1);
                System.out.println(eck.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
Contestant 1
8.4 8.4 8.5 8.7 8.8 9.1 9.1 9.1 = 8.77

Contestant 2
7.0 7.0 7.0 7.0 7.0 7.0 7.0 7.0 = 7.00

Contestant 3
7.9 8.0 8.0 8.0 8.0 8.0 8.0 8.1 = 8.00

Contestant 4
6.1 6.2 7.1 7.2 8.1 8.1 8.2 8.2 = 7.48

Contestant 5
6.3 7.2 7.3 7.5 7.7 7.8 8.8 9.2 = 7.72

Contestant 6
6.3 6.7 6.8 6.9 7.3 7.7 7.9 8.8 = 7.22
 */