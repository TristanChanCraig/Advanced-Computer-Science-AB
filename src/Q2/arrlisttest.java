package Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class arrlisttest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hi: ");
        String line = input.nextLine();
        ArrayList<String> arr = new ArrayList<>();
        arr.add(2, line);
        for (var e : arr) System.out.print(e + " ");
    }
}
