import java.util.Scanner;

class AthleteRoundCalculator {
    public int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceInMeters = 5 * 1000;
        return (int) Math.ceil(distanceInMeters / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side 1 of triangular park (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side 2 of triangular park (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side 3 of triangular park (in meters): ");
        double side3 = scanner.nextDouble();

        AthleteRoundCalculator calculator = new AthleteRoundCalculator();
        int rounds = calculator.calculateRounds(side1, side2, side3);

        System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 km.");
    }
}
