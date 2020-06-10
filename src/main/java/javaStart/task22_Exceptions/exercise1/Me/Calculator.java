package javaStart.task22_Exceptions.exercise1.Me;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final String ADDING = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";
    Scanner scanner = new Scanner(System.in);

    void run() {
        double result = calculate();
        printResult(result);
    }

    private void printResult(double result) {
        System.out.println("The result is: " + result);
    }

    private double calculate() {
        double firstNumber = firstNumber();
        String operator = enterArithmeticOperator();
        double secondNumber = secondNumber();

        double result = 0;

        switch (operator) {
            case ADDING:
                result = firstNumber + secondNumber;
                break;
            case SUBTRACTION:
                result = firstNumber - secondNumber;
                break;
            case MULTIPLY:
                result = firstNumber * secondNumber;
                break;
            case DIVISION:
                result = firstNumber / secondNumber;
                validateDivision(secondNumber);
                break;
            default:
                validateArithmeticOperators(operator);
        }
        return result;
    }

    private double firstNumber() {
        boolean error = true;
        double number = 0;

        do {
            try {
                System.out.println("Enter the first number");
                number = scanner.nextDouble();
                error = false;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data entered, start again");
                scanner.nextLine();
            }
        } while (error);
        return number;
    }

    private double secondNumber() {
        double number = 0;
        boolean error = true;

        do {
            try {
                System.out.println("Enter the second number");
                number = scanner.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid data entered," +
                        " enter the second number again");
                scanner.nextLine();
            }
        } while (error);
        return number;
    }

    private double throwArithmeticException(double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Can't be divided by zero");
        }
        return secondNumber;
    }

    private void validateDivision(double secondNumber) {
        try {
            throwArithmeticException(secondNumber);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            System.err.println("The result could not be calculated");
            System.exit(0);
        }
    }

    private String enterArithmeticOperator() {
        System.out.println("Enter the arithmetic operator: (+, -, *, /)");
        String operator = scanner.nextLine();
        return operator;
    }

    private void throwUnknownOperationException(String operator) {
        boolean error = true;
        if (operator.equals(ADDING) ||
                operator.equals(SUBTRACTION) ||
                (operator.equals(MULTIPLY) ||
                        operator.equals(DIVISION))) {
            error = false;
        } else {
            throw new UnknownOperatorException("You use an undefined arithmetic operator");
        }
    }

    private String validateArithmeticOperators(String operator) {
        try {
            operator = scanner.nextLine();
            throwUnknownOperationException(operator);
        } catch (UnknownOperatorException e) {
            System.err.println(e.getMessage());
            System.err.println("The result could not be calculated");
            System.exit(0);
        }
        return operator;
    }
}
