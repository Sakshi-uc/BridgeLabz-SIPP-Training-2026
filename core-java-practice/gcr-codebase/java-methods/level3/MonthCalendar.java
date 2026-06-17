import java.util.Scanner;

public class MonthCalendar {
    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int adjustedMonth = month;
        int adjustedYear = year;
        if (adjustedMonth < 3) {
            adjustedMonth += 12;
            adjustedYear--;
        }
        int day = 1;
        int yearOfCentury = adjustedYear % 100;
        int zeroBasedCentury = adjustedYear / 100;
        int h = (day + (13 * (adjustedMonth + 1)) / 5 + yearOfCentury
                + yearOfCentury / 4 + zeroBasedCentury / 4 + 5 * zeroBasedCentury) % 7;
        return (h + 6) % 7;
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("\n\t" + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDayOfMonth(month, year);
        int days = getDaysInMonth(month, year);

        for (int space = 0; space < firstDay; space++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month number: ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();

        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }
        input.close();
    }
}
