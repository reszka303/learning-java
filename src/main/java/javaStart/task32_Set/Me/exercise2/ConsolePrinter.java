package javaStart.task32_Set.Me.exercise2;

import java.util.Set;

public class ConsolePrinter {

    void printProduct(Set<Product> products) {
        for (Product product : products) {
            printLine(product.toString());
        }

        if (products.isEmpty()) {
            printLine("No products");
        }
    }

    void printLine(String text) {
        System.out.println(text);
    }

    void printLineError(String text) {
        System.err.println(text);
    }
}
