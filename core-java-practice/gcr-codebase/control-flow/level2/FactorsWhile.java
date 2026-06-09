import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>0) {
            int counter = 1;
            System.out.print("Factors of " + num + ": ");
            while(counter<num) {
                if(num%counter==0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
