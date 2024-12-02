package Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2024_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> dimensions = new ArrayList<>();
        

        String temp = input.nextLine();
        while (!temp.equals("")) {
            String[] tempArr = temp.split(" ");
            name.add(tempArr[0]);
            dimensions.add(tempArr[1]);
            temp = input.nextLine();
        }

        
    }
}
