import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        if(num>0) {
            long fact = 1;
            for(int i=1; i<=num; i++) {
                fact *= i;
            }
            System.out.println("The factorial of " + num + " is " + fact);
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
