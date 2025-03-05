package Q3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringInterview5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        var pattern = Pattern.compile("^[0-9]+$");
        var matcher = pattern.matcher(str);
        System.out.println(matcher.find());
    }
}
/*
Enter the string: cats
false

Enter the string: ihatemarlon999
false

Enter the string: 12
true
 */