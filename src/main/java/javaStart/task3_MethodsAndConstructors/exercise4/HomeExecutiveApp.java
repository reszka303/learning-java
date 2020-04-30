package javaStart.task3_MethodsAndConstructors.exercise4;

public class HomeExecutiveApp {
    public static void main(String[] args) {
        House home = new House(1000, 1000);
        System.out.println(home.printHome());
        home.takeShower();
        home.makeDinner();
        home.boilWater();
        home.watchTV(10);
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();
        System.out.println(home.printHome());
        home.takeBath();
        home.takeBath();
        home.takeBath();
        System.out.println(home.printHome());
        home.takeBath();
        home.takeBath();
        home.takeBath();
        home.takeBath();

        home.heatHouse(3);
        System.out.println(home.printHome());
        home.heatHouse(1);
        System.out.println(home.printHome());
        home.tankWater(700);
        home.tankOil(800);
        System.out.println(home.printHome());
        home.tankOil(300);
        home.tankWater(301);
        System.out.println(home.printHome());
    }
}
