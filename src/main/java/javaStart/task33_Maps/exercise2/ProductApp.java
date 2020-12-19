package javaStart.task33_Maps.exercise2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProductApp {

    private static final String fileName = "D:\\INNE\\Programowanie\\Projects\\learning\\products.txt";
    private static final String COMMA_DELIMITER = ";";

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ProductControl.run();
    }

    private static class ProductControl {
        private static void run() {
            try {
                Map<String, TreeSet<Product>> productsMap = readFile();
                String category = readCategoryFromUser();
                printCategoryStats(productsMap, category);
            } catch (DataReadException e) {
                e.getMessage();
            }
        }

        private static Map<String, TreeSet<Product>> readFile() {
            try {
                Map<String, TreeSet<Product>> productsMap = ProductReader.createFromTxt(fileName);
                return productsMap;
            } catch (FileNotFoundException e) {
                throw new DataReadException("No file " + fileName);
            } catch (IOException e) {
                throw new DataReadException("Error data file" + fileName);
            }
        }

        private static String readCategoryFromUser() {
            printLine("Enter a name of category to display statistics");
            printLine("Enter: rtv, biuro or komputery");
            return input.nextLine();
        }

        private static void printCategoryStats(Map<String, TreeSet<Product>> productsMap, String category) {
            TreeSet<Product> products = productsMap.get(category);
            if (products == null)
            printLine("There is none products in given category");
            else {
                printLine("");
                printAll(products);
                printAvgPrice(products);
                printCheapestAndExpensiveProduct(products);
            }
        }

        private static void printAll(TreeSet<Product> productsSet) {
            for (Product product : productsSet) {
                printLine(product.toString());
            }
        }

        private static void printAvgPrice(TreeSet<Product> productsSet) {
            double sum = 0;
            double average;

            for (Product product : productsSet) {
                sum += product.getPrice();
            }
            average = sum/productsSet.size();
            printLine("");
            printLine("The average price of products is: " + String.format("%.2f", average));
        }

        private static void printCheapestAndExpensiveProduct(TreeSet<Product> productsSet) {
           printLine("The cheapest product: " + productsSet.first());
           printLine("The most expensive product: " + productsSet.last());
        }
    }

    private static class DataReadException extends RuntimeException {
        public DataReadException(String message) {
            printLineError(message);
        }
    }

    private static class ProductReader {
        private static Map<String, TreeSet<Product>> createFromTxt(String fileName) throws IOException {
            Map<String, TreeSet<Product>> productsMap = new HashMap<>();
            try (var br = new BufferedReader(new FileReader(fileName));) {
                br.readLine();
                String line;

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(COMMA_DELIMITER);
                    String category = data[0];
                    Product product = new Product(data[1], Double.parseDouble(data[2]));
                    insertProductIntoMap(productsMap, category, product);
                }
            }
            return productsMap;
        }

        private static void insertProductIntoMap(Map<String, TreeSet<Product>> productsMap, String category, Product product) {
            if (productsMap.containsKey(category))
                productsMap.get(category).add(product);
            else {
                TreeSet<Product> productsSet = new TreeSet<>();
                productsSet.add(product);
                productsMap.put(category, productsSet);
            }
        }
    }

    private static class Product implements Comparable<Product> {
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
            return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        @Override
        public String toString() {
            return name + " " + price;
        }

        @Override
        public int compareTo(Product p) {
            return Double.compare(this.price, p.price);
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
