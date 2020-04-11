package javaStart.task9_arrayMultiDimensional.exercise1;

public class MatrixLogic {
    public double[][] createMatrix() {
        double[][] matrix = new double[3][3];
        matrix[0][0] = 1.0;
        matrix[0][1] = 1.5;
        matrix[0][2] = 2.0;
        matrix[1][0] = 1.5;
        matrix[1][1] = 2.0;
        matrix[1][2] = 2.5;
        matrix[2][0] = 2.0;
        matrix[2][1] = 2.5;
        matrix[2][2] = 3.0;
        return matrix;
    }

    public void printArray(double[][] matrix) {
        System.out.println("Array two-dimensional(Matrix) is as follows:");
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    public double calculatePrincipalMatrixDiagonal(double[][] matrix) {
        double diagonalSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }
        System.out.println("A sum of products of the principal" +
                " matrix diagonal is: " + diagonalSum);
        return diagonalSum;
    }

    public double calculateSecondaryMatrixDiagonal(double[][] matrix) {
        double diagonalSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if ((i + j) == (matrix.length - 1)) {
                    diagonalSum += matrix[i][j];
                }
            }
        }
        System.out.println("A sum of products of the secondary" +
                " matrix diagonal is: " + diagonalSum);
        return diagonalSum;
    }

    public double calculateSumMiddleRowMatrix(double[][] matrix) {
        double rowSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            rowSum += matrix[matrix.length / 2][i];
        }
        System.out.println("A sum of the product of the middle row " +
                "of the matrix is: " + rowSum);
        return rowSum;
    }

    public double calculateSumMiddleColumnMatrix(double[][] matrix) {
        double columnSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            columnSum += matrix[i][matrix.length / 2];
        }
        System.out.println("A sum of the product of the middle column " +
                "of the matrix is: " + columnSum);
        return columnSum;
    }

    public double calculateSumBoundaryElementMatrix(double[][] matrix) {
        double boundarySum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix.length - 1) {
                    boundarySum += matrix[i][j];
                }
            }
        }
        System.out.println("A sum of boundary of the matrix is: " + boundarySum);
        return boundarySum;
    }
}
