package javaStart.task3_MethodsAndConstructors.exercise2;

public class Offer {
    private Product product;
    private double price;
    private boolean special;

    public Offer(Product product, double price, boolean special) {
        this.product = product;
        this.price = price;
        this.special = special;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSpecial() {
        return special;
    }

    public void printInfo () {
        String info = "Product name: " + getProduct().getName()+ "\n" +
                "Producer: " + getProduct().getProducer() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Special offer: " + isSpecial();
        System.out.println(info);
    }
}
