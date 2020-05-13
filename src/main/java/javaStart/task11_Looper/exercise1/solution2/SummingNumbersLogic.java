package javaStart.task11_Looper.exercise1.solution2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SummingNumbersLogic {
    void execute() {
        int declaredNumber = declareHowManyNumbersYouGive();
        giveAsManyNumbersAsYouDeclared(declaredNumber);
    }

    private int declareHowManyNumbersYouGive() {
        System.out.println("How many integers do you want to give?");
        System.out.println("Must declare min 2 integers, max 10 integers");
        int declaredNumber = protectRightChoice();
        System.out.println("You've declared you to give " + declaredNumber + " integers");
        return declaredNumber;
    }

    private int giveAsManyNumbersAsYouDeclared(int declaredNumber) {
        int sumOfNumbers = 0;
        int numbers = 0;
        int count = 1;

        System.out.println("Give " + declaredNumber + " numbers");
        for (int i = 0; i < declaredNumber ; i++) {
            System.out.println("Give " + count + " number");
            numbers = protectRightChoice();
            sumOfNumbers += numbers;
            count++;
        }
        System.out.println("The sum of numbers is as follows: " + sumOfNumbers);
        return sumOfNumbers;
    }

    private int protectRightChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean error = true;
        do {
            try {
                choice = scanner.nextInt();
                while (choice < 2 || choice > 10) {
                    System.out.println("Incorrect choice!");
                    System.out.println("Give a right integer");
                    choice = scanner.nextInt();
                }
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 ||
                        choice == 5 || choice == 6 || choice == 7 || choice == 8 ||
                        choice == 9 || choice == 10) {
                    error = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Can be only integers");
                scanner.nextLine();
            }
        } while (error);
        return choice;
    }
}
