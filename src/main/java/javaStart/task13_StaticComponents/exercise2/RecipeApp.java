package javaStart.task13_StaticComponents.exercise2;

import java.util.Scanner;

public class RecipeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give number of glasses");
        double waterGlasses = scanner.nextDouble();

        System.out.println("Give number of spoon");
        double oilSpoons = scanner.nextDouble();

        System.out.println("Give number of teaspoon");
        double honeyTeaspoons = scanner.nextDouble();

        double water = Recipe.countGlass(waterGlasses);
        double oil = Recipe.countSpoon(oilSpoons);
        double honey = Recipe.countTeaspoon(honeyTeaspoons);

        System.out.println("To make a recipe you need:");
        System.out.println(waterGlasses + " glasses, meaning " + water +
                " milliliters of water");
        System.out.println(oilSpoons + " spoons, meaning " + oil +
                " milliliters of oil");
        System.out.println(honeyTeaspoons + " teaspoons, meaning " + honey +
                " milliliters of honey");
    }
}
