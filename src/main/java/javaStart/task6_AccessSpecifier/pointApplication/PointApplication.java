package javaStart.task6_AccessSpecifier.pointApplication;

import javaStart.task6_AccessSpecifier.point.Point;
import javaStart.task6_AccessSpecifier.pointController.PointController;

public class PointApplication {
    public static void main(String[] args) {
        Point point = new Point(12,16);
        PointController pointController = new PointController();

        System.out.println("Points on the beginning: " + point.getX() + " : " + point.getY());
        System.out.println();

        pointController.addX(point);
        System.out.println("Point after addX is: " + point.getX() + " : "+ point.getY());

        pointController.addY(point);
        System.out.println("Point after addY is: " + point.getX() + " : "+ point.getY());

        pointController.minusX(point);
        System.out.println("Point after minusX is: " + point.getX() + " : "+ point.getY());

        pointController.minusY(point);
        System.out.println();
        System.out.println("Point after minusY is: " + point.getX() + " : "+ point.getY());

        pointController.changeObject(point);
        System.out.println("Point: " + point.getX() + " : "+ point.getY());

    }
}
