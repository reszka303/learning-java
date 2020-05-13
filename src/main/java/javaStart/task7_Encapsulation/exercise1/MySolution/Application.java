package javaStart.task7_Encapsulation.exercise1.MySolution;

public class Application {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        Client clientPremium1 = new Client("Axel", "Lambert", true, 1100);
        Client clientPremium2 = new Client("Nikodem", "Hirst", true, 900);
        Client clientPremium3 = new Client("Geoffrey", "Matthams", true, 5100);

        Client clientStandard1 = new Client("Flynn", "Greig", false, 1100);
        Client clientStandard2 = new Client("Phoenix", "Blundell", false, 900);
        Client clientStandard3 = new Client("Tristan", "Barker", false, 5100);

        double discountClientPremium1 = discountService.differentiateClient(clientPremium1, clientPremium1.getPrice());
        double discountClientPremium2 = discountService.differentiateClient(clientPremium2, clientPremium2.getPrice());
        double discountClientPremium3 = discountService.differentiateClient(clientPremium3, clientPremium3.getPrice());

        double discountClientStandard1 = discountService.differentiateClient(clientStandard1, clientStandard1.getPrice());
        double discountClientStandard2 = discountService.differentiateClient(clientStandard2, clientStandard2.getPrice());
        double discountClientStandard3 = discountService.differentiateClient(clientStandard3, clientStandard3.getPrice());

        System.out.println();
        System.out.println(clientPremium1.printInfo());
        System.out.println(discountClientPremium1);
        System.out.println();

        System.out.println(clientPremium2.printInfo());
        System.out.println(discountClientPremium2);
        System.out.println();

        System.out.println(clientPremium3.printInfo());
        System.out.println(discountClientPremium3);
        System.out.println();

        System.out.println(clientStandard1.printInfo());
        System.out.println(discountClientStandard1);
        System.out.println();

        System.out.println(clientStandard2.printInfo());
        System.out.println(discountClientStandard2);
        System.out.println();

        System.out.println(clientStandard3.printInfo());
        System.out.println(discountClientStandard3);
    }
}
