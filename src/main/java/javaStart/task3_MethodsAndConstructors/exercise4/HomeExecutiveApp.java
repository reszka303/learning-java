package javaStart.task3_MethodsAndConstructors.exercise4;

public class HomeExecutiveApp {
    public static void main(String[] args) {
        House home = new House(1000, 1000);
        HousePrint housePrint = new HousePrint();

        System.out.println(home.infoHome());
        System.out.println();
        System.out.println();

        home.takeShower();
        System.out.println(housePrint.printTakeShower());
        System.out.println(home.infoHome());

        home.makeDinner();
        System.out.println(housePrint.printMakeDinner());
        System.out.println(home.infoHome());

        home.boilWater();
        System.out.println(housePrint.printBoilWater());
        System.out.println(home.infoHome());

        home.watchTV(10);
        System.out.println(housePrint.printWatchTV(10));
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.takeBath();
        System.out.println(housePrint.printTakeBath());
        System.out.println(home.infoHome());

        home.heatHouse(3);
        System.out.println(housePrint.printHeatHouse());
        System.out.println(home.infoHome());

        home.heatHouse(1);
        System.out.println(housePrint.printHeatHouse());
        System.out.println(home.infoHome());

        home.fuelWater(700);
        System.out.println(housePrint.printFuelWater());
        home.fuelOil(800);
        System.out.println(housePrint.printFuelOil());
        System.out.println(home.infoHome());

        home.fuelOil(300);
        System.out.println(housePrint.printFuelOil());
        home.fuelWater(301);
        System.out.println(housePrint.printFuelWater());
        System.out.println(home.infoHome());
    }
}
