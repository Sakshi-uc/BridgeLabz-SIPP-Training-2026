import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double sal = sc.nextDouble();
        System.out.print("Enter years of service: ");
        int yrs = sc.nextInt();
        if(yrs>5) {
            double bonus = sal*5/100;
            System.out.println("The bonus amount is INR " + bonus);
        } else {
            System.out.println("No bonus. Years of service must be more than 5.");
        }
    }
}
