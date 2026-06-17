import java.util.Scanner;

class NaturalNumberSumCalculator {
    public int calculateSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number (n): ");
        int n = scanner.nextInt();

        NaturalNumberSumCalculator calculator = new NaturalNumberSumCalculator();
        int sum = calculator.calculateSumOfNaturalNumbers(n);

        System.out.println("The sum of first " + n + " natural numbers is: " + sum);
    }
}
