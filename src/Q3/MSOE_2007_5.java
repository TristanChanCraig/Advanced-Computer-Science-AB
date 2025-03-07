package Q3;

import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2007_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("String: ");
        String str = input.nextLine();

        ArrayList<String> letters = new ArrayList<>();
        int highCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            int currIndex = -1;
            int currCnt = 1;
            for (int j = i; j < str.length()-1; j++) {
                currIndex = j;
                String curr = str.substring(j, j+1);
                if (curr.equalsIgnoreCase(str.substring(j+1,j+2))) { currCnt++;
                } else break;
            }
            if (currCnt == highCnt) { letters.add(str.substring(currIndex, currIndex+1));
            } else if (currCnt > highCnt){
                letters.clear();
                letters.add(str.substring(currIndex, currIndex+1));
                highCnt = currCnt;
            }
        }

        System.out.print(highCnt);
        for (String letter : letters) System.out.print(" " + letter);
    }
}
/*
String: ABCDDEFGGHABC
2 D G

String: TTHTHTTTTHHHTHTTTTH
4 T T
 */