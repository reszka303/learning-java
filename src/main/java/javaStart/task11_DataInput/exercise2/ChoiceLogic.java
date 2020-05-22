package javaStart.task11_DataInput.exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoiceLogic {
    TossUpPrint tossUpPrint = new TossUpPrint();

    int chooseRightChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean error = true;
        do {
            try {
                choice = scanner.nextInt();
                while (choice < 0 || choice > 2) {
                    tossUpPrint.displayIncorrectChoice();
                    tossUpPrint.printMainMenu();
                    choice = scanner.nextInt();
                }
                if (choice == 0 || choice == 1 || choice == 2) {
                    error = false;
                }
            } catch (InputMismatchException e) {
                tossUpPrint.displayCatchException();
                scanner.nextLine();
            }
        } while (error);
        return choice;
    }
}
