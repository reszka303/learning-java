package javaStart.task26_Recursion.Me.exercise2.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double totalPrice() {
        return sum(getProducts());
    }

    private double sum(List<Product> products) {
        if (products.isEmpty()){
            return 0;
        } else {
            return products.get(0).getPrice() + sum(products.subList(1, products.size()));
        }
    }
}
