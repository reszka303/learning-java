package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

public class Car extends VehicleEngine {
    private PersonDatabase personDatabase = new PersonDatabase();
    private int vin;
    private int initialCapacity = 0;

    public Car(String mark, String model, int engineCapacity, String fuel, int vin) {
        super(mark, model, engineCapacity, fuel);
        this.vin = vin;
    }

    public int getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return getMark() + " " + getModel() + " " + getEngineCapacity() + "cm3 " + getFuel() + " " + vin;
    }

    @Override
    public String toCsv() {
        return getMark() + ";" +
                getModel() + ";" +
                getEngineCapacity() + ";" +
                getFuel() + ";" +
                vin + "";
    }
}
