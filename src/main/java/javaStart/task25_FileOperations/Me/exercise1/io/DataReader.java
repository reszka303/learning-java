package javaStart.task25_FileOperations.Me.exercise1.io;

import javaStart.task25_FileOperations.Me.exercise1.model.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private ConsolePrinter printer;
    private Scanner scanner = new Scanner(System.in);

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Employee createEmployee() {
        printer.printLine("Give name");
        String name = scanner.nextLine();
        printer.printLine("Give surname");
        String surname = scanner.nextLine();
        printer.printLine("Give id");
        String id = scanner.nextLine();
        printer.printLine("Give salary");
        double salary = readPositiveNumber();

        return new Employee(name, surname, id, salary);
    }

    double readPositiveNumber() {
        double number = -1;
        while (number < 0) {
            try {
                number = scanner.nextDouble();
                if (number < 0) {
                    printer.printLineError("Number must be positive");
                }
            } catch (InputMismatchException e) {
                printer.printLineError("You need to give an integer");
            } finally {
                clearBuffer();
            }
        }
        return number;
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    void clearBuffer() {
        scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
