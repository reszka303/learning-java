package javaStart.task32_Set.Me.exercise2;

import java.util.InputMismatchException;
import java.util.Set;

public class ProductControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private ProductManager productManager = new ProductManager();

    void run() {
        controlLoop();
    }

    private void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();
            switch (option) {
                case ADD_NEW_PRODUCT:
                    addNextProduct();
                    break;
                case END_OF_PROGRAM:
                    printProduct();
                    break;
            }
        } while (option != Option.END_OF_PROGRAM);
    }

    private void addNextProduct() {
        productManager.addNextProduct();
    }

    private void printProduct() {
        Set<Product> products = productManager.getProducts();
        printer.printProduct(products);
    }

    private void printOption() {
        printer.printLine("Available options:");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
        printer.printLine("Choose option:");
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a number, try again");
            }
        }
        return option;
    }

    private enum Option {
        END_OF_PROGRAM(0, "END OF PROGRAM"),
        ADD_NEW_PRODUCT(1, "ADD NEW PRODUCT");

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

        static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No option " + option);
            }
        }
    }
}
