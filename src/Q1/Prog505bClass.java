package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog505bClass {
    static class Student {
        private static int avgT1 = 0;
        private static int avgT2 = 0;
        private static int avgT3 = 0;
        private static int avgT4 = 0;
        private static int avgT5 = 0;
        private static int stuCnt;
        private String first;
        private String last;
        private int t1;
        private int t2;
        private int t3;
        private int t4;
        private int t5;
        private double avgGrade;
        private String grade;

        public Student(String first, String last, int t1, int t2, int t3, int t4, int t5) {
            this.first = first;
            this.last = last;
            avgT1 = t1;
            avgT2 = t2;
            avgT3 = t3;
            avgT4 = t4;
            avgT5 = t5;
            avgGrade = 0;
            grade = "";
            stuCnt++;
            this.t1 += t1;
            this.t2 += t2;
            this.t3 += t3;
            this.t4 += t4;
            this.t5 += t5;
        }

        public void addGrades() {
            avgT1 += t1;
            avgT2 += t2;
            avgT3 += t3;
            avgT4 += t4;
            avgT5 += t5;
        }

        private void calcGrade() {
            avgGrade = (t1 + t2 + t3 + t4 + t5) / 5.0;
            if (avgGrade >= 90) grade = "A";
            else if (avgGrade >= 80) grade = "B";
            else if (avgGrade >= 70) grade = "C";
            else if (avgGrade >= 60) grade = "D";
            else grade = "F";
        }

        public void calcAvgGrades() {
            avgT1 /= stuCnt;
            avgT2 /= stuCnt;
            avgT3 /= stuCnt;
            avgT4 /= stuCnt;
            avgT5 /= stuCnt;
        }

        public String getGrade() {}
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("Langdat/prog505b.dat"));
            ArrayList<Student> students = new ArrayList<>();

            while (input.hasNext()) {
                String first = input.next();
                String last = input.next();
                int t1 = input.nextInt();
                int t2 = input.nextInt();
                int t3 = input.nextInt();
                int t4 = input.nextInt();
                int t5 = input.nextInt();
                Student student = new Student(first, last, t1, t2, t3, t4, t5);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
