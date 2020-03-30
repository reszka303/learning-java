package javaStart.task1_OperationsOnVariables.exercise3;

public class PlantService {
    public double dailyWaterIntake(Plant plant) {
        double waterIntake = plant.getWaterDemand();
        return waterIntake;
    }

    public double weeklyWaterIntake(Plant plant) {
        double waterIntake = 7;
        return waterIntake *= plant.getWaterDemand();
    }

    public double annualWaterIntake(Plant plant) {
        double waterIntake = 365.0;
        return waterIntake *= plant.getWaterDemand();
    }

    public void printInfo(Plant plant) {
        System.out.println(plant.getName() + " water intake in liters daily/weekly/annual are: ");
    }

}
