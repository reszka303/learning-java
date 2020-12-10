package javaStart.task30_ComparableComparator.JS.Comparable;

public class Product implements Comparable<Product> {
    private String producer;
    private String name;
    private double price;

    public Product(String producer, String name, double price) {
        this.producer = producer;
        this.name = name;
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Producer: " + producer + " name: " + name + " price: " + price;
    }

    @Override
    public int compareTo(Product product) {
        if (price > product.price)
            return 1;
        else if (price < product.price)
            return -1;
        int producerCompare = producer.compareTo(product.producer);
        if (producerCompare != 0)
            return producerCompare;
        return name.compareTo(product.name);
    }
}
