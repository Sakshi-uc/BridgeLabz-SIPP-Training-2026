import java.util.Scanner;

class RemainderQuotientCalculator {
    public int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        RemainderQuotientCalculator calculator = new RemainderQuotientCalculator();
        int[] result = calculator.findRemainderAndQuotient(number, divisor);

        System.out.println("Quotient: " + result[1]);
        System.out.println("Remainder: " + result[0]);
    }
}
