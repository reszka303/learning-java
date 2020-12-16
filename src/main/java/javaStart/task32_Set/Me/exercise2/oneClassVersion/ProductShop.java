package javaStart.task32_Set.Me.exercise2.oneClassVersion;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ProductShop {
    private static final int END_OF_PROGRAM = 0;
    private static final int ADD_NEW_PRODUCT = 1;

    private static final int IGNORE_PRODUCT = 0;
    private static final int OVERRIDE_PRODUCT = 1;

    private static Scanner input = new Scanner(System.in);
    private static HashSet<Product> products = new HashSet<>();


    public static void main(String[] args) {
        controlLoop();
    }

    private static void controlLoop() {
        int option;

        do {
            printOption();
            option = getOptionForControlLoop();
            switch (option) {
                case END_OF_PROGRAM:
                    end();
                    break;
                case ADD_NEW_PRODUCT:
                    addNextProduct();
                    break;
            }
        } while (option != END_OF_PROGRAM);
    }

    private static void end() {
        printProduct();
    }

    private static void printProduct() {
        for (Product product : products) {
            printLine(product.toString());
        }

        if (products.isEmpty()) {
            printLine("No products");
        }
    }

    private static void printOption() {
        printLine("Available option: ");
        printLine("> End of program - 0");
        printLine("> Add new product - 1");
        printLine("Choose the option:");
    }

    private static int getOptionForControlLoop() {
        boolean optionOk = false;
        int option = 0;

        while (!optionOk) {
            try {
                option = getIntForControlLoop();
                optionOk = true;
            } catch (InputMismatchException e) {
                printLineError("Enter a number, try again");
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return option;
    }

    private static int getIntForControlLoop() {
        int option = input.nextInt();

        if (option == END_OF_PROGRAM || option == ADD_NEW_PRODUCT) {
            return option;
        } else {
            throw new NoSuchOptionException("There is no option: " + option);
        }
    }

    private static void add(Product product) {
        products.add(product);
        printLine("Product has been added to the database");
    }

    private static void addNextProduct() {
        Product product = create();
        if (products.contains(product)) {
            duplicateLoop(product);
        } else {
            add(product);
        }
    }

    private static void duplicateLoop(Product product) {
        printLine("Product with the same name has been found in the database, " +
                "choose what you want to do");
        printLine("> Ignore the product - 0");
        printLine("> Override the product - 1");
        printLine("Choose the option");

        int option = getOptionForDuplicateLoop();

        switch (option) {
            case IGNORE_PRODUCT:
                printLine("The former product has remained in the database");
                break;
            case OVERRIDE_PRODUCT:
                overrideProduct(product);
                break;
        }
    }

    private static void overrideProduct(Product product) {
        products.remove(product);
        add(product);
    }

    private static int getOptionForDuplicateLoop() {
        boolean optionOk = false;
        int option = 0;

        while (!optionOk) {
            try {
                option = getIntForDuplicateLoop();
                optionOk = true;
            } catch (InputMismatchException e) {
                printLineError("Enter a number, try again");
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return option;
    }

    private static int getIntForDuplicateLoop() {
        int option = input.nextInt();

        if (option == IGNORE_PRODUCT || option == OVERRIDE_PRODUCT) {
            return option;
        } else {
            throw new NoSuchOptionException("There is no option " + option);
        }
    }

    private static class NoSuchOptionException extends RuntimeException {
        public NoSuchOptionException(String message) {
            System.err.println(message);
        }
    }

    private static Product create() {
        printLine("Give a name of product");
        String name = input.nextLine();
        printLine("Give a price of product");
        double price = getPrice();

        return new Product(name, price);
    }

    private static double getPrice() {
        boolean priceOk = false;
        double price = -1;

        while (!priceOk) {
            try {
                price = getDigitOfPrice();
                priceOk = true;
            } catch (InputMismatchException e) {
                printLineError("You need enter a number, try again");
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            }
        }
        return price;
    }

    private static double getDigitOfPrice() {
        int zero = 0;
        double price;

        price = input.nextDouble();
        if (price <= zero) {
            throw new PositiveNumberNotFoundException("Number must be positive and more than zero, try again");
        } else {
            return price;
        }
    }

    private static class PositiveNumberNotFoundException extends RuntimeException {
        public PositiveNumberNotFoundException(String message) {
            System.err.println(message);
        }
    }

    private static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name + " " + price;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static void clearBuffer() {
        input.nextLine();
    }
}
