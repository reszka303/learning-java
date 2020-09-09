package javaStart.task26_Recursion.Me.exercise2.io;

import javaStart.task26_Recursion.Me.exercise2.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        scanner.close();
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    void clearBuffer() {
        scanner.nextLine();
    }

    public Product readAndCreateProduct() {
        printer.printLine("Give name of a product");
        String name = getString();
        printer.printLine("Give price of a product");
        double price = readPositiveNumber();

        return new Product(name, price);
    }

    private double readPositiveNumber() {
        double number = -1;
        while (number <= 0) {
            try {
                number = scanner.nextDouble();
                if (number < 0) {
                    printer.printLineError("Number must be positive, " +
                            "try again");
                } else if (number == 0) {
                    printer.printLineError("Can't be zero, try again");
                }
            } catch (InputMismatchException e) {
                printer.printLineError("You must enter a number, try again");
            } finally {
                clearBuffer();
            }
        }
        return number;
    }
}
