package javaStart.task2_AggregationAndComposition.exercise2;

public class Auction {
    private String title;
    private String description;
    private double price;
    private User seller;

    public Auction(String title, String description, double price, User seller) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return seller;
    }
}
