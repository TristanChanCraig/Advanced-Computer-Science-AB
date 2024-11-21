package Q2;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
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
            return String.format("%s\t%.2f\n", name, miles);
        }

        public String getSize() { return size; }

        public double getMileage() { return miles; }

        public String getName() { return name; }

        public void setMileage(double m) { miles = m; }
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

        public double getCday() {
            return cday;
        }

        public double getCmile() {
            return cmile;
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
            System.out.print(jon.toString());
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
                switch (temp.substring(0, 1)) {
                    case "L" -> {
                        switch (temp.substring(1, 2)) {
                            case "S" -> printCars(qs[0], "S");
                            case "C" -> printCars(qs[1], "C");
                            case "M" -> printCars(qs[2], "M");
                            case "W" -> printCars(qs[3], "W");
                            case "L" -> printCars(qs[4], "L");
                            default -> System.out.println("Not a valid car size!");
                        }
                        System.out.println();
                    }
                    case "R" -> {
                        Inventory car = null;
                        String type = temp.substring(1, 2);
                        do {
                            switch (type) {
                                case "S" -> {
                                    if (qs[0].isEmpty()) type = "C";
                                    else car = sCars.dequeue();
                                }
                                case "C" -> {
                                    if (qs[1].isEmpty()) type = "M";
                                    else car = cCars.dequeue();
                                }
                                case "M" -> {
                                    if (qs[2].isEmpty()) type = "W";
                                    else car = mCars.dequeue();
                                }
                                case "W" -> {
                                    if (qs[3].isEmpty()) type = "L";
                                    else car = wCars.dequeue();
                                }
                                case "L" -> {
                                    car = lCars.dequeue();
                                }
                            }
                        } while (car == null && !type.equalsIgnoreCase("L"));
                        // System.out.printf("Rented Car:\n%s", car.toString());
                        rented.enqueue(car);
                        // System.out.println();
                    }
                    case "A" -> {
                        code = temp.substring(1, 2);
                        int days = Integer.parseInt(temp.substring(2, 3));
                        double miles = file3.nextDouble();
                        String name = file3.next();
                        var t = new Queue<Inventory>();
                        while (!rented.peek().getName().equalsIgnoreCase(name)) t.enqueue(rented.dequeue());
                        var car = rented.dequeue();
                        while (!rented.isEmpty()) t.enqueue(rented.dequeue());
                        double cmile = 0;
                        double cday = 0;
                        switch (car.getSize()) {
                            case "S" -> {
                                cmile = rates[0].getCmile();
                                cday = rates[0].getCday();
                            }
                            case "C" -> {
                                cmile = rates[1].getCmile();
                                cday = rates[1].getCday();
                            }
                            case "M" -> {
                                cmile = rates[2].getCmile();
                                cday = rates[2].getCday();
                            }
                            case "W" -> {
                                cmile = rates[3].getCmile();
                                cday = rates[3].getCday();
                            }
                            case "L" -> {
                                cmile = rates[4].getCmile();
                                cday = rates[4].getCday();
                            }
                            default -> System.out.println("Not a valid car size!");
                        }
                        System.out.println("Wrent A Wreck Invoice");
                        System.out.println("Car: " + name);
                        System.out.printf("Beginning Mileage: %.2f\n", car.getMileage());
                        System.out.printf("Ending Mileage: %.2f\n", miles);
                        double mDriven = miles - car.getMileage();
                        double mDcost = mDriven * cmile;
                        System.out.printf("Miles Driven: %.2f @ %.2f = %.2f\n",mDriven, cmile, mDcost);
                        double mDaycost = days * cday;
                        System.out.printf("Days Driven: %d @ %.2f = %.2f\n", days, cday, mDaycost);
                        System.out.println("Car Type: " + getType(car.getSize()));
                        double total = mDaycost + mDcost;
                        System.out.printf("Total Amount Due: %.2f\n", total);
                        car.setMileage(miles);

                        switch (car.getSize()) {
                            case "S" -> qs[0].enqueue(car);
                            case "C" -> qs[1].enqueue(car);
                            case "M" -> qs[2].enqueue(car);
                            case "W" -> qs[3].enqueue(car);
                            case "L" -> qs[4].enqueue(car);
                            default -> System.out.println("Not a valid car size!");
                        }
                        while (!t.isEmpty()) rented.enqueue(t.dequeue());
                        System.out.println();
                    }
                    case "C" -> {
                        var t = new Queue<Inventory>();
                        System.out.println("Rented:");
                        while (!rented.isEmpty()) {
                            Inventory car2 = rented.dequeue();
                            System.out.print(car2.toString());
                            t.enqueue(car2);
                        }
                        while (!t.isEmpty()) rented.enqueue(t.dequeue());
                        System.out.println();
                    }
                    default -> System.out.println("Not a valid transaction!");
                }
            }
            file3.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Listing for Sub Compact:
Yugo	3456.30
Chevette	1710.10
RX7	4002.10
Sentra	3007.00

Listing for Compact:
Shadow	831.20
Topaz	412.50
Contour	1091.70
Fiero	1541.40

Listing for Midsize:
Cutlass	930.70
Mystique	117.40
LaBaron	831.20
Cougar	1442.20

Listing for Wagon:
Delta88	2417.70
Caprice	4522.80
Bonneville	5100.00

Listing for Luxury:
Cadillac	1234.50
Lincoln	8400.20
Corvette	10341.70

Rented:
Yugo	3456.30
Chevette	1710.10
RX7	4002.10
Sentra	3007.00
Shadow	831.20
Topaz	412.50
Contour	1091.70
Fiero	1541.40
Cutlass	930.70
Mystique	117.40
Delta88	2417.70
Cadillac	1234.50
LaBaron	831.20

Wrent A Wreck Invoice
Car: Yugo
Beginning Mileage: 3456.30
Ending Mileage: 3640.00
Miles Driven: 183.70 @ 0.22 = 40.41
Days Driven: 2 @ 18.00 = 36.00
Car Type: Sub Compact
Total Amount Due: 76.41

Wrent A Wreck Invoice
Car: Cadillac
Beginning Mileage: 1234.50
Ending Mileage: 2801.20
Miles Driven: 1566.70 @ 0.37 = 579.68
Days Driven: 2 @ 34.00 = 68.00
Car Type: Luxury
Total Amount Due: 647.68

Wrent A Wreck Invoice
Car: Contour
Beginning Mileage: 1091.70
Ending Mileage: 2031.70
Miles Driven: 940.00 @ 0.25 = 235.00
Days Driven: 3 @ 20.50 = 61.50
Car Type: Compact
Total Amount Due: 296.50

Listing for Sub Compact:
Yugo	3640.00

Listing for Compact:
Contour	2031.70

Listing for Midsize:
Cougar	1442.20

Listing for Wagon:
Caprice	4522.80
Bonneville	5100.00

Listing for Luxury:
Lincoln	8400.20
Corvette	10341.70
Cadillac	2801.20

Rented:
Chevette	1710.10
RX7	4002.10
Sentra	3007.00
Shadow	831.20
Topaz	412.50
Fiero	1541.40
Cutlass	930.70
Mystique	117.40
Delta88	2417.70
LaBaron	831.20
 */