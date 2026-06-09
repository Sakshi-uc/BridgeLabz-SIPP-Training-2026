import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter number2: ");
        int n2 = sc.nextInt();
        System.out.print("Enter number3: ");
        int n3 = sc.nextInt();
        boolean first  = (n1>n2 && n1>n3);
        boolean second = (n2>n1 && n2>n3);
        boolean third  = (n3>n1 && n3>n2);
        System.out.println("Is the first number the largest? " + first);
        System.out.println("Is the second number the largest? " + second);
        System.out.println("Is the third number the largest? " + third);
    }
}
