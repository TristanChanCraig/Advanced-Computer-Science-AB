package Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MSOE_2024_7 {
    static class Box {
        private String n;
        private double l;
        private double w;
        private double h;
        private double s;
        public Box(String name, double length, double width, double height, double size) {
            n = name;
            l = length;
            w = width;
            h = height;
            s = size;
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Box> boxes = new ArrayList<>();
        

        String temp = input.nextLine();
        while (!temp.equals("")) {
            String[] tempArr = temp.split(" ");
            double[] tempArr2 = Arrays.stream(tempArr[1].split("x")).mapToDouble(Double::parseDouble).toArray();
            boxes.add(new Box(tempArr[0], tempArr2[0], tempArr2[1], tempArr2[2], tempArr2[0]*tempArr2[1]*tempArr2[2]));
            temp = input.nextLine();
        }
    }
}
