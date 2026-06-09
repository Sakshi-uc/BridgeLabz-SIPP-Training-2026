import java.util.Scanner;

public class FactorsFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>0) {
            System.out.print("Factors of " + num + ": ");
            for(int i=1; i<num; i++) {
                if(num%i==0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
