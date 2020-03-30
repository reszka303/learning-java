package javaStart.task1_OperationsOnVariables.exercise3;

public class Application {
    public static void main(String[] args) {
        PlantService plantService = new PlantService();
        Plant plant1 = new Plant("Tulip", 1.8);
        Plant plant2 = new Plant("Cactus", 0.3);

        plantService.printInfo(plant1);
        System.out.println(plantService.dailyWaterIntake(plant1));
        System.out.println(plantService.weeklyWaterIntake(plant1));
        System.out.println(plantService.annualWaterIntake(plant1));
        System.out.println();

        plantService.printInfo(plant2);
        System.out.println(plantService.dailyWaterIntake(plant2));
        System.out.println(plantService.weeklyWaterIntake(plant2));
        System.out.println(plantService.annualWaterIntake(plant2));
    }
}
