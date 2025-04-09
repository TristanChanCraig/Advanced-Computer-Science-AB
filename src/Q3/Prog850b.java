package Q3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prog850b {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog850b.txt"));
            Map<String, Integer> map = new HashMap<>();

            while (file.hasNext()) {
                var line = file.nextLine();
                var arr = line.split("\\s+");
                if (!map.containsKey(arr[0])) map.put(arr[0], Integer.valueOf(arr[4]));
                else map.put(arr[0], Integer.parseInt(arr[4]) + map.get(arr[0]));

            }
            file.close();

            System.out.println("Department\tHours Used");
            var keys = map.keySet();
            for (String key : keys) System.out.println(key + "\t\t" + map.get(key));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Department	Hours Used
Ryan		1243
Number		1246
Getka		651
Taylor		715
Computer		769
Sam		279
Business		583

Process finished with exit code 0

 */
