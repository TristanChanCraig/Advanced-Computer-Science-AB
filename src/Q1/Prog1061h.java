package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.DoublyLinkedList;

public class Prog1061h {
    public static void main(String[] args) {
        try {
            var list = new DoublyLinkedList<String>();
            var file = new Scanner(new File("Langdat/prg1061h.dat"));

            while (file.hasNext()) {
                String line = file.nextLine();
                switch (line.substring(0, 1)) {
                    case "A":
                        list.addSorted(line.substring(1));
                        break;
                    case "D":
                        list.removeWord(line.substring(1));
                        break;
                    case "P":
                        list.print();
                        break;
                    default:
                        System.out.println("Broken langdat");
                }
            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
CONST IF LONG

BREAK CONTINUE SHORT WHILE
 */