package javaStart.task13_StaticComponents.exercise3;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car(
                10,
                true,
                true,
                false,
                false);

        System.out.println("Everything is functional");
        car.start();
        System.out.println(car.status());
        System.out.println();

        System.out.println("Doors are opened");
        car.start();
        car.setDoorsOpen(true);
        System.out.println(car.status());
        System.out.println();

        System.out.println("No fuel");
        car.start();
        car.setFuel(0);
        System.out.println(car.status());
        System.out.println();
    }
}
