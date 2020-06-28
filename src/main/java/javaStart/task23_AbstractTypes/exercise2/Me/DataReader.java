package javaStart.task23_AbstractTypes.exercise2.Me;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private ConsolePrinter printer;
    private Scanner scanner = new Scanner(System.in);

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    EmployeeFullTime createEmployeeFullTime() {
        printer.printLine("Give a first name");
        String firstName = scanner.nextLine();
        printer.printLine("Give a last name");
        String lastName = scanner.nextLine();
        printer.printLine("Give an id");
        String id = scanner.nextLine();
        printer.printLine("Give a hourly rate");
        double hourlyRate = readPositiveNumber();

        return new EmployeeFullTime(firstName, lastName, id, hourlyRate);
    }

    EmployeePartTimer createEmployeePartTimer() {
        printer.printLine("Give a first name");
        String firstName = scanner.nextLine();
        printer.printLine("Give a last name");
        String lastName = scanner.nextLine();
        printer.printLine("Give an id");
        String id = scanner.nextLine();
        printer.printLine("Give work hours");
        double workHours = readPositiveNumber();
        printer.printLine("Give a hourly rate");
        double hourlyRate = readPositiveNumber();

        return new EmployeePartTimer(firstName, lastName, id, workHours,
                hourlyRate);
    }

    private double readPositiveNumber() {
        double number = -1;
        while (number < 0) {
            try {
                number = scanner.nextDouble();
                if (number < 0) {
                    printer.printLineError("The number must be positive");
                }
            } catch (InputMismatchException e) {
                printer.printLineError("You must enter a number, try again.");
            } finally {
                clearBuffer();
            }
        }
        return number;
    }

    int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    void clearBuffer() {
        scanner.nextLine();
    }

    void close() {
        scanner.close();
    }
}
