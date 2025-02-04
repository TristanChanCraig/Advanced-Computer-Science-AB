package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSOE_2013_9 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner c = new Scanner(new File("Langdat/cabs.txt"));
        Scanner p = new Scanner(new File("Langdat/passengers.txt"));
        double[] cabs = new double[Integer.parseInt(c.next())];
        int cCnt = 0;
        while (c.hasNext()) {
            cabs[cCnt] = Double.parseDouble(c.next()) + Double.parseDouble(c.next());
            cCnt++;
        }
        double[] passengers = new double[Integer.parseInt(p.next())];
        int pCnt = 0;
        while (p.hasNext()) {
            passengers[pCnt] = Double.parseDouble(p.next()) + Double.parseDouble(p.next());
            pCnt++;
        }
        for (int i = 0; i < passengers.length; i++) {

        }
    }
}
