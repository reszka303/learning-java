package javaStart.task1_OperationsOnVariables.exercise2;

public class Application {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        TaxRate taxRate1 = new TaxRate(true, false, false);
        TaxRate taxRate2 = new TaxRate(false, true, false);
        TaxRate taxRate3 = new TaxRate(false, false, true);
        Product product1 = new Product(new Price(100));
        Product product2 = new Product(new Price(100));
        Product product3 = new Product(new Price(100));

        double priceGross1 = shopService.countGrossPrice(product1, taxRate1);
        shopService.printInfo(priceGross1, product1, taxRate1);

        double priceGross2 = shopService.countGrossPrice(product2, taxRate2);
        shopService.printInfo(priceGross2, product2, taxRate2);

        double priceGross3 = shopService.countGrossPrice(product3, taxRate3);
        shopService.printInfo(priceGross3, product3, taxRate3);
    }
}
