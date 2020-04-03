package javaStart.task3_MethodsAndConstructors.exercise2;

public class Product {
    private String name;
    private String producer;

    public Product(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }
}
