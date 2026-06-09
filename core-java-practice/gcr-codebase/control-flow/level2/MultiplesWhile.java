import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num>0 && num<100) {
            int counter = 100;
            System.out.print("Multiples of " + num + " below 100: ");
            while(counter>1) {
                if(counter%num==0) {
                    System.out.print(counter + " ");
                }
                counter--;
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }
    }
}
