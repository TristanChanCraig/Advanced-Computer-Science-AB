package Q3;

import java.util.Scanner;

public class MSOE_2009_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("1st Latitude: ");
        double oneLat = Math.toRadians(input.nextDouble());
        System.out.print("1st Longitude: ");
        double oneLong = Math.toRadians(input.nextDouble());
        System.out.print("2nd Latitude: ");
        double twoLat = Math.toRadians(input.nextDouble());
        System.out.print("2nd Longitude: ");
        double twoLong = Math.toRadians(input.nextDouble());

        double dist = 3963.1*Math.acos(Math.cos(twoLat)*Math.cos(twoLong)*Math.cos(oneLat)*Math.cos(oneLong) +
                Math.cos(twoLat)*Math.sin(twoLong)*Math.cos(oneLat)*Math.sin(oneLong) + Math.sin(twoLat)*Math.sin(oneLat));

        System.out.println(dist + " miles");
    }
}
/*
1st Latitude: 43.043
1st Longitude: -87.905
2nd Latitude: 43.045
2nd Longitude: -87.918
0.6715641671039231 miles
 */