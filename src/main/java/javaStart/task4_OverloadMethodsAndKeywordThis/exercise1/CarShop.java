package javaStart.task4_OverloadMethodsAndKeywordThis.exercise1;

public class CarShop {
    public static void main(String[] args) {
        Car car1 = new Car(2017, "Audi", "A5", "Czarny");
        Car car2 = new Car(2016, "BMW", "3");

        car1.printInfo();
        car2.printInfo();
    }
}
