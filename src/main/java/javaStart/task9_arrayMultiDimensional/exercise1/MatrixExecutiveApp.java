package javaStart.task9_arrayMultiDimensional.exercise1;

public class MatrixExecutiveApp {
    public static void main(String[] args) {
        MatrixLogic matrixLogic = new MatrixLogic();

        double[][] numbers = matrixLogic.createMatrix();
        matrixLogic.printArray(numbers);
        matrixLogic.calculatePrincipalMatrixDiagonal(numbers);
        matrixLogic.calculateSecondaryMatrixDiagonal(numbers);
        matrixLogic.calculateSumMiddleRowMatrix(numbers);
        matrixLogic.calculateSumMiddleColumnMatrix(numbers);
        matrixLogic.calculateSumBoundaryElementMatrix(numbers);
    }
}
