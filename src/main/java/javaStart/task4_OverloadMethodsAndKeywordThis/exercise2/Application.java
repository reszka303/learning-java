package javaStart.task4_OverloadMethodsAndKeywordThis.exercise2;

public class Application {
    public static void main(String[] args) {
        Dice dice1 = new Dice();
        dice1.roll();
        dice1.printRoll();

        dice1.roll();
        dice1.printRoll();
    }
}
