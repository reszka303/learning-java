package javaStart.task10_DataInput.exercise1;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorLogic {
    public float add(float number1, float number2) {
        return number1 + number2;
    }

    public float subtract(float number1, float number2) {
        return number1 - number2;
    }

    public float multiply(float number1, float number2) {
        return number1 * number2;
    }

    public float divide(float number1, float number2) {
        if (number2 == 0) {
            System.out.println("Can't be divide by zero");

        }
        return number1/number2;
    }


    public float runEuropeanFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.GERMANY);
        float number = scanner.nextFloat();
        return number;
    }

    public float runUSFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        float number = scanner.nextFloat();
        return number;
    }
}
