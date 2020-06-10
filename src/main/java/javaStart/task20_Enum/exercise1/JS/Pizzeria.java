package javaStart.task20_Enum.exercise1.JS;

import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        System.out.println("Pizzas available:");
        for (Pizza pizza:
             Pizza.values()) {
            System.out.println(pizza);
        }

        System.out.println("Which ones do you want to order?");
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = Pizza.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Thank you. You've chosen " + pizza.name());
        scanner.close();
    }
}
