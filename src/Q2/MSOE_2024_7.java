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

        public double getSize() {
            return s;
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
        var t = new ArrayList<Box>();
//        t.add(boxes.get(0));
        for (int i = 0; i < boxes.size()-1; i++) {
            double box = boxes.get(i).s;
            if (box > boxes.get(i+1).s * 1.55 && box < boxes.get(i+1).s * 1.65) {
                System.out.println(i);
                int n = 1;
                int cur = i+1;
                while (cur < boxes.size()-1 && boxes.get(cur).s > boxes.get(cur+1).s * 1.55 && boxes.get(cur).s < boxes.get(cur+1).s * 1.65) {
                    cur++;
                    n++;
                    System.out.println(n);
                }
                if (n > t.size()) {
                    System.out.println("hi");
                    t.clear();
                    for (int iz = 0; iz < cur+1; iz++) {
                        t.add(boxes.get(i+iz));
                    }
                }
            }

        }
        for (Box box : t) {
            System.out.println(box.n + " " + box.l + "x" + box.w + "x" + box.h);
        }
    }
}
/*
bigbox 55x45x45
boot 43x40x40
shoe 32x18x19
soda 17x17x17
ball_1 20x20x12.0
ball_2 18.0x18x18.5
glove 5x5x17.4
ignore 0x0x0

1
 */