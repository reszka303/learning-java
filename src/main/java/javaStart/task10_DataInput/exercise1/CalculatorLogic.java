package javaStart.task10_DataInput.exercise1;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorLogic {
    float add(float number1, float number2) {
        return number1 + number2;
    }

    float subtract(float number1, float number2) {
        return number1 - number2;
    }

    float multiply(float number1, float number2) {
        return number1 * number2;
    }

    float divide(float number1, float number2) {
        if (number2 == 0) {
            System.out.println("Can't be divide by zero");

        }
        return number1/number2;
    }


    float runEuropeanFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.GERMANY);
        float number = scanner.nextFloat();
        return number;
    }

    float runUSFormatNumbering() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        float number = scanner.nextFloat();
        return number;
    }
}
