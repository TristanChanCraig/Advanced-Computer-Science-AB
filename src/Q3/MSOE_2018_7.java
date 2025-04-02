package Q3;

import java.sql.Time;
import java.util.Scanner;

public class MSOE_2018_7 {
    public static int days(int month, int year) {
        int daysInMonth = -1;
        if (month <= 7) {
            if (month == 2) daysInMonth = (year % 4 == 0) ? 29 : 28;
            else daysInMonth = (month % 2 == 1) ? 31 : 30;
        } else daysInMonth = (month % 2 == 0) ? 31 : 30;
        return daysInMonth;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter UNIX time: ");
        int unix = input.nextInt();
        int year = 1970;
        int day = 1;
        int month = 1;
        int daysInMonth = 31;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        while (unix >= 365 * 86400) {
            if (year % 4 == 0) unix -= 366 * 86400;
            else unix -= 365 * 86400;
            year++;
        }
        while (unix >= daysInMonth * 86400) {
            unix -= daysInMonth * 86400;
            if (month == 12) year++;
            month = month % 12 + 1;
            daysInMonth = days(month, year);
        }
        while (unix >= 86400) {
            unix -= 86400;
            day++;
            if (day > daysInMonth) {
                day = 1;
                if (month == 12) year++;
                month = month % 12 + 1;
                daysInMonth = days(month, year);
            }
        }
        while (unix >= 3600) {
            unix -= 3600;
            hours++;
            if (hours >= 24) {
                hours = 0;
                day++;
                if (day == daysInMonth) {
                    day = 1;
                    if (month == 12) year++;
                    month = month % 12 + 1;
                    daysInMonth = days(month, year);
                }
            }
        }
        while (unix >= 60) {
            unix -= 60;
            minutes++;
            if (minutes > 60) {
                minutes = 0;
                hours++;
                if (hours > 24) {
                    if (day == daysInMonth) {
                        day = 1;
                        if (month == 12) year++;
                        month = month % 12 + 1;
                        daysInMonth = days(month, year);
                    }
                }
            }
        }
        while (unix >= 1) {
            unix -= 1;
            seconds++;
            if (seconds > 60) {
                seconds = 0;
                minutes++;
                if (minutes > 60) {
                    minutes = 0;
                    hours++;
                    if (hours > 24) {
                        if (day == daysInMonth) {
                            day = 1;
                            if (month == 12) year++;
                            month = month % 12 + 1;
                            daysInMonth = days(month, year);
                        }
                    }
                }
            }
        }
        String theM = (hours >= 12) ? "PM" : "AM"; // fix
        hours = (hours == 0) ? 12 : (hours > 12) ? hours - 12 : hours;
        if (minutes == 0) System.out.printf("%d:%d0 %s\t\t%d/%d/%d", hours, minutes, theM, month, day, year);
        else System.out.printf("%d:%d %s\t\t%d/%d/%d", hours, minutes, theM, month, day, year);
    }
}
/*
Enter UNIX time: 0
12:00 AM		1/1/1970

Enter UNIX time: 1234567890
11:31 PM		2/13/2009

Enter UNIX time: 1111111111
1:58 AM		3/18/2005
 */