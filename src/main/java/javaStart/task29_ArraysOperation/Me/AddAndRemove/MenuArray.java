package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuArray {
    private static Scanner input = new Scanner(System.in);
    private static int initialCapacity = 4;
    private static Option[] options = new Option[initialCapacity];

    public static void main(String[] args) {
        controlLoop();
    }

    private static void controlLoop() {
        options = create();
        int option;
        do {
            printOptions(options);
            option = getOption();
            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    removePerson();
                    break;
                case 3:
                    printPerson();
                    break;
                case 0:
                    exit();
                    break;
            }
        } while (option != 0);
    }

    private static void addPerson() {
        printLine("You added a new Person");
    }

    private static void removePerson() {
        printLine("You removed the person");
    }

    private static void printPerson() {
        printLine("There are the following persons: ");
    }

    private static void exit() {
        input.close();
        printLine("Exit, bye");
    }

    private static int getOption() {
        boolean valueOk = false;
        int value = 0;
        while (!valueOk) {
            try {
                value = input.nextInt();
                value = createFromInt(value);
                valueOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("You need to enter a digit, try again");
            } finally {
                clearBuffer();
            }
        }
        return value;
    }

    private static int createFromInt(int option) {
        try {
            return options[option].getValue();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("There is no option: " + option);
        }
    }

    private static void printOptions(Option[] options) {
        for (int i = 0; i < options.length; i++) {
            printLine(options[i].toString());
        }
    }

    private static Option[] create() {
        int sizeOptions = 4;
        Option[] options = new Option[sizeOptions];
        options[0] = new Option(0, "Exit");
        options[1] = new Option(1, "Add person");
        options[2] = new Option(2, "Remove person");
        options[3] = new Option(3, "Print person");
        return options;
    }

    private static class Option {
        private int value;
        private String description;

        public Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static class NoSuchOptionException extends RuntimeException {
        public NoSuchOptionException(String message) {
            printLineError(message);
        }
    }

    private static void clearBuffer() {
        input.nextLine();
    }
}
