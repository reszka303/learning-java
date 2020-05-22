package javaStart.task6_AccessSpecifier.pointApplication;

import javaStart.task6_AccessSpecifier.point.Point;
import javaStart.task6_AccessSpecifier.pointController.PointController;

public class pointApplicationSwitch {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        PointController pointController = new PointController();

        final int addX = 0;
        final int addY = 1;
        final int minusX = 2;
        final int minusY = 3;

        int option = 0;

        switch (option) {
            case addX:
                pointController.addX(point);
                break;
            case addY:
                pointController.addY(point);
                break;
            case minusX:
                pointController.minusX(point);
                break;
            case minusY:
                pointController.minusY(point);
                break;
            default:
                System.out.println("Wrong value");
        }
        System.out.println("Points are: " + point.getX() + " " + point.getY());
    }
}
