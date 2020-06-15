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
        Double result = calculate();
        printResult(result);
    }

    private void printResult(double result) {
        System.out.println("The result is: " + result);
    }

    private double calculate() {
        System.out.println("Enter the first number");
        double firstNumber = readNumber();
        String operator = enterArithmeticOperator();
        System.out.println("Enter the second number");
        double secondNumber = readNumber();

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
                readCorrectArithmeticOperator(operator);
        }
        return result;
    }

    private double readNumber() {
        boolean error = true;
        double number = 0;

        do {
            try {
                number = scanner.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid data entered, start again," +
                        " enter the number");
                scanner.nextLine();
            }
        } while (error);
        return number;
    }

    private double divisionByZero(double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Can't be divided by zero");
        }
        return secondNumber;
    }

    private void validateDivision(double secondNumber) {
        try {
            divisionByZero(secondNumber);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            System.err.println("The result could not be calculated");
            System.exit(0);
        }
    }

    private String enterArithmeticOperator() {
        System.out.println("Enter the arithmetic operator: (+, -, *, /)");
        scanner.nextLine();
        String operator = scanner.nextLine();
        return operator;
    }

    private void validateArithmeticOperation(String operator) {
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

    private String readCorrectArithmeticOperator(String operator) {
        try {
            operator = scanner.nextLine();
            validateArithmeticOperation(operator);
        } catch (UnknownOperatorException e) {
            System.err.println(e.getMessage());
            System.err.println("The result could not be calculated");
            System.exit(0);
        }
        return operator;
    }
}
