package Q1.Prog285b;

import DataStructures.Queue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog285bQueue {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var queue = new Queue<Cl285b>();

            while (file.hasNext()) {
                int id = file.nextInt();
                int c = file.nextInt();
                double s = file.nextDouble();

                var fred = new Cl285b(id, c, s);
                queue.enqueue(fred);
            }
            file.close();

            System.out.println("Number\tCode\tSales\tCommission");
            while (!queue.isEmpty()) {
                var fred = queue.dequeue();
                System.out.println(fred);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Number	Code	Sales	Commission
101		17		$2250.00	$213.75
103		5		$4000.00	$300.00
117		3		$7350.00	$0.00
118		8		$7350.00	$574.75
125		5		$6500.00	$502.50
138		17		$6375.00	$677.50
192		8		$8125.00	$640.63
203		8		$3250.00	$243.75
218		5		$5000.00	$375.00
235		5		$5250.00	$396.25
264		17		$4150.00	$410.50
291		17		$750.00	$71.25
 */