import java.util.Scanner;

public class FactorsOperations {
    public static int[] findFactors(int number) {
        number = Math.abs(number);
        int count = 0;
        for (int divisor = 1; divisor <= number; divisor++) {
            if (number % divisor == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int divisor = 1; divisor <= number; divisor++) {
            if (number % divisor == 0) {
                factors[index++] = divisor;
            }
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int greatest = factors[0];
        for (int factor : factors) {
            if (factor > greatest) {
                greatest = factor;
            }
        }
        return greatest;
    }

    public static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
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
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        int[] factors = findFactors(number);
        displayArray("Factors", factors);
        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + findSum(factors));
        System.out.println("Product of factors: " + findProduct(factors));
        System.out.printf("Product of cubes of factors: %.0f%n", findProductOfCubes(factors));
        input.close();
    }
}
