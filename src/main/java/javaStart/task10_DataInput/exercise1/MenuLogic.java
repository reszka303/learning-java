package javaStart.task10_DataInput.exercise1;

import java.util.InputMismatchException;

public class MenuLogic {
    CalculatorLogic calculatorLogic = new CalculatorLogic();
    CalculatorPrint calculatorPrint = new CalculatorPrint();
    ChoiceLogic choiceLogic = new ChoiceLogic();

    void runMainMenu() {
        calculatorPrint.displayMainMenu();
        int menu = choiceLogic.protectRightChoiceMainMenu();

        switch (menu) {
            case 1:
                runEuroFormatNumber();
                break;
            case 2:
                runUSFormatNumber();
                break;
            case 0:
                System.out.println("Calculator has been closed");
                System.exit(0);
        }
    }

    private void runEuroFormatNumber() {
        float numberOne = 0;
        float numberTwo = 0;
        boolean error = true;
        calculatorPrint.displayCalculationMenu();
        int menu = choiceLogic.protectRightChoiceCalculationMenu();

            switch (menu) {
                case 1:
                    do {
                        try {
                            System.out.println("Add");
                            numberOne = givingNumberOneEuropeanFormatNumber();
                            numberTwo = givingNumberTwoEuropeanFormatNumber();
                            System.out.println("The result of addition is: " +
                                    calculatorLogic.add(numberOne, numberTwo));
                            displayMenuAfterCalculation();
                            error = false;
                        } catch (InputMismatchException e) {
                            calculatorPrint.displayExceptionMessageForEuroFormatNumber();
                        }
                    } while (error);
                    break;
                case 2:
                    do {
                        try {
                            System.out.println("Subtract");
                            numberOne = givingNumberOneEuropeanFormatNumber();
                            numberTwo = givingNumberTwoEuropeanFormatNumber();
                            System.out.println("The result of subtraction is: " +
                                    calculatorLogic.subtract(numberOne, numberTwo));
                            displayMenuAfterCalculation();
                            error = false;
                        } catch (InputMismatchException e) {
                            calculatorPrint.displayExceptionMessageForEuroFormatNumber();
                        }
                    } while (error);
                    break;
                case 3:
                    do {
                        try {
                            System.out.println("Multiply");
                            numberOne = givingNumberOneEuropeanFormatNumber();
                            numberTwo = givingNumberTwoEuropeanFormatNumber();
                            System.out.println("The result of multiplication is: " +
                                    calculatorLogic.multiply(numberOne, numberTwo));
                            displayMenuAfterCalculation();
                            error = false;
                        } catch (InputMismatchException e) {
                            calculatorPrint.displayExceptionMessageForEuroFormatNumber();
                        }
                    } while (error);
                    break;
                case 4:
                    do {
                        try {
                            System.out.println("Divide");
                            numberOne = givingNumberOneEuropeanFormatNumber();
                            numberTwo = givingNumberTwoEuropeanFormatNumber();
                            System.out.println("The result of dividing is: " +
                                    calculatorLogic.divide(numberOne, numberTwo));
                            displayMenuAfterCalculation();
                            error = false;
                        } catch (InputMismatchException e) {
                            calculatorPrint.displayExceptionMessageForEuroFormatNumber();
                        }
                    } while (error);
                    break;
                case 5:
                    runMainMenu();
                    break;
                case 0:
                    System.out.println("The calculator has been closed");
                    System.exit(0);
        }
    }

    private void runUSFormatNumber() {
        float numberOne = 0;
        float numberTwo = 0;
        boolean error = true;
        calculatorPrint.displayCalculationMenu();
        int menu = choiceLogic.protectRightChoiceCalculationMenu();

        switch (menu) {
            case 1:
                do {
                    try {
                        System.out.println("Add");
                        numberOne = givingNumberOneUSFormatNumber();
                        numberTwo = givingNumberTwoUSFormatNumber();
                        System.out.println("The result of addition is: " +
                                calculatorLogic.add(numberOne, numberTwo));
                        displayMenuAfterCalculation();
                        error = false;
                    } catch (InputMismatchException e) {
                        calculatorPrint.displayExceptionMessageForUSFormatNumber();
                    }
                } while (error);
                break;
            case 2:
                do {
                    try {
                        System.out.println("Subtract");
                        numberOne = givingNumberOneUSFormatNumber();
                        numberTwo = givingNumberTwoUSFormatNumber();
                        System.out.println("The result of subtraction is: " +
                                calculatorLogic.subtract(numberOne, numberTwo));
                        displayMenuAfterCalculation();
                        error = false;
                    } catch (InputMismatchException e) {
                        calculatorPrint.displayExceptionMessageForUSFormatNumber();
                    }
                } while (error);
                break;
            case 3:
                do {
                    try {
                        System.out.println("Multiply");
                        numberOne = givingNumberOneUSFormatNumber();
                        numberTwo = givingNumberTwoUSFormatNumber();
                        System.out.println("The result of multiplication is: " +
                                calculatorLogic.multiply(numberOne, numberTwo));
                        displayMenuAfterCalculation();
                        error = false;
                    } catch (InputMismatchException e) {
                        calculatorPrint.displayExceptionMessageForUSFormatNumber();
                    }
                } while (error);
                break;
            case 4:
                do {
                    try {
                        System.out.println("Divide");
                        numberOne = givingNumberOneUSFormatNumber();
                        numberTwo = givingNumberTwoUSFormatNumber();
                        System.out.println("The result of dividing is: " +
                                calculatorLogic.divide(numberOne, numberTwo));
                        displayMenuAfterCalculation();
                        error = false;
                    } catch (InputMismatchException e) {
                        calculatorPrint.displayExceptionMessageForUSFormatNumber();
                    }
                } while (error);
                break;
            case 5:
                runMainMenu();
                break;
            case 0:
                System.out.println("The calculator has been closed");
                System.exit(0);
        }
    }

    private void displayMenuAfterCalculation() {
        calculatorPrint.displayMenuAfterCalculation();
        int menu = choiceLogic.protectRightChoiceMenuAfterCalculation();

        switch (menu) {
            case 1:
                runEuroFormatNumber();
                break;
            case 2:
                runUSFormatNumber();
                break;
            case 0:
                System.out.println("Calculator has been closed");
                System.exit(0);
        }
    }

    private float givingNumberOneEuropeanFormatNumber() {
        calculatorPrint.givingFirstNumbers();
        float numberOne = calculatorLogic.runEuropeanFormatNumbering();
        return numberOne;
    }

    private float givingNumberTwoEuropeanFormatNumber() {
        calculatorPrint.givingFirstNumbers();
        float numberTwo = calculatorLogic.runEuropeanFormatNumbering();
        return numberTwo;
    }

    private float givingNumberOneUSFormatNumber() {
        calculatorPrint.givingFirstNumbers();
        float numberOne = calculatorLogic.runUSFormatNumbering();
        return numberOne;
    }

    private float givingNumberTwoUSFormatNumber() {
        calculatorPrint.givingFirstNumbers();
        float numberTwo = calculatorLogic.runUSFormatNumbering();
        return numberTwo;
    }
}
