package Q1;
import Utils.Console;

public class LP5_21 {
    public static void main(String[] args) {
        String first = Console.input("Enter your first name: ");
        String last = Console.input("Enter your last name: ");
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int group = switch (alphabet.indexOf(last.substring(0, 1).toUpperCase())) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8 -> 1;
            case 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 -> 2;
            default -> 3;
        };
        System.out.printf("%s %s is assigned to Group %d", first, last, group);
    }
}
/*
Enter your first name: Christina
Enter your last name: Briglio
Christina Briglio is assigned to Group 1
 */