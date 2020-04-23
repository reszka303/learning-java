package javaStart.task10_DataInput.exercise1;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorLogic {
    CalculatorPrint calculatorPrint = new CalculatorPrint();
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        double result = 0;
        if (number2 == 0) {
            System.out.println("One can't divide by zero");
        } else {
            result = number1 / number2;
        }
        return result;
    }

    public double setEuropeanNumberFormat() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.GERMANY);
        double number = scanner.nextDouble();
        return number;
    }

    public double setUSNumberFormat() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double number = scanner.nextDouble();
        return number;
    }
}
