import java.util.Scanner;

class ChocolateDistributor {
    public int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = scanner.nextInt();

        ChocolateDistributor distributor = new ChocolateDistributor();
        int[] result = distributor.findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child gets " + result[1] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[0]);
    }
}
