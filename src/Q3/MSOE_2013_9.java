package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2013_9 {
    static class xy {
        public double x;
        public double y;
        public xy(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner c = new Scanner(new File("Langdat/cabs.txt"));
        Scanner p = new Scanner(new File("Langdat/passengers.txt"));
        c.next();
        var cabs = new ArrayList<xy>();
        int cCnt = 0;
        while (c.hasNext()) {
            cabs.add(new xy(Double.parseDouble(c.next()), Double.parseDouble(c.next())));
            cCnt++;
        }
        xy[] passengers = new xy[Integer.parseInt(p.next())];
        int pCnt = 0;
        while (p.hasNext()) {
            passengers[pCnt] = new xy(Double.parseDouble(p.next()), Double.parseDouble(p.next()));
            pCnt++;
        }
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < passengers.length; i++) {
            int maxI = 0;
            double max = Math.abs(passengers[i].x - cabs.get(0).x) + Math.abs(passengers[i].y - cabs.get(0).y);
            for (int j = 1; j < cabs.size(); j++) {
                double abs = Math.abs(passengers[i].x - cabs.get(j).x) + Math.abs(passengers[i].y - cabs.get(j).y);
                if (abs < max) {
                    maxI = j;
                    max = abs;
                }
            }
            System.out.printf("Cabs %d dispatched to passenger %s at city-block distance %.1f\n", maxI, alph.charAt(i), max);
            cabs.remove(maxI);
            cabs.add(maxI, new xy(99999999, 999999));
        }
    }
}
/*
Cabs 2 dispatched to passenger A at city-block distance 8.5
Cabs 0 dispatched to passenger B at city-block distance 6.3
Cabs 9 dispatched to passenger C at city-block distance 31.6
Cabs 6 dispatched to passenger D at city-block distance 30.7
Cabs 7 dispatched to passenger E at city-block distance 17.5
Cabs 3 dispatched to passenger F at city-block distance 94.3
Cabs 8 dispatched to passenger G at city-block distance 101.4
Cabs 1 dispatched to passenger H at city-block distance 11.9
Cabs 4 dispatched to passenger I at city-block distance 91.0
Cabs 5 dispatched to passenger J at city-block distance 172.9
 */