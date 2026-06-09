import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int yr = sc.nextInt();
        if(yr<1582) {
            System.out.println("Year must be 1582 or later.");
        } else if(yr%400==0) {
            System.out.println(yr + " is a Leap Year");
        } else if(yr%100==0) {
            System.out.println(yr + " is not a Leap Year");
        } else if(yr%4==0) {
            System.out.println(yr + " is a Leap Year");
        } else {
            System.out.println(yr + " is not a Leap Year");
        }
    }
}
