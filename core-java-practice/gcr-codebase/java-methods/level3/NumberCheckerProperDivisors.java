import java.util.Scanner;

public class NumberCheckerProperDivisors {
    public static int sumProperDivisors(int number) {
        if (number <= 1) {
            return 0;
        }
        int sum = 1;
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                sum += divisor;
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return number > 0 && sumProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return number > 0 && sumProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return number > 0 && sumProperDivisors(number) < number;
    }

    public static int factorial(int digit) {
        int factorial = 1;
        for (int value = 2; value <= digit; value++) {
            factorial *= value;
        }
        return factorial;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        number = Math.abs(number);
        int sum = 0;
        while (number > 0) {
            sum += factorial(number % 10);
            number /= 10;
        }
        return sum == Math.abs(originalNumber);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("Perfect number: " + isPerfectNumber(number));
        System.out.println("Abundant number: " + isAbundantNumber(number));
        System.out.println("Deficient number: " + isDeficientNumber(number));
        System.out.println("Strong number: " + isStrongNumber(number));
        input.close();
    }
}
