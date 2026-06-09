import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;
        int origNum = num;
        while(origNum!=0) {
            int digit = origNum%10;
            sum += digit*digit*digit;
            origNum /= 10;
        }
        if(sum==num) {
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is not an Armstrong Number");
        }
    }
}
