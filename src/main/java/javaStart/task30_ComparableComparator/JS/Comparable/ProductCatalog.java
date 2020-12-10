package javaStart.task30_ComparableComparator.JS.Comparable;

public class ProductCatalog {
    public static void main(String[] args) {
        Product product1 = new Product("Knorr", "Racuchy", 2.20);
        Product product2 = new Product("Amino", "Zupa ogórkowa", 2.20);

        printLine("" + product1.compareTo(product2));
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
