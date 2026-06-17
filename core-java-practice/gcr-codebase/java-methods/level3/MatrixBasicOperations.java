import java.util.Scanner;

public class MatrixBasicOperations {
    public static int[][] createRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < first[row].length; column++) {
                result[row][column] = first[row][column] + second[row][column];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < first[row].length; column++) {
                result[row][column] = first[row][column] - second[row][column];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < second[0].length; column++) {
                for (int index = 0; index < first[0].length; index++) {
                    result[row][column] += first[row][index] * second[index][column];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(String label, int[][] matrix) {
        System.out.println(label);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows for first matrix: ");
        int firstRows = input.nextInt();
        System.out.print("Enter columns for first matrix: ");
        int firstColumns = input.nextInt();
        System.out.print("Enter rows for second matrix: ");
        int secondRows = input.nextInt();
        System.out.print("Enter columns for second matrix: ");
        int secondColumns = input.nextInt();

        int[][] first = createRandomMatrix(firstRows, firstColumns);
        int[][] second = createRandomMatrix(secondRows, secondColumns);
        displayMatrix("First matrix", first);
        displayMatrix("Second matrix", second);

        if (firstRows == secondRows && firstColumns == secondColumns) {
            displayMatrix("Addition result", addMatrices(first, second));
            displayMatrix("Subtraction result", subtractMatrices(first, second));
        } else {
            System.out.println("Addition and subtraction need matrices of the same size.\n");
        }

        if (firstColumns == secondRows) {
            displayMatrix("Multiplication result", multiplyMatrices(first, second));
        } else {
            System.out.println("Multiplication needs first columns equal to second rows.");
        }
        input.close();
    }
}
