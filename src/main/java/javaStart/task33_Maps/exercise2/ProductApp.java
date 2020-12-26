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
                    Product product = createProduct(line);
                    insertProductIntoMap(productsMap, product.getCategory(), product);
                }
            }
            return productsMap;
        }

        private static Product createProduct(String line) {
            String[] data = line.split(COMMA_DELIMITER);
            String category = data[0];
            String name = data[1];
            double price = Double.valueOf(data[2]);

            return new Product(category, name, price);
        }

        private static void insertProductIntoMap(Map<String, TreeSet<Product>> productsMap, String category, Product product) {
            if (productsMap.containsKey(product.getCategory()))
                productsMap.get(category).add(product);
            else {
                TreeSet<Product> productsSet = new TreeSet<>();
                productsSet.add(product);
                productsMap.put(product.getCategory(), productsSet);
            }
        }
    }

    private static class Product implements Comparable<Product> {
        private String category;
        private String name;
        private double price;

        public Product(String category, String name, double price) {
            this.category = category;
            this.name = name;
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
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
