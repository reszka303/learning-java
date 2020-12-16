package javaStart.task32_Set.Me.exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DataReader {
    private ConsolePrinter printer = new ConsolePrinter();
    private Scanner input = new Scanner(System.in);

    Product create() {
        printer.printLine("Give a name of product");
        String name = input.nextLine();
        printer.printLine("Give a price of product");
        double price = getPrice();

        return new Product(name, price);
    }

    private double getPrice() {
        boolean priceOk = false;
        double price = -1;

        while (!priceOk) {
            try {
                price = getNumber();
                priceOk = true;
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("you need give a number, try again");
            } finally {
                clearBuffer();
            }
        }
        return price;
    }

    private double getNumber() {
        int zero = 0;
        double price;

        price = input.nextDouble();

        if (price <= zero) {
            throw new PositiveNumberNotFoundException("Price must be positive and more than zero, try again");
        } else {
            return price;
        }
    }

    private void clearBuffer() {
        input.nextLine();
    }

    int getInt() {
        try {
           return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}
