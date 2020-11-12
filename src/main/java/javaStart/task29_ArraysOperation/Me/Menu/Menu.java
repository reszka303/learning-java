package javaStart.task29_ArraysOperation.Me.Menu;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);

    void run() {
        controlLoop();
    }

    private void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();
            switch (option) {
                case ADD_PERSON:
                    addPerson();
                    break;
                case REMOVE_PERSON:
                    removePerson();
                    break;
                case PRINT_PERSON:
                    printPerson();
                    break;
                case EXIT:
                    exit();
                    break;
                }
        } while (option != Option.EXIT);

    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
              option = Option.createFromInt(getInt());
              optionOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("You need to enter number, try again");
            }
        }
        return option;
    }

    private void printOption() {
        printLine("Choose an option");
        for (Option option: Option.values()) {
            printLine(option.toString());
        }
    }

    private void addPerson() {
        printLine("You have added a new person");
    }

    private void removePerson() {
        printLine("You have removed a person");
    }

    private void printPerson() {
        printLine("You have printed persons");
    }

    private void exit() {
        input.close();
        printLine("The program has been finished");
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_PERSON(1, "Add person"),
        REMOVE_PERSON(2, "Remove person"),
        PRINT_PERSON(3, "Print person");

        private int number;
        private String description;

        Option(int number, String description) {
            this.number = number;
            this.description = description;
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }

        private static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("There is no option: " + option);
            }
        }
    }

    private int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    private void printLine(String text) {
        System.out.println(text);
    }

    private void printLineError(String text) {
        System.err.println(text);
    }
}
