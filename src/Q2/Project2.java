package Q2;

import java.util.ArrayList;
import java.util.Scanner;

// Simple Contact Manager
public class Project2 {
    static class Contact {
        private String name;
        private String email;
        private String num;

        public Contact(String name, String email, String num) {
            this.name = name;
            this.email = email;
            this.num = num;
        }

        public String toString() {
            return String.format("%s\t%s\t%s\n", name, email, num);
        }

        public boolean checkName(String name) {
            return this.name.equalsIgnoreCase(name);
        }
    }

    public static boolean execute(String choice, ArrayList<Contact> arrlist) {
        switch (choice) {
            case "S":
                Scanner store = new Scanner(System.in);
                System.out.print("Name: ");
                String name = store.next();
                System.out.print("Email: ");
                String email = store.next();
                System.out.print("Phone number: ");
                String number = store.next();
                arrlist.add(new Contact(name, email, number));
                break;
            case "F":
                Scanner find = new Scanner(System.in);
                System.out.print("Name: ");
                String n = find.next();
                boolean found = false;
                for (Contact c : arrlist) {
                    if (c.checkName(n)) {
                        found = true;
                        System.out.print(c.toString());
                    }
                }
                if (!found) System.out.println("Invalid Name!");
                break;
            case "E":
                return false;
            default:
                System.out.println("Not a valid choice!");
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        ArrayList<Contact> arrlist = new ArrayList<>();
        while (run) {
            System.out.print("S to store a contact, F to find a contact, E to exit the program: ");
            String choice = input.next();
            run = execute(choice, arrlist);
        }
    }
}
