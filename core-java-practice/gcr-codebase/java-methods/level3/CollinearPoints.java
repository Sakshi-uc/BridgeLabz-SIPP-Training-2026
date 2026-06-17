import java.util.Scanner;

public class CollinearPoints {
    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2,
            double x3, double y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2,
            double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Enter x2 y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.print("Enter x3 y3: ");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        System.out.println("Collinear by slope formula: "
                + areCollinearBySlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by area formula: "
                + areCollinearByArea(x1, y1, x2, y2, x3, y3));
        input.close();
    }
}
