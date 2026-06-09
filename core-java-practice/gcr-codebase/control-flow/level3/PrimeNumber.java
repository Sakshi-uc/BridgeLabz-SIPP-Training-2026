import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>1) {
            boolean isPrime = true;
            for(int i=2; i<num; i++) {
                if(num%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println(num + " is a Prime Number");
            } else {
                System.out.println(num + " is not a Prime Number");
            }
        } else {
            System.out.println("Please enter a number greater than 1.");
        }
    }
}
