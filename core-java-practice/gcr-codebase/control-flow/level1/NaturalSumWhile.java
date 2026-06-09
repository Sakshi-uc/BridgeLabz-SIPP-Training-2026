import java.util.Scanner;

public class NaturalSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if(n>0) {
            long formulaSum = (long)n*(n+1)/2;
            long loopSum = 0;
            int i = 1;
            while(i<=n) {
                loopSum += i;
                i++;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Both results match: " + (formulaSum==loopSum));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
