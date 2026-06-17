import java.util.Scanner;

public class MatrixAdvancedOperations {
    public static int[][] createRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = (int) (Math.random() * 9) + 1;
            }
        }
        return matrix;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                transpose[column][row] = matrix[row][column];
            }
        }
        return transpose;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        int first = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        int second = matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        int third = matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return first - second + third;
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int determinant = determinant2x2(matrix);
        if (determinant == 0) {
            return null;
        }
        return new double[][] {
            { matrix[1][1] / (double) determinant, -matrix[0][1] / (double) determinant },
            { -matrix[1][0] / (double) determinant, matrix[0][0] / (double) determinant }
        };
    }

    public static double[][] inverse3x3(int[][] matrix) {
        int determinant = determinant3x3(matrix);
        if (determinant == 0) {
            return null;
        }

        double[][] inverse = new double[3][3];
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                int[][] minor = getMinor(matrix, row, column);
                int cofactor = (int) Math.pow(-1, row + column) * determinant2x2(minor);
                inverse[column][row] = cofactor / (double) determinant;
            }
        }
        return inverse;
    }

    public static int[][] getMinor(int[][] matrix, int removedRow, int removedColumn) {
        int[][] minor = new int[2][2];
        int minorRow = 0;
        for (int row = 0; row < 3; row++) {
            if (row == removedRow) {
                continue;
            }
            int minorColumn = 0;
            for (int column = 0; column < 3; column++) {
                if (column == removedColumn) {
                    continue;
                }
                minor[minorRow][minorColumn++] = matrix[row][column];
            }
            minorRow++;
        }
        return minor;
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

    public static void displayMatrix(String label, double[][] matrix) {
        System.out.println(label);
        if (matrix == null) {
            System.out.println("Inverse does not exist because determinant is zero.\n");
            return;
        }
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f\t", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix order (2 or 3): ");
        int order = input.nextInt();

        if (order != 2 && order != 3) {
            System.out.println("Only 2x2 and 3x3 matrices are supported.");
            input.close();
            return;
        }

        int[][] matrix = createRandomMatrix(order, order);
        displayMatrix("Matrix", matrix);
        displayMatrix("Transpose", transposeMatrix(matrix));

        if (order == 2) {
            System.out.println("Determinant: " + determinant2x2(matrix));
            displayMatrix("Inverse", inverse2x2(matrix));
        } else {
            System.out.println("Determinant: " + determinant3x3(matrix));
            displayMatrix("Inverse", inverse3x3(matrix));
        }
        input.close();
    }
}
