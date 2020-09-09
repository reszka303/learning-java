package javaStart.task26_Recursion.Me.exercise2.app;

import javaStart.task26_Recursion.Me.exercise2.exception.NoSuchOptionException;
import javaStart.task26_Recursion.Me.exercise2.io.ConsolePrinter;
import javaStart.task26_Recursion.Me.exercise2.io.DataReader;
import javaStart.task26_Recursion.Me.exercise2.model.Cart;
import javaStart.task26_Recursion.Me.exercise2.model.Product;

import java.util.InputMismatchException;

public class CartControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Cart cart = new Cart();

    void run() {
        controlLoop();
    }

    private void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();
            switch (option) {
                case ADD_PRODUCT:
                    addProducts();
                    break;
                case PRINT_TOTAL_PRICES:
                    printTotalPrice();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("There is no option");
            }
        } while (option != Option.EXIT);

    }

    private void printOption() {
        printer.printLine("Choose option");
        for (Option option:
                Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", give again:");
            } catch (InputMismatchException e) {
                printer.printLine("You entered a value that " +
                        "is not a number, please enter again:");
            }
        }
        return option;
    }

    private void addProducts() {
        try {
            Product product = dataReader.readAndCreateProduct();
            cart.addProduct(product);
        } catch (InputMismatchException e) {
            printer.printLineError("Product hasn't been created," +
                    " incorrect data");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLineError("The limit has been reached, " +
                    "can't add a new product");
        }
    }

    private void printTotalPrice() {
        double price = cart.totalPrice();
        printer.printTotalPrice(price);
    }

    private void exit() {
        dataReader.close();
        printer.printLine("End of program");
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_PRODUCT(1, "Add product"),
        PRINT_TOTAL_PRICES(2, "Print total prices");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No option with: " + option);
            }
        }
    }
}
