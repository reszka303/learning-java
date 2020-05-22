package javaStart.task8_Encapsulation.exercise1.MySolution;

public class DiscountService {

    double differentiateClient(Client client, double price) {
        if (client.isPremium()) {
            return isPremium(client, price);
        } else {
            return noPremium(client,price);
        }
    }

    double isPremium(Client client, double price) {
        if (price >= 5000) {
            return amountExtremeExtraDiscountForPremiumClient(price);
        } else if (price >= 1000 && price < 5000) {
            return amountExtraDiscountForPremiumClient(price);
        } else {
            return amountStandardDiscountForPremiumClient(price);
        }
    }

    private double amountExtremeExtraDiscountForPremiumClient(double price) {
        return price *= 0.80;
    }

    private double amountExtraDiscountForPremiumClient(double price) {
        return price *= 0.85;
    }

    private double amountStandardDiscountForPremiumClient(double price) {
        return price *= 0.95;
    }

    private double noPremium(Client client, double price) {
        if (price >= 5000) {
            return amountExtraDiscountForStandardClient(price);
        } else if (price >= 1000 && price < 5000) {
            return amountDiscountForStandardClient(price);
        } else {
            return amountNoDiscountForStandardClient(price);
        }
    }

    private double amountExtraDiscountForStandardClient(double price){
        return price *= 0.90;
    }

    private double amountDiscountForStandardClient (double price){
        return price *= 0.95;
    }

    private double amountNoDiscountForStandardClient (double price){
        return price;
    }
}
