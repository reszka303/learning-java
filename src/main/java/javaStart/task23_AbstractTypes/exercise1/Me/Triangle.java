package javaStart.task23_AbstractTypes.exercise1.Me;

public class Triangle implements Shape {
    private double height;
    private double a;
    private double b;
    private double c;

    public Triangle(double height, double a, double b, double c) {
        this.height = height;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getHeight() {
        return height;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double calculateArea() {
        return a * height / 2;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Triangle, ");
        sb.append("side A: " + a + ", ");
        sb.append("side A: " + b + ", ");
        sb.append("side A: " + c + ", ");
        sb.append("height: " + height + ", ");
        sb.append("area: " + calculateArea() + ", ");
        sb.append("perimeter: " + calculatePerimeter());
        return sb.toString();
    }
}
