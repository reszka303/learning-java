package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

public abstract class VehicleEngine extends Vehicle {
    private int engineCapacity;
    private String fuel;

    public VehicleEngine(String mark, String model, int engineCapacity, String fuel) {
        super(mark, model);
        this.engineCapacity = engineCapacity;
        this.fuel = fuel;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return getMark() + getModel() + engineCapacity + " " + fuel;
    }
}
