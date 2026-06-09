import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        System.out.print("Enter a number (0 to stop): ");
        double val = sc.nextDouble();
        while(val!=0) {
            total += val;
            System.out.print("Enter a number (0 to stop): ");
            val = sc.nextDouble();
        }
        System.out.println("The total sum is " + total);
    }
}
