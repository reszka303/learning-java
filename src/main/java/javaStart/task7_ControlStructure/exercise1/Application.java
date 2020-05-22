package javaStart.task7_ControlStructure.exercise1;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        Number number = new Number(random.nextInt(10000));
        number.printNumber(number);
        number.checkIs(number);
        number.checkEvenOrOdd(number);
        number.complete(number);
    }
}
