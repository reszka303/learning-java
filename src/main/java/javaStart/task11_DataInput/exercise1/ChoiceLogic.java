package javaStart.task11_DataInput.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoiceLogic {
    CalculatorPrint calculatorPrint = new CalculatorPrint();

    int protectRightChoiceMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean error = true;
        do {
            try {
                choice = scanner.nextInt();
                while (choice < 0 || choice > 2) {

                    System.out.println("Error! Incorrect choice");
                    calculatorPrint.displayMainMenu();
                    choice = scanner.nextInt();
                }
                if (choice == 0 || choice == 1 || choice == 2) {
                    error = false;
                }
            } catch (InputMismatchException e) {
                calculatorPrint.displayExceptionMessageForChoiceLogic();
                scanner.nextLine();
            }
        } while (error) ;
        return choice;
    }

    int protectRightChoiceCalculationMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean error = true;
        do {
            try {
                choice = scanner.nextInt();
                while (choice < 0 || choice > 5) {
                    System.out.println("Error! Incorrect choice");
                    calculatorPrint.displayCalculationMenu();
                    choice = scanner.nextInt();
                }
                if (choice == 0 || choice == 1 || choice == 2 ||
                        choice == 3 || choice == 4 || choice == 5) {
                    error = false;
                }
            } catch (InputMismatchException e) {
                calculatorPrint.displayExceptionMessageForChoiceLogic();
                scanner.nextLine();
            }
        } while (error);
        return choice;
    }

    int protectRightChoiceMenuAfterCalculation() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean error = true;
        do {
            try {
                choice = scanner.nextInt();
                while (choice < 0 || choice > 2) {
                    System.out.println("Error! Incorrect choice");
                    calculatorPrint.displayMenuAfterCalculation();
                    choice = scanner.nextInt();
                }
                if (choice == 0 || choice == 1 || choice == 2) {
                    error = false;
                }
            } catch (InputMismatchException e) {
                calculatorPrint.displayExceptionMessageForChoiceLogic();
                scanner.nextLine();
            }
        } while (error);
        return choice;
    }
}
