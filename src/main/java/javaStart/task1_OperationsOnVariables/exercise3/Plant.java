package javaStart.task1_OperationsOnVariables.exercise3;

public class Plant {
    private String name;
    private double waterDemand;

    public Plant(String name, double waterDemand) {
        this.name = name;
        this.waterDemand = waterDemand;
    }

    public String getName() {
        return name;
    }

    public double getWaterDemand() {
        return waterDemand;
    }
}
