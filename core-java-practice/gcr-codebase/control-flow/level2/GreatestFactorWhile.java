import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>0) {
            int greatestFactor = 1;
            int counter = num-1;
            while(counter>=1) {
                if(num%counter==0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }
            System.out.println("The greatest factor of " + num + " is " + greatestFactor);
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
