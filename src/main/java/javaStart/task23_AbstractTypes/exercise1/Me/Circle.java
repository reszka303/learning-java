package javaStart.task23_AbstractTypes.exercise1.Me;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        return radius * radius * Shape.PI;
    }

    @Override
    public double calculatePerimeter() {
        return radius * 2 * Shape.PI;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circle, ");
        sb.append("radius " + radius + ", ");
        sb.append("Area: " + calculateArea() + ", ");
        sb.append("Perimeter: " + calculatePerimeter());
        return sb.toString();
    }
}
