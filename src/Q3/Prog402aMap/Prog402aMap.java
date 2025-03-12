package Q3.Prog402aMap;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prog402aMap {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prg402a.dat"));

            Set<Cl402a> set = new HashSet<>();
            int cnt = 0;
            double avg = 0;

            while (input.hasNext()) {
                int ID = input.nextInt();
                int score = input.nextInt();
                avg += score;
                Cl402a bleh = new Cl402a(ID, score);
                set.add(bleh);
                cnt++;
            }

            avg /= cnt;

            System.out.println("ID\t\tScore\tDiff");
            var iter = set.iterator();
            while (iter.hasNext()) {
                var manwth = iter.next();
                manwth.inputAvg(avg);
                manwth.calc();
                System.out.println(manwth.toString());
            }
            System.out.printf("Average Score = %.2f", avg);

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
ID		Score	Diff
104		239		-3.62
110		238		-4.62
325		246		3.38
123		253		10.38
207		228		-14.62
305		265		22.38
311		256		13.38
115		257		14.38
208		242		-0.62
301		242		-0.62
306		262		19.38
113		243		0.38
213		229		-13.62
116		246		3.38
223		230		-12.62
112		239		-3.62
222		223		-19.62
323		245		2.38
321		245		2.38
218		243		0.38
203		224		-18.62
Average Score = 242.62
 */