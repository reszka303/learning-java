package javaStart.task10_ArrayMultiDimensional.exercise1;

public class MatrixExecutiveApp {
    public static void main(String[] args) {
        MatrixLogic matrixLogic = new MatrixLogic();
        MatrixPrint matrixPrint = new MatrixPrint();

        double[][] matrix = matrixLogic.createMatrix();
        matrixLogic.randomMatrix(matrix);
        matrixPrint.printArray(matrix);
        matrixPrint.printSumProductPrincipalMatrixDiagonal(matrix);
        matrixPrint.printSumProductSecondaryMatrixDiagonal(matrix);
        matrixPrint.printSumProductsPrincipalAndSecondaryMatrixDiagonal(matrix);
        matrixPrint.printSumMiddleRowMatrix(matrix);
        matrixPrint.printSumMiddleColumnMatrix(matrix);
        matrixPrint.printProductSumMiddleRowAndMiddleColumnMatrix(matrix);
        matrixPrint.printSumBoundaryElementMatrix(matrix);
    }
}
