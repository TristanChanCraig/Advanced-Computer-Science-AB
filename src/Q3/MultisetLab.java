package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DataStructures.Bag;
import Algorithms.SortingAlgorithms;

public class MultisetLab {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/words"));
            var bag = new Bag<String>();
            var rand = new java.util.Random(42);

            while (file.hasNext()) {
                String word = file.next().toLowerCase();
                for (int i = 0; i < rand.nextInt(1, 11); i++) bag.insert(word);
            }
            file.close();

            bag.enumerate();
            // TODO: display top 10 most common words, use additional DSAs as needed
            var set = bag.getSet();
            var iter = bag.iterator();
            int[] nums = new int[10];
            String[] strs = new String[10];
            while (iter.hasNext()) {
                var word = iter.next();
                var count = bag.count(word);
                int index = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (index != -1) {
                        if (nums[i] < count && nums[index] > nums[i]) index = i;
                    }
                    else {
                        if (nums[i] < count) index = i;
                    }
                }
                if (index != -1) {
                    strs[index] = word;
                    nums[index] = count;
                }
            }

            System.out.println("Most Common Words:");
            for (int i = 0; i < 10; i++) System.out.println(strs[i] + " " + nums[i]);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
{
	awesomest(4)
	mr(3)
	est(4)
	knows(4)
	is(9)
	ist(9)
	getka(5)
	got(1)
	wowsa(4)
	smack(2)
	kingest(1)
	whats(4)
	dancing(4)
	the(32)
	dudest(4)
	guns(7)
	and(3)
	class(4)
	daddiest(3)
	up(2)
	coolest(2)
	he(6)
	this(4)
}
Most Common Words:
guns 7
the 32
he 6
knows 4
is 9
ist 9
getka 5
whats 4
wowsa 4
dancing 4
 */