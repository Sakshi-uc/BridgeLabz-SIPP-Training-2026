import java.util.Scanner;

class HandshakeCalculator {
    public int calculateMaximumHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        HandshakeCalculator calculator = new HandshakeCalculator();
        int maxHandshakes = calculator.calculateMaximumHandshakes(numberOfStudents);

        System.out.println("The maximum number of possible handshakes is: " + maxHandshakes);
    }
}
