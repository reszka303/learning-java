package javaStart.task6_ControlStructure.exercise3;

import java.util.Random;

public class Integer {
    protected int random() {
        Random random = new Random();
        int number = random.nextInt(9999);
        return number;
    }

    protected int check5000(int number) {
        if (number < 5000) {
            System.out.println("Number is lower than 5000");
        } else if (number == 5000) {
            System.out.println("Number is equal 5000");
        } else {
            System.out.println("Number is biggest than 5000");
        }
        return number;
    }

    protected int checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
        return number;
    }

    protected int describeInteger(int number) {
        if (number < 999 && number > 99 ) {
            System.out.println(number + "0");
        } else if (number < 100 && number != 0) {
            System.out.println(number + "00");
        } else {
            System.out.println(number);
        }
        return number;
    }
}
