package Test;

import javaStart.task22_Exceptions.exercise1.Me.UnknownOperatorException;

import java.util.Scanner;

public class Test {
    private static final String ADDING = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";
    Scanner scanner = new Scanner(System.in);

    void run() {
        String operator = getException(getOperator());
    }

    private String getOperator() {
        String operator = "";
        System.out.println("Podaj jeden z następujących operatorów" +
                " arytmetycznych: +, -, * lub /");
        return operator;
    }

    private void handleUnknownOperatorException(String operator) {
        boolean error = true;
        if (operator.equals(ADDING) ||
                operator.equals(SUBTRACTION) ||
                (operator.equals(MULTIPLY) ||
                        operator.equals(DIVISION))) {
            System.out.println("Wczytano poprawny operator");
            error = false;
        } else {
            throw new UnknownOperatorException("Nie rozpoznano " +
                    "właściwego operatora");
        }
    }

    private String getException(String operator) {
            try {
                operator = scanner.nextLine();
                handleUnknownOperatorException(operator);
            } catch (UnknownOperatorException e) {
                System.err.println(e.getMessage());
                System.err.println("Nie podałeś prawidłowego operatora");
            }
        System.out.println("Podałeś następujący operator: " + operator);
        return operator;
    }
}
