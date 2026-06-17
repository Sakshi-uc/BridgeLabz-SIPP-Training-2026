import java.util.Scanner;

class SumNaturalNumbers {
    
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }
    
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        
        if (number < 1) {
            System.out.println("Please enter a natural number (>= 1).");
            scanner.close();
            return;
        }
        
        int resultRecursion = sumUsingRecursion(number);
        int resultFormula = sumUsingFormula(number);
        
        System.out.println("Sum using recursion: " + resultRecursion);
        System.out.println("Sum using formula n*(n+1)/2: " + resultFormula);
        
        if (resultRecursion == resultFormula) {
            System.out.println("Both results are equal. Computation is correct.");
        } else {
            System.out.println("Results differ. Something is wrong.");
        }
        
        scanner.close();
    }
}
