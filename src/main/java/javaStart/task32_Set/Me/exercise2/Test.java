package javaStart.task32_Set.Me.exercise2;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();

        products.add(new Product("milk", 2.99));
        System.out.println("Jeden produkt dodany: " + products);

        products.add(new Product("chocolate", 3.79));
        System.out.println("Drugi produkt dodany: " + products);
        System.out.println("Rozmiar: " + products.size());

        products.add(new Product("milk", 3.99));
        System.out.println(products);
        System.out.println("Czy zawiera produkt 'milk, 3,99': " + products.contains(new Product("milk", 3.99)));
        System.out.println("Rozmiar: " + products.size());

        System.out.println("Czy produkty milk są sobie równe");
        if (new Product("milk", 2.99).equals(new Product("milk", 3.99))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        products.remove(new Product("milk", 2.99));
        System.out.println(products);

        products.add(new Product("milk", 3.99));
        System.out.println(products);
    }
}
