package javaStart.task6_AccessSpecifier.pointController;

import javaStart.task6_AccessSpecifier.point.Point;

public class PointController {
    public void addX(Point point) {
        point.setX(point.getX() + 1);
    }

    public void minusX(Point point) {
        point.setX(point.getX() - 1);
    }

    public void addY(Point point) {
        point.setY(point.getY() + 1);
    }

    public void minusY(Point point) {
        point.setY(point.getY() - 1);
    }

    public void changeObject(Point point) {
        point = new Point(-100, - 100);
    }
}
