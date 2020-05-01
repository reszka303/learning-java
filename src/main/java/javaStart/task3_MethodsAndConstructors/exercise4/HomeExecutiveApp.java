package javaStart.task3_MethodsAndConstructors.exercise4;

public class HomeExecutiveApp {
    public static void main(String[] args) {
        House home = new House(1000, 1000);
        home.printHome();

        home.takeShower();
        home.makeDinner();
        home.boilWater();
        home.watchTV(10);
        home.printHome();

        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.printHome();

        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.printHome();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.heatHouse(3);
        home.printHome();

        home.heatHouse(1);
        home.printHome();

        home.tankWater(700);
        home.tankOil(800);
        home.printHome();

        home.tankOil(300);
        home.tankWater(301);
        home.printHome();
    }
}
