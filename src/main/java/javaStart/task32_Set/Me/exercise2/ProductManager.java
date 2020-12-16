package javaStart.task32_Set.Me.exercise2;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class ProductManager {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private Set<Product> products = new HashSet<>();

    Set<Product> getProducts() {
        return products;
    }

    void add(Product product) {
        products.add(product);
        printer.printLine("Product has been added to the database");
    }

    void addNextProduct() {
        Product product = dataReader.create();
        if (products.contains(product)) {
            duplicateControlLoop(product);
        } else {
            add(product);
        }
    }

    private enum DuplicateOption {
        IGNORE_PRODUCT(0, "IGNORE PRODUCT"),
        OVERRIDE_PRODUCT(1, "OVERRIDE PRODUCT");

        private int value;
        private String description;

        DuplicateOption(int value, String description) {
            this.value = value;
            this.description = description;
        }

        static DuplicateOption createFromInt(int option) {
            try {
                return DuplicateOption.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("There is no option: " + option);
            }
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }
    }

    private DuplicateOption getDuplicateOption() {
        boolean optionOk = false;
        DuplicateOption option = null;

        while (!optionOk) {
            try {
                option = DuplicateOption.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a number, try again");
            }
        }
        return option;
    }

    private void printDuplicateOption() {
        for (DuplicateOption option: DuplicateOption.values()) {
            printer.printLine(option.toString());
        }
    }

    private void duplicateControlLoop(Product product) {
        printer.printLine("Product with the such name has been found in the database," +
                " what you want to do");
        DuplicateOption option;

        printDuplicateOption();
        option = getDuplicateOption();
        switch (option) {
            case IGNORE_PRODUCT:
                ignoreProduct();
                break;
            case OVERRIDE_PRODUCT:
                overrideProduct(product);
                break;
            }
    }

    private void overrideProduct(Product product) {
        products.remove(product);
        add(product);
    }

    private void ignoreProduct() {
        printer.printLine("Former product has remained in the database");
    }
}
