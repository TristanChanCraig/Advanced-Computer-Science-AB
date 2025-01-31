package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.Set;

public class Prog505aSet {
    static class Cl505a implements Comparable<Cl505a> {
        private String myName;
        private int myBooks;
        private int myPoints;

        public Cl505a(String name, int books) {
            myName = name;
            myBooks = books;
            myPoints = 0;
        }

        public void calc() {
            if (myBooks <= 3)
                myPoints = myBooks * 10;
            else if (myBooks <= 6)
                myPoints = (myBooks - 3) * 15 + 30;
            else
                myPoints = (myBooks - 6) * 20 + 30 + 45;
        }

        public String getName() { return myName; }
        public int getMyBooks() { return myBooks; }
        public int getPoints() { return myPoints; }

        public String toString() {
            return myName + "\t" + myBooks + "\t" + myPoints;
        }

        @Override
        public int compareTo(Cl505a o) {
            return o.getName().compareTo(myName);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog505a.dat"));
            Set<Cl505a> list = new Set<Cl505a>();

            while (input.hasNext()) {
                String fname = input.next();
                String lname = input.next();
                int books = input.nextInt();
                String name = fname + " " + lname;
                Cl505a wowser = new Cl505a(name, books);
                list.insert(wowser);
            }
            var iter = list.iterator();
            while (iter.hasNext()) {
                Cl505a cur = iter.next();
                cur.calc();
            }

            for (Cl505a x : list)
                System.out.println(x);

            double tot = 0;
            for (Cl505a p : list) tot += p.getPoints();
            double avg = tot / list.size();
            System.out.println("\nAverage points: " + avg);

            var i = list.iterator();
            var e = i.next();
            int bigPoints = e.getPoints();
            String bigName = e.getName();
            while (i.hasNext()) {
                Cl505a book = i.next();
                if (book.getPoints() > bigPoints) {
                    bigPoints = book.getPoints();
                    bigName = book.getName();
                }
            }

            System.out.println("The winner is " + bigName);

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
Richie Reader	6	75
Sam Summer	4	45
K.C. Master	8	115
Paul Prodder	5	60
Linda Lazy	2	20

Average points: 63.0
The winner is K.C. Master
 */