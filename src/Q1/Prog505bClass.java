package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog505bClass {
    static class Student {
        private static double avgT1 = 0;
        private static double avgT2 = 0;
        private static double avgT3 = 0;
        private static double avgT4 = 0;
        private static double avgT5 = 0;
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
            avgGrade = 0;
            grade = "";
            stuCnt++;
            this.t1 += t1;
            this.t2 += t2;
            this.t3 += t3;
            this.t4 += t4;
            this.t5 += t5;
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

        public String getGrade() { return grade; }
        public String getFirst() { return first; }
        public String getLast() { return last; }
        public int getT1() { return t1; }
        public int getT2() { return t2; }
        public int getT3() { return t3; }
        public int getT4() { return t4; }
        public int getT5() { return t5; }
        public double getAvgT1() { return avgT1; }
        public double getAvgT2() { return avgT2; }
        public double getAvgT3() { return avgT3; }
        public double getAvgT4() { return avgT4; }
        public double getAvgT5() { return avgT5; }

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

            int aCnt = 0;
            int bCnt = 0;
            int cCnt = 0;
            int dCnt = 0;
            int fCnt = 0;

            students.get(0).calcAvgGrades();
            for (Student student : students) {
                String first = student.getFirst();
                String last = student.getLast();
                int t1 = student.getT1();
                int t2 = student.getT2();
                int t3 = student.getT3();
                int t4 = student.getT4();
                int t5 = student.getT5();
                student.calcGrade();
                String grade = student.getGrade();
                if (grade.equalsIgnoreCase("A")) aCnt++;
                else if (grade.equalsIgnoreCase("B")) bCnt++;
                else if (grade.equalsIgnoreCase("C")) cCnt++;
                else if (grade.equalsIgnoreCase("D")) dCnt++;
                else fCnt++;
                double avgGrade = student.avgGrade;
                System.out.printf("%s %s\t\t%d\t%d\t%d\t%d\t%d\t\t%.1f\t%s\n", first, last, t1, t2, t3, t4, t5, avgGrade, grade);
            }

            double test1 = students.get(0).getAvgT1();
            double test2 = students.get(0).getAvgT2();
            double test3 = students.get(0).getAvgT3();
            double test4 = students.get(0).getAvgT4();
            double test5 = students.get(0).getAvgT5();

            System.out.printf("Test 1: %.2f\t\t\t\tA: %s\n", test1, aCnt);
            System.out.printf("Test 2: %.2f\t\t\t\tB: %s\n", test2, bCnt);
            System.out.printf("Test 3: %.2f\t\t\t\tC: %s\n", test3, cCnt);
            System.out.printf("Test 4: %.2f\t\t\t\tD: %s\n", test4, dCnt);
            System.out.printf("Test 5: %.2f\t\t\t\tF: %s", test5, fCnt);

        } catch (IOException e) {
            System.out.println("Can't find data file!");
        }
    }
}
/*
Sam Lilly		80	77	82	86	90		83.0	B
Fred Biggie		70	72	88	90	93		82.6	B
Sally Awesome		92	91	85	99	93		92.0	A
Test 1: 80.67				A: 1
Test 2: 80.00				B: 2
Test 3: 85.00				C: 0
Test 4: 91.67				D: 0
Test 5: 92.00				F: 0
 */