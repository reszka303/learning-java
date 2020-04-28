package javaStart.task9_ArrayMultiDimensional.exercise1;

import java.util.Random;

public class MatrixLogic {
    public double[][] createMatrix() {
        double[][] array = new double[5][5];
        return array;
    }

    public double[][] randomMatrix(double[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                matrix[i][j] = random.nextInt(9) + 1;
            }
        }
        return matrix;
    }

    public double calculateProductPrincipalMatrixDiagonal(double[][] matrix) {
        double diagonalSum = 1;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if (i == j) {
                    diagonalSum *= matrix[i][j];
                }
            }
        }
        return diagonalSum;
    }

    public double calculateProductSecondaryMatrixDiagonal(double[][] matrix) {
        double diagonalSum = 1;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if ((i + j) == (matrix.length - 1)) {
                    diagonalSum *= matrix[i][j];
                }
            }
        }
        return diagonalSum;
    }

    public double calculateSumProductsPrincipalAndSecondaryMatrixDiagonal(double[][] matrix) {
        double sumTwoMatrixDiagonal =
                calculateProductPrincipalMatrixDiagonal(matrix) +
                calculateProductSecondaryMatrixDiagonal(matrix);
        return sumTwoMatrixDiagonal;
    }

    public double calculateSumMiddleRowMatrix(double[][] matrix) {
        double rowSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            rowSum += matrix[matrix.length / 2][i];
        }
        return rowSum;
    }

    public double calculateSumMiddleColumnMatrix(double[][] matrix) {
        double columnSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            columnSum += matrix[i][matrix.length / 2];
        }
        return columnSum;
    }

    public double calculateProductSumMiddleRowAndMiddleColumnMatrix(double[][] matrix) {
        double productSumMiddleRowAndColumnMatrix =
                calculateSumMiddleRowMatrix(matrix) *
                        calculateSumMiddleColumnMatrix(matrix);
        return productSumMiddleRowAndColumnMatrix;
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
        return boundarySum;
    }
}
