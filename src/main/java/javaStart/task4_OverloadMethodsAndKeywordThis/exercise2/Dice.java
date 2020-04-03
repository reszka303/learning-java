package javaStart.task4_OverloadMethodsAndKeywordThis.exercise2;

import java.util.Random;

public class Dice {
    private int number;

    public Dice() {
        Random random = new Random();
        this.number = random.nextInt(6) + 1;
    }

    public Dice(int number) {
        this.number = number;
    }

    public int roll() {
        Random random = new Random();
        System.out.println("A dice roll occurs");
        return number = random.nextInt(6) + 1;
    }

    public void printRoll() {
        System.out.println("The drawn number is: " + number);
    }
}
