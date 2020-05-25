package javaStart.task16_Inheritance.exercise1;

public class PartApp {
    public static void main(String[] args) {
        Tire tire1 = new Tire(
                123,
                "SuperTire",
                "ProContact",
                "Winter pro",
                17, 225);
        ExhaustPart exhaustPart1 = new ExhaustPart(
                987,
                "Noisy Parts",
                "Turbo Brum",
                "Noisy Exhaust",
                true);



        System.out.println("Tire:" + '\n' + tire1.printInfo());
        System.out.println();
        System.out.println("Exhaust:"+ '\n' + exhaustPart1.printInfo());
    }
}
