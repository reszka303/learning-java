package javaStart.task2_AggregationAndComposition.exercise2;

public class AuctionService {
    public void printInfo(Auction auction) {
        String info = "Auction information:" + "\n" +
                "Title: " + auction.getTitle() + "\n" +
                "Description: " + auction.getDescription() + "\n" +
                "Price: " + auction.getPrice() + "\n" +
                "Seller: " + auction.getUser().getFirstName() + " " +
                auction.getUser().getLastName();
        System.out.println(info);
    }
}
