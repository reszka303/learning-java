package javaStart.task9_ArrayMultiDimensional.exercise1;

public class MatrixPrint {
    MatrixLogic matrixLogic = new MatrixLogic();

    public void printArray(double[][] matrix) {
        System.out.println("Array two-dimensional(Matrix) is as follows:");
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void printSumProductPrincipalMatrixDiagonal(double[][] matrix) {
        System.out.println("A product of the principal" +
                " matrix diagonal is as follows: " +
                matrixLogic.calculateProductPrincipalMatrixDiagonal(matrix));
    }

    public void printSumProductSecondaryMatrixDiagonal(double[][] matrix) {
        System.out.println("A product of the secondary" +
                " matrix diagonal is as follows: " +
                matrixLogic.calculateProductSecondaryMatrixDiagonal(matrix));
    }

    public void printSumProductsPrincipalAndSecondaryMatrixDiagonal(double[][] matrix) {
        System.out.println("A sum of the products of the principal and" +
                " secondary matrix diagonal is as follows: " +
                matrixLogic.calculateSumProductsPrincipalAndSecondaryMatrixDiagonal(matrix));
    }

    public void printSumMiddleRowMatrix(double[][] matrix) {
        System.out.println("A sum of the middle row " +
                "of the matrix is as follows: " +
                matrixLogic.calculateSumMiddleRowMatrix(matrix));
    }

    public void printSumMiddleColumnMatrix(double[][] matrix) {
        System.out.println("A sum of the middle column " +
                "of the matrix is as follows: " +
                matrixLogic.calculateSumMiddleColumnMatrix(matrix));
    }

    public void printProductSumMiddleRowAndMiddleColumnMatrix(double[][] matrix) {
        System.out.println("Product of the sums of the middle row and" +
                " the middle column of the matrix is as follows: " +
                matrixLogic.calculateProductSumMiddleRowAndMiddleColumnMatrix(matrix));
    }

    public void printSumBoundaryElementMatrix(double[][] matrix) {
        System.out.println("A sum of boundary of the matrix is as follows: " +
                matrixLogic.calculateSumBoundaryElementMatrix(matrix));
    }
}
