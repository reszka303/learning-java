package javaStart.task10_DataInput.exercise1;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorLogic {
    protected float add(float number1, float number2) {
        return number1 + number2;
    }

    protected float subtract(float number1, float number2) {
        return number1 - number2;
    }

    protected float multiply(float number1, float number2) {
        return number1 * number2;
    }

    protected float divide(float number1, float number2) {
        if (number2 == 0) {
            System.out.println("Can't be divide by zero");

        }
        return number1/number2;
    }


    protected float runEuropeanFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.GERMANY);
        float number = scanner.nextFloat();
        return number;
    }

    protected float runUSFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        float number = scanner.nextFloat();
        return number;
    }
}
