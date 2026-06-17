import java.util.Scanner;

public class StudentMarksScorecard {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for (int row = 0; row < students; row++) {
            for (int column = 0; column < scores[row].length; column++) {
                scores[row][column] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }

    public static double roundToTwoDigits(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int row = 0; row < scores.length; row++) {
            int total = scores[row][0] + scores[row][1] + scores[row][2];
            double average = roundToTwoDigits(total / 3.0);
            double percentage = roundToTwoDigits((total / 300.0) * 100.0);
            results[row][0] = total;
            results[row][1] = average;
            results[row][2] = percentage;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int row = 0; row < scores.length; row++) {
            System.out.println((row + 1) + "\t" + scores[row][0] + "\t" + scores[row][1]
                    + "\t\t" + scores[row][2] + "\t" + (int) results[row][0] + "\t"
                    + results[row][1] + "\t" + results[row][2]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        input.close();
    }
}
