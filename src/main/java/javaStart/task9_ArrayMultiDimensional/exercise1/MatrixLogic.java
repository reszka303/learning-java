package javaStart.task9_ArrayMultiDimensional.exercise1;

import java.util.Random;

public class MatrixLogic {
    public double[][] createMatrix() {
        Matrix matrix = new Matrix(new double[5][5]);
        double[][] array = matrix.getMatrix();
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

    public void printArray(double[][] matrix) {
        System.out.println("Array two-dimensional(Matrix) is as follows:");
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
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

    public void printSumProductPrincipalMatrixDiagonal(double[][] matrix) {
        System.out.println("A product of the principal" +
                " matrix diagonal is as follows: " +
                calculateProductPrincipalMatrixDiagonal(matrix));
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

    public void printSumProductSecondaryMatrixDiagonal(double[][] matrix) {
        System.out.println("A product of the secondary" +
                " matrix diagonal is as follows: " +
                calculateProductSecondaryMatrixDiagonal(matrix));
    }

    public double calculateSumProductsPrincipalAndSecondaryMatrixDiagonal(double[][] matrix) {
        double sumTwoMatrixDiagonal =
                calculateProductPrincipalMatrixDiagonal(matrix) +
                calculateProductSecondaryMatrixDiagonal(matrix);
        return sumTwoMatrixDiagonal;
    }

    public void printSumProductsPrincipalAndSecondaryMatrixDiagonal(double[][] matrix) {
        System.out.println("A sum of the products of the principal and" +
                " secondary matrix diagonal is as follows: " +
                calculateSumProductsPrincipalAndSecondaryMatrixDiagonal(matrix));
    }

    public double calculateSumMiddleRowMatrix(double[][] matrix) {
        double rowSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            rowSum += matrix[matrix.length / 2][i];
        }
        return rowSum;
    }

    public void printSumMiddleRowMatrix(double[][] matrix) {
        System.out.println("A sum of the middle row " +
                "of the matrix is as follows: " +
                calculateSumMiddleRowMatrix(matrix));
    }

    public double calculateSumMiddleColumnMatrix(double[][] matrix) {
        double columnSum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            columnSum += matrix[i][matrix.length / 2];
        }
        return columnSum;
    }

    public void printSumMiddleColumnMatrix(double[][] matrix) {
        System.out.println("A sum of the middle column " +
                "of the matrix is as follows: " +
                calculateSumMiddleColumnMatrix(matrix));
    }

    public double calculateProductSumMiddleRowAndMiddleColumnMatrix(double[][] matrix) {
        double productSumMiddleRowAndColumnMatrix =
                calculateSumMiddleRowMatrix(matrix) *
                        calculateSumMiddleColumnMatrix(matrix);
        return productSumMiddleRowAndColumnMatrix;
    }

    public void printProductSumMiddleRowAndMiddleColumnMatrix(double[][] matrix) {
        System.out.println("Product of the sums of the middle row and" +
                " the middle column of the matrix is as follows: " +
                calculateProductSumMiddleRowAndMiddleColumnMatrix(matrix));
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

    public void printSumBoundaryElementMatrix(double[][] matrix) {
        System.out.println("A sum of boundary of the matrix is as follows: " +
                calculateSumBoundaryElementMatrix(matrix));
    }
}
