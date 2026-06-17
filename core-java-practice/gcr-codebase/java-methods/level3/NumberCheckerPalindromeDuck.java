import java.util.Scanner;

public class NumberCheckerPalindromeDuck {
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

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            reversed[index] = array[array.length - 1 - index];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int index = 0; index < first.length; index++) {
            if (first[index] != second[index]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        return areArraysEqual(digits, reverseArray(digits));
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int index = 1; index < digits.length; index++) {
            if (digits[index] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void displayArray(String label, int[] array) {
        System.out.print(label + ": ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = storeDigits(number);
        int[] reversedDigits = reverseArray(digits);

        displayArray("Digits", digits);
        displayArray("Reversed digits", reversedDigits);
        System.out.println("Palindrome number: " + isPalindrome(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));
        input.close();
    }
}
