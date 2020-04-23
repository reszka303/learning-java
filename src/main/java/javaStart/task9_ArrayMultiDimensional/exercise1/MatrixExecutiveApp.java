package javaStart.task9_ArrayMultiDimensional.exercise1;

public class MatrixExecutiveApp {
    public static void main(String[] args) {
        MatrixLogic matrixLogic = new MatrixLogic();

        double[][] matrix = matrixLogic.createMatrix();
        matrixLogic.randomMatrix(matrix);
        matrixLogic.printArray(matrix);

        matrixLogic.calculateProductPrincipalMatrixDiagonal(matrix);
        matrixLogic.printSumProductPrincipalMatrixDiagonal(matrix);

        matrixLogic.calculateProductSecondaryMatrixDiagonal(matrix);
        matrixLogic.printSumProductSecondaryMatrixDiagonal(matrix);

        matrixLogic.calculateSumProductsPrincipalAndSecondaryMatrixDiagonal(matrix);
        matrixLogic.printSumProductsPrincipalAndSecondaryMatrixDiagonal(matrix);

        matrixLogic.calculateSumMiddleRowMatrix(matrix);
        matrixLogic.printSumMiddleRowMatrix(matrix);

        matrixLogic.calculateSumMiddleColumnMatrix(matrix);
        matrixLogic.printSumMiddleColumnMatrix(matrix);

        matrixLogic.printProductSumMiddleRowAndMiddleColumnMatrix(matrix);

        matrixLogic.calculateSumBoundaryElementMatrix(matrix);
        matrixLogic.printSumBoundaryElementMatrix(matrix);
    }
}
