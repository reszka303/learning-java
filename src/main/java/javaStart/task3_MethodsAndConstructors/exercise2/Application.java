package javaStart.task3_MethodsAndConstructors.exercise2;

public class Application {
    public static void main(String[] args) {
        Offer offer1 = new Offer(new Product("Milk chocolate", "Milka"),
                3.99, true);

        offer1.printInfo();
    }
}
