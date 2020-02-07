package javaStart.data;

public class Car {
    private int year;
    private String brand;
    private String model;
    private String color;

    // konstruktor1
    public Car(int year, String brand, String model, String color) {
        this(year, brand, model);
        this.color = color;
    }

    // konstruktor2
    public Car(int year, String brand, String model) {
        this.year = year;
        this.brand = brand;
        this.model = model;
    }

    public void print() {
        System.out.println(brand + " " + model + " " + color + " " + year);
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setYear(int year) {
        //ustawiamy nową wartość year jeżeli jest ona większa od 0
        if(year > 0) {
            this.year = year;
        } else { //jeśli ktoś przekaże liczbę mniejszą lub równą zero, wyświetlamy komunikat
            System.out.println("Rok musi być większy od 0!");
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
