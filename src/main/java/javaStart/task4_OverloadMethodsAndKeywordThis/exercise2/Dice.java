package javaStart.task4_OverloadMethodsAndKeywordThis.exercise2;

import java.util.Random;

public class Dice {
    private int number;
    private Random random = new Random();

    public Dice() {
        roll();
    }

    public Dice(int number) {
        this.number = number;
    }

    public int roll() {
        Random random = new Random();
        return number = random.nextInt(6) + 1;
    }

    public void printRoll() {
        System.out.println("A dice roll occurs");
        System.out.println("The drawn number is: " + number);
    }
}
