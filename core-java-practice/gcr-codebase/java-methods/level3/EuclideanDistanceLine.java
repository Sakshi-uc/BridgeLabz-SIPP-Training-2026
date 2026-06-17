import java.util.Scanner;

public class EuclideanDistanceLine {
    public static double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[] { slope, intercept };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Enter x2 y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.printf("Euclidean distance: %.2f%n", findDistance(x1, y1, x2, y2));
        if (x1 == x2) {
            System.out.println("Line equation: x = " + x1);
        } else {
            double[] equation = findLineEquation(x1, y1, x2, y2);
            System.out.printf("Line equation: y = %.2fx + %.2f%n", equation[0], equation[1]);
        }
        input.close();
    }
}
