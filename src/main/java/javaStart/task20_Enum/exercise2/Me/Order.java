package javaStart.task20_Enum.exercise2.Me;

public class Order {
    private String product;
    private double price;
    OrderStatus orderStatus;

    public Order(String product, double price, OrderStatus orderStatus) {
        this.product = product;
        this.price = price;
        this.orderStatus = orderStatus;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return product + "(" + price + ")" + "-" + orderStatus;
    }
}
