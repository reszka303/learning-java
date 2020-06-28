package javaStart.task23_AbstractTypes.exercise1.Me;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ShapeCalculatorControl {
    private ShapeCalculator shapeCalculator = new ShapeCalculator();
    private Shape shape = null;

    void run() {
        calculate();
    }

    private void calculate() {
        boolean error = true;
        while (error) {
            try {
                shape = shapeCalculator.createShape();
                error = false;
            } catch (InputMismatchException e) {
                consolePrinterException("You entered the data in the wrong " +
                        "format, please try again");
            } catch (NoSuchElementException e) {
                consolePrinterException("The selected shape id is " +
                        "invalid, please try again");
            } finally {
                shapeCalculator.clearBuffer();
            }
        }
        System.out.println(shape);
        shapeCalculator.closeScanner();
    }

    private void consolePrinterException(String text) {
        System.err.println(text);
    }
}
