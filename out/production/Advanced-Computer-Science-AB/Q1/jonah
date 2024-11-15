package Q1;

import DataStructures.Queue;
import DataStructures.QueueStack;
import DataStructures.Stack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class newprog1071h {
    public static class filler implements Comparable<newprog1071h.filler> {
        private Integer type;
        private Integer units;
        private Double cost;
        private Double total;

        public filler(Integer type, Integer units, Double cost, Double  total) {
            this.type = type; this.units = units; this.cost = cost; this.total = total;
        }

        public Double getCost() {
            return cost;
        }

        public Integer getType() {
            return type;
        }

        public Integer getUnits() {
            return units;
        }

        public Double getTotal() {
            return total;
        }
        public void addTotal(double num) {total += num;}

        @Override
        public int compareTo(newprog1071h.filler o) {
            return 0;
        }
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/bginvtry.txt"));
            var file2 = new Scanner(new File("Langdat/buysell.txt"));
            var stack = new QueueStack<filler>();
            var size = 0;
            while (file.hasNext()) {
                var type = file.nextInt();
                var units = file.nextInt();
                var cost = file.nextDouble();
                var totalcost = units*cost;
                stack.push(new filler(type, units, cost, totalcost));
                size++;
                System.out.println(type + " " + units + " " + cost);
            }
            file.close();
            System.out.println();
            var temp = new QueueStack<filler>();
            while (file2.hasNext()) {
                var let = file2.next();
                if (let.equalsIgnoreCase("B")) {
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                    var cost = file2.nextDouble();
                    var total = units*cost;
                    var did = true;
                    newprog1071h.filler fill = new filler(type, units, cost, total);
//                    stack.push(fill);
                    while (stack.isEmpty()) {
                        var t = stack.pop();
                        if (t.getCost() == cost) {
                            fill = new filler(type, t.getUnits()+units, t.getCost(), t.getTotal()+total);
                            did = false;
                            stack.push(fill);
                            break;
                        } else {
                            temp.push(t);
                        }
                    }
                    if (did) {
                        var t = new filler(type, units, cost, total);
                        temp.push(t);
                    }
                    while (!temp.isEmpty()) {
                        var t = temp.pop();
                        stack.push(t);

                    }
                } else if (let.equalsIgnoreCase("S")){
                    var type = file2.nextInt();
                    var units = file2.nextInt();
                    newprog1071h.filler fill = null;
                    while (!stack.isEmpty()) {
                        var t = stack.pop();
                        if (t.getType() == type) {
                            if (t.getUnits()-units <= 0) {
                                units -= t.getUnits();
                            } else {
                                fill = new filler(type, t.getUnits() - units, t.getCost(), t.getTotal());
                                stack.push(fill);
                                break;
                            }
                        } else {
                            temp.push(t);
                        }
                    }
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }

                }
//                System.out.println(stack.getSize());
            }
            filler[] print = new filler[10];
            var tem = new ArrayList<filler>();
            System.out.println("Ending Merchandise: ");
            while (!stack.isEmpty()) {
                var l = stack.pop();
                tem.add(l);
            }
            for (int lcv = 0; lcv < tem.size(); lcv++) {
                var l = tem.get(tem.size()-lcv-1);
                System.out.println(l.getType() + " " + l.getUnits() + " " + l.getCost());
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//1 50 1298.0
//2 50 107.5
//3 100 248.85
//4 5000 1.07
//5 20 489.75
//6 5 586.24
//7 30 84.23
//8 600 24.73
//9 1500 19.99
//10 15 238.99
//
//Ending Merchandise:
//1 13 1298.0
//3 72 248.85
//4 5000 1.07
//5 2 489.75
//6 4 586.24
//7 30 84.23
//8 600 24.73
//9 1000 19.99
//10 9 238.99
//10 15 250.0
//5 20 510.25
//3 15 275.55
//9 10 21.25
//2 2 111.25
//7 10 87.5
//4 750 1.1