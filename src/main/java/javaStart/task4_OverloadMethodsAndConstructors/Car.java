package javaStart.task4_OverloadMethodsAndConstructors;

public class Car {
    int year;
    String brand;
    String model;
    String color;

    public Car(int year, String brand, String model) {

        this.year = year;
        this.brand = brand;
        this.model = model;
    }

    public Car(int year, String brand, String model, String color) {
        this(year, brand, model);
        this.color = color;
    }

    void printInfo() {
        System.out.println(year + " " + brand + " " + model + " " + color);
    }
}

