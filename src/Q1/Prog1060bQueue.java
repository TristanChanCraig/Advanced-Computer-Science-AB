package Q1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prog1060bQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        boolean hi = true;
        while (hi) {
            System.out.print("Enter task A)dd, D)elete, or E)xit: ");
            String c = input.next();
            switch (c) {
                case "A":
                    System.out.print("Enter number: ");
                    q.add(input.nextInt());
                    break;
                case "D":
                    System.out.print("Enter number: ");
                    int num = input.nextInt();
                    q.remove(num);
                    break;
                case "E":
                    hi = false;
                    break;
                default:
                    System.out.println("Number does not exist!");
            }
            System.out.println("List:");
            for (Integer num : q) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println();
        }
        for (Integer num : q) {
            System.out.print(num + " ");
        }
    }
}
/*
Enter task A)dd, D)elete, or E)xit: A
Enter number: 10
List:
10

Enter task A)dd, D)elete, or E)xit: A
Enter number: 15
List:
10 15

Enter task A)dd, D)elete, or E)xit: A
Enter number: 2
List:
10 15 2

Enter task A)dd, D)elete, or E)xit: D
Enter number: 10
List:
15 2

Enter task A)dd, D)elete, or E)xit: D
Enter number: 2
List:
15

Enter task A)dd, D)elete, or E)xit: D
Enter number: 15
List:


Enter task A)dd, D)elete, or E)xit: A
Enter number: 7
List:
7

Enter task A)dd, D)elete, or E)xit: D
Enter number: 8
Number does not exist!
List:
7

Enter task A)dd, D)elete, or E)xit: A
Enter number: 12
List:
7 12

Enter task A)dd, D)elete, or E)xit: D
Enter number: 12
List:
7

Enter task A)dd, D)elete, or E)xit: E
List:
7

Successfully Exited!
List:
7
 */