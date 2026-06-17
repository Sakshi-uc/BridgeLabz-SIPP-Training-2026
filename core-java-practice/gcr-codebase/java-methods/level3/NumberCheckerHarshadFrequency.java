import java.util.Scanner;

public class NumberCheckerHarshadFrequency {
    public static int countDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        number = Math.abs(number);
        int[] digits = new int[countDigits(number)];
        for (int index = digits.length - 1; index >= 0; index--) {
            digits[index] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumDigits(digits);
        return sum != 0 && Math.abs(number) % sum == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int digit = 0; digit <= 9; digit++) {
            frequency[digit][0] = digit;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }

    public static void displayFrequency(int[][] frequency) {
        System.out.println("Digit\tFrequency");
        for (int row = 0; row < frequency.length; row++) {
            if (frequency[row][1] > 0) {
                System.out.println(frequency[row][0] + "\t" + frequency[row][1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = storeDigits(number);
        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Sum of digits: " + sumDigits(digits));
        System.out.println("Sum of squares of digits: " + sumSquaresOfDigits(digits));
        System.out.println("Harshad number: " + isHarshadNumber(number, digits));
        displayFrequency(findDigitFrequency(digits));
        input.close();
    }
}
