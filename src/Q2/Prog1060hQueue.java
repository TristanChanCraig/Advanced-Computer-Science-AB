package Q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.Queue;

@SuppressWarnings("unchecked")
public class Prog1060hQueue {
    static class Inventory implements Comparable<Inventory> {
        private String size;
        private String name;
        private double miles;
        public Inventory(String size, String name, double miles) {
            this.size = size;
            this.name = name;
            this.miles = miles;
        }
        @Override
        public int compareTo(Inventory o) {
            return 0;
        }

        public String toString() {
            System.out.printf("%s\t%.2f\n", name, miles);
            return null;
        }

        public String getSize() { return size; }
    }
    static class Rates {
        private String size;
        private double cday;
        private double cmile;

        public Rates(String size, double cday, double cmile) {
            this.size = size;
            this.cday = cday;
            this.cmile = cmile;
        }
    }

    static String getType(String type) {
        switch (type) {
            case "S" -> {
                return "Sub Compact";
            }
            case "C" -> {
                return "Compact";
            }
            case "M" -> {
                return "Midsize";
            }
            case "W" -> {
                return "Wagon";
            }
            case "L" -> {
                return "Luxury";
            }
            default -> {
                return null;
            }
        }
    }

    static void printCars(Queue<Inventory> cars, String type) {
        Queue<Inventory> temp = new Queue<>();
        System.out.println("Listing for " + getType(type) + ":");
        while (!cars.isEmpty()) {
            var jon = cars.dequeue();
            jon.toString();
            temp.enqueue(jon);
        }
        while (!temp.isEmpty()) cars.enqueue(temp.dequeue());
    }

    public static void main(String[] args) {
        try {
            var file1 = new Scanner(new File("Langdat/invntory.dat"));
            var file2 = new Scanner(new File("Langdat/rates.dat"));
            var file3 = new Scanner(new File("Langdat/transact.dat"));

            Queue<Inventory> sCars = new Queue<>();
            Queue<Inventory> cCars = new Queue<>();
            Queue<Inventory> mCars = new Queue<>();
            Queue<Inventory> wCars = new Queue<>();
            Queue<Inventory> lCars = new Queue<>();
            Queue[] qs = {sCars, cCars, mCars, wCars, lCars};
            while (file1.hasNext()) {
                String temp = file1.next();
                double miles = file1.nextDouble();
                var jon = new Inventory(temp.substring(0, 1), temp.substring(1), miles);
                switch (temp.substring(0, 1)) {
                    case "S" -> sCars.enqueue(jon);
                    case "C" -> cCars.enqueue(jon);
                    case "M" -> mCars.enqueue(jon);
                    case "W" -> wCars.enqueue(jon);
                    case "L" -> lCars.enqueue(jon);
                    default -> System.out.println("Not a valid car size!");
                }
            }
            file1.close();

            Rates[] rates = new Rates[5];
            int i = 0;
            while (file2.hasNext()) {
                String temp = file2.next();
                rates[i] = new Rates(temp.substring(0, 1), Double.parseDouble(temp.substring(1)), file2.nextDouble());
                i++;
            }
            file2.close();

            Queue<Inventory> rented = new Queue<>();
            while (file3.hasNext()) {
                String temp = file3.next();
                String code;
                switch (temp.substring(0,1)) {
                    case "L":
                        switch (temp.substring(1, 2)) {
                            case "S" -> printCars(qs[0], "S");
                            case "C" -> printCars(qs[1], "C");
                            case "M" -> printCars(qs[2], "M");
                            case "W" -> printCars(qs[3], "W");
                            case "L" -> printCars(qs[4], "L");
                            default -> System.out.println("Not a valid car size!");
                        }
                        System.out.println();
                        break;
                    case "R":
                        switch (temp.substring(1, 2)) {
                            case "S" -> {
                                Inventory car = sCars.dequeue();
                                System.out.printf("Rented Car:\n%s", car.toString());
                                rented.enqueue(car);
                            }
                            case "C" -> {
                                Inventory car = cCars.dequeue();
                                System.out.printf("Rented Car:\n%s", car.toString());
                                rented.enqueue(car);
                            }
                            case "M" -> {
                                Inventory car = mCars.dequeue();
                                System.out.printf("Rented Car:\n%s", car.toString());
                                rented.enqueue(car);
                            }
                            case "W" -> {
                                Inventory car = wCars.dequeue();
                                System.out.printf("Rented Car:\n%s", car.toString());
                                rented.enqueue(car);
                            }
                            case "L" -> {
                                Inventory car = lCars.dequeue();
                                System.out.printf("Rented Car:\n%s", car.toString());
                                rented.enqueue(car);
                            }
                            default -> System.out.println("Not a valid car size!");
                        }
                        System.out.println();
                        System.out.println();
                        break;
                    case "A":
                        code = temp.substring(1, 2);
                        int days = Integer.parseInt(temp.substring(2, 3));
                        double odometer = file3.nextDouble();
                        String name = file3.next();
                        Inventory car = rented.dequeue();
                        switch (car.getSize()) {
                            case "S" -> qs[0].enqueue(car);
                            case "C" -> qs[1].enqueue(car);
                            case "M" -> qs[2].enqueue(car);
                            case "W" -> qs[3].enqueue(car);
                            case "L" -> qs[4].enqueue(car);
                            default -> System.out.println("Not a valid car size!");
                        }
                        break;
                    case "C":
                        var t = new Queue<Inventory>();
                        System.out.println("Rented:");
                        while (!rented.isEmpty()) {
                            Inventory car2 = rented.dequeue();
                            car2.toString();
                            t.enqueue(car2);
                        }
                        while (!t.isEmpty()) rented.enqueue(t.dequeue());
                        break;
                    default:
                        System.out.println("Not a valid transaction!");
                }
            }
            file3.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
