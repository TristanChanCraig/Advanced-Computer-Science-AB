package Q2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MSOE_2024_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arrlist = new ArrayList<>();
        String[] numLetters = new String[100];

        String temp = input.nextLine();
        while (temp != "") {
            arrlist.add(temp);
            temp = input.nextLine();
        }

        String key = arrlist.get(0);
        for (int i = 1; i < arrlist.size(); i++) {
            String word = arrlist.get(i);
            for (int j = 0; j < key.length(); j++) {
                boolean inside = word.find(key.substring(j, j+1));
                if ()
            }
        }

    }
}
/*
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
 */