import java.util.Scanner;

public class NumberCheckerSpecialNumbers {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isNeonNumber(int number) {
        return sumDigits(number * number) == number;
    }

    public static boolean isSpyNumber(int number) {
        number = Math.abs(number);
        int sum = 0;
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int divisor = 10;
        while (divisor <= Math.abs(number)) {
            divisor *= 10;
        }
        return square % divisor == Math.abs(number);
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || Math.abs(number) % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("Prime number: " + isPrime(number));
        System.out.println("Neon number: " + isNeonNumber(number));
        System.out.println("Spy number: " + isSpyNumber(number));
        System.out.println("Automorphic number: " + isAutomorphicNumber(number));
        System.out.println("Buzz number: " + isBuzzNumber(number));
        input.close();
    }
}
