package javaStart.task1_OperationsOnVariables.exercise2;

public class ShopService {
    public double countGrossPrice(Product product, TaxRate taxRate) {
       if (taxRate.isBasic()) {
           return taxRate23(product);
       } else if (taxRate.isDecreased()) {
           return taxRate8(product);
        } else if (taxRate.isFree()) {
           return taxRateFree(product);
       }
       return product.getPrice().getPriceNet();
    }

    private double taxRate23(Product product) {
        double price23 = 0.23;
        return price23 = price23 * product.getPrice().getPriceNet() +
                product.getPrice().getPriceNet();
    }

    private double taxRate8(Product product) {
        double price8 = 0.08;
        return price8 = price8 * product.getPrice().getPriceNet() +
                product.getPrice().getPriceNet();
    }

    private double taxRateFree(Product product) {
        double price0 = 0;
        return price0 = price0 * product.getPrice().getPriceNet() +
                product.getPrice().getPriceNet();
    }

    public void printInfo(double priceGross, Product product, TaxRate taxRate) {
        double taxVat = 0;
        if (taxRate.isBasic()) {
            taxVat = 0.23;
            System.out.println("Price net is: " + product.getPrice().getPriceNet() +
                    ", tax vat is: " + taxVat * + product.getPrice().getPriceNet()+ "%, " +
                    " Price gross is: " + priceGross);
        } else if (taxRate.isDecreased()) {
            taxVat = 0.08;
            System.out.println("Price net is: " + product.getPrice().getPriceNet() +
                    ", tax vat is: " + taxVat * product.getPrice().getPriceNet()+ "%, " +
                    " Price gross is: " + priceGross);
        } else if (taxRate.isFree()) {
            System.out.println("Price net is: " + product.getPrice().getPriceNet() +
                    ", tax vat is: " + taxVat * product.getPrice().getPriceNet() + "%, " +
                    " Price gross is: " + priceGross);
        }
    }
}
