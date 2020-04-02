package javaStart.task2_AggregationAndComposition.exercise2;

public class Application {
    public static void main(String[] args) {
        AuctionService auctionService = new AuctionService();
        Auction auction1 = new Auction("Xbox One",
                "A console for demanding players ", 999.99,
                new User("Stefan", "Redman",
                        new Address("Stockholm", "50-500",
                                "Frejgatan", "24A", "21") ));
        Auction auction2 = new Auction("Samsung S20",
                "Amazing mobile phone with three lenses", 3999.0,
                new User("Dillan", "Bernard"));

        auctionService.printInfo(auction1);
        System.out.println();
        auctionService.printInfo(auction2);
    }
}
