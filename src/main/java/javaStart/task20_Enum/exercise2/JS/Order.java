package javaStart.task20_Enum.exercise2.JS;

public class Order {
    private String product;
    private double price;
    private OrderStatus status;


    public Order(String product, double price, OrderStatus status) {
        this.product = product;
        this.price = price;
        this.status = status;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return product + "(" + price + " zl)" + " - " + status;
    }
}
