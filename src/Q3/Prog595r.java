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

            System.out("Enter the Sentence: ");

            var words = new ArrayList<String>();
            while (file.hasNext()) {
                words.add(file.next());
            }
            file.close();

            var newSen = new ArrayList<String>();
            for (String s : words) {
                var temp = s.split("[.?!]");
                newSen.addAll(Arrays.asList(temp));
            }
            int numSen = newSen.size();
            var newWords = new ArrayList<String>();
            for (String word : words) {
                var temp = word.split("\\s+");
                newWords.addAll(Arrays.asList(temp));
            }
            newWords.replaceAll(n -> n.replaceAll("[^a-zA-Z]", "").toLowerCase());
            int numWords = newWords.size();
            int diffWords = 3000 - numWords;
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
