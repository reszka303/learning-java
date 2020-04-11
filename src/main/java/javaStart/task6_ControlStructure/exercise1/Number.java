package javaStart.task6_ControlStructure.exercise1;

import java.util.Random;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Number printNumber(Number number) {
        System.out.println("A number drew is: " + number.getNumber());
        return number;
    }

    public Number checkIs(Number number) {
        Random random = new Random();
        int randomNumber = random.nextInt(450) + 550;
        if (number.getNumber() > randomNumber) {
            System.out.println("A number is higher than " + randomNumber);
        } else if (number.getNumber() < randomNumber) {
            System.out.println("A number is less than " + randomNumber);
        } else {
            System.out.println("A number is " + randomNumber);
        }
        return number;
    }

    public Number checkEvenOrOdd(Number number) {
        if (number.getNumber() % 2 == 0) {
            System.out.println("A number is even");
        } else {
            System.out.println("A number is odd");
        }
        return number;
    }

    public Number complete(Number number) {
        if (number.getNumber() < 1000) {
            System.out.println("A number has been completed to 4 numbers: "
                    + number.getNumber() + 0);
        }
        return number;
    }
}
