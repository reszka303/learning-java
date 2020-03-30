package javaStart.task1_OperationsOnVariables.exercise3;

public class Application {
    public static void main(String[] args) {
        PlantService plantService = new PlantService();
        Plant plant1 = new Plant("Tulip", 0.8);

        plantService.printInfo(plant1);
        System.out.println(plantService.annualWaterIntake(plant1));
    }
}
