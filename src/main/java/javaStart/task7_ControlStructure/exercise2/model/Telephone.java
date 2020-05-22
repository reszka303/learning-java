package javaStart.task7_ControlStructure.exercise2.model;

import java.util.Random;

public class Telephone {
    private String brand;
    private String model;
    private int batteryCapacity;
    private int chargeLevel;

    public Telephone(String brand, String model, int batteryCapacity, int chargeLevel) {
        Random random = new Random();
        this.brand = brand;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
        this.chargeLevel = chargeLevel;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    public String getInfo() {
         return  "Information about telephone are: " + "\n"
                + "Brand: " + getBrand() + "\n"
                + "Model: " + getModel() + "\n"
                + "Battery: " + getBatteryCapacity() + " mAh" + "\n"
                + "Charge level: " + getChargeLevel() + "%" + "\n";
    }
}
