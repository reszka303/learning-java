package javaStart.task23_AbstractTypes.exercise1.Me;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShapeCalculator {
    Scanner scanner = new Scanner(System.in);

    Shape createShape() {
        menu();
        int shapeType = enterNumber();

        switch (shapeType) {
            case Shape.RECTANGLE:
                return readRectangleData();
            case Shape.CIRCLE:
                return readCircleData();
            case Shape.TRIANGLE:
                return readTriangleData();
            default:
                throw new NoSuchElementException();
        }
    }

    private Rectangle readRectangleData() {
        consolePrinter("Provide information about the" +
                " rectangle");
        consolePrinter("Enter side length A:");
        double a = scanner.nextDouble();
        consolePrinter("Enter side length B:");
        double b = scanner.nextDouble();

        return new Rectangle(a, b);
    }

    private Circle readCircleData() {
        consolePrinter("Provide information about the" +
                " circle");
        consolePrinter("Enter the radius length:");
        double radius = scanner.nextDouble();

        return new Circle(radius);
    }

    private Triangle readTriangleData() {
        consolePrinter("Provide information about the" +
                " triangle");
        consolePrinter("Enter height:");
        double height = scanner.nextDouble();
        consolePrinter("Enter side length A:");
        double a = scanner.nextDouble();
        consolePrinter("Enter side length B:");
        double b = scanner.nextDouble();
        consolePrinter("Enter side length C:");
        double c = scanner.nextDouble();

        return new Triangle(height, a, b, c);
    }

    void consolePrinter(String text) {
        System.out.println(text);
    }

    private int enterNumber() {
        int shapeType = scanner.nextInt();
        return shapeType;
    }

    private void menu() {
        consolePrinter("Select the figure for which you " +
                "want to calculate the area and perimeter");
        consolePrinter("1 - rectangle");
        consolePrinter("2 - circle");
        consolePrinter("3 - triangle");
    }

    void clearBuffer() {
        scanner.nextLine();
    }

    void closeScanner() {
        scanner.close();
    }
}
