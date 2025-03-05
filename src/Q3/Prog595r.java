package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prog595r {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/dale-chall-word-list.txt"));
            var input = new Scanner(System.in);

            System.out.print("Enter a sentence to calculate the grade level: ");
            var line = input.nextLine();

            var words = new ArrayList<String>();
            while (file.hasNext()) {
                words.add(file.next());
            }
            file.close();

            var temp = line.split("[.?!]");
            var newSen = new ArrayList<String>(Arrays.asList(temp));
            int numSen = newSen.size();

            var newWords = new ArrayList<String>();
            var temp2 = line.split("\\s+");
            newWords.addAll(Arrays.asList(temp2));
            newWords.replaceAll(n -> n.replaceAll("[^a-zA-Z]", "").toLowerCase());
            int numWords = newWords.size();

            var list = newWords.stream().filter(n -> !words.contains(n)).toList();
            int diffWords = list.size();

            double unfamiliarWords = (double)diffWords/numWords;
            double avgSenLength = numWords / (double) numSen;
            double rawScore = 0.1579*(unfamiliarWords*100) + 0.0496*(avgSenLength);
            if (unfamiliarWords > 0.05) rawScore += 3.6365;

            System.out.print("Raw Score: " + rawScore + "\t\t");
            if (rawScore < 5) System.out.print("Grades K-4");
            else if (rawScore < 6) System.out.print("Grades 5-6");
            else if (rawScore < 7) System.out.print("Grades 7-8");
            else if (rawScore < 8) System.out.print("Grades 9-10");
            else if (rawScore < 9) System.out.print("Grades 11-12");
            else if (rawScore < 10) System.out.print("Grades 13-15 (College)");
            else System.out.print("Grades 16 and above (College Graduate)");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Enter a sentence to calculate the grade level: The quick brown fox jumps over the lazy dog. Many installations require thorough understanding.
Raw Score: 9.622985714285715		Grades 13-15 (College)

Enter a sentence to calculate the grade level: Jonah is a bully who will never be nice in his lifetime. He will always scrutinize the familiarity of warming passions.
Raw Score: 9.420633333333333		Grades 13-15 (College)

Enter a sentence to calculate the grade level: history is nice
Raw Score: 0.1488		Grades K-4

Enter a sentence to calculate the grade level: cats and dog are humiliating the public
Raw Score: 8.495128571428571		Grades 11-12

Enter a sentence to calculate the grade level: skibidi toilet rizz
Raw Score: 14.311966666666665		Grades 16 and above (College Graduate)
 */
