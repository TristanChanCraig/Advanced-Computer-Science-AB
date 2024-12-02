package Q2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Algorithms.SortingAlgorithms;

public class MSOE_2024_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arrlist = new ArrayList<>();
        String[] numLetters = new String[100];

        String temp = input.nextLine();
        while (!temp.equals("")) {
            arrlist.add(temp);
            temp = input.nextLine();
        }
// a in b
        String regex = arrlist.get(0).replaceAll("(?<=.)(?=.)", "+?");
        Pattern p = Pattern.compile(regex);
        for (int i = 1; i < arrlist.size(); i++) {
            Matcher m = p.matcher(arrlist.get(i));
            boolean mFound = m.find();
            if (mFound) {
                arrlist.remove(i);
                i--;
            }
        }
// b in a
        for (int i = 1; i < arrlist.size(); i++) {
            String regex2 = arrlist.get(i).replaceAll("(?<=.)(?=.)", "+?");
            Pattern p2 = Pattern.compile(regex2);
            Matcher m2 = p2.matcher(arrlist.get(0));
            boolean mFound2 = m2.find();
            if (mFound2) {
                arrlist.remove(i);
                i--;
            }
        }

        //for (var w : arrlist) System.out.println(w);

        String key = arrlist.get(0);
        for (int i = 1; i < arrlist.size(); i++) {
            String word = arrlist.get(i);
            String t = word;
            for (int j = 0; j < key.length(); j++) {
                for (int k = j + 1; k < key.length() + 1; k++) {
                    var w = key.substring(j, k);
                    if (word.contains(w)) {
                        int index = w.length() - 1;
                        if (numLetters[index] == null) numLetters[index] = word;
                        else numLetters[index] = numLetters[index] + " " + word;
                    }
                }
            }
        }



        int highest = 0;
        for (int i = numLetters.length-1; i >= 0; i--) {
            if (numLetters[i] != null) {
                highest = i;
                break;
            }
        }

        if (highest == 0) {
            System.out.print("No embeddings found!");
        } else {
            String[] words = numLetters[highest].split(" ");
            SortingAlgorithms.quickSort(words);
            for (var word : words) System.out.println(word);
        }
    }
}
/*-
grand
are
bandersnatch
bangle
branch
breakfast
grandfather
great
hand
plant

bandersnatch
branch
hand
 */