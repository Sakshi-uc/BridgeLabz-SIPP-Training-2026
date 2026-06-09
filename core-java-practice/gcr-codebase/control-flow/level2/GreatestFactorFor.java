import java.util.Scanner;

public class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>0) {
            int greatestFactor = 1;
            for(int i=num-1; i>=1; i--) {
                if(num%i==0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("The greatest factor of " + num + " is " + greatestFactor);
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
