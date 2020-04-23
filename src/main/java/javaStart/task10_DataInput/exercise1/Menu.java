package javaStart.task10_DataInput.exercise1;

import java.util.Scanner;

public class Menu {
    CalculatorLogic calculatorLogic = new CalculatorLogic();
    CalculatorPrint calculatorPrint = new CalculatorPrint();
    MenuLogic menuLogic = new MenuLogic();

    public void setInitialCalculatorMenu() {
        Scanner scanner = new Scanner(System.in);
        calculatorPrint.displayInitialMenu();
        int menu = scanner.nextInt();

        while (menu < 0 || menu > 1 ) {
            System.out.println("Error! Incorrect choice");
            calculatorPrint.displayInitialMenu();
            menu = scanner.nextInt();
        }

        switch (menu) {
            case 1:
                choseEuroOrUSFormatNumber();
                break;
            case 0:
                System.out.println("Calculator has been closed");
                System.exit(0);
        }
    }

    public void choseEuroOrUSFormatNumber() {
        Scanner scanner = new Scanner(System.in);
        calculatorPrint.displayingSetNumberFormat();
        int choice = scanner.nextInt();

        while (choice < 0 || choice > 3) {
            System.out.println("Error! Incorrect choice");
            calculatorPrint.displayingSetNumberFormat();
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                setMainCalculatorMenuEuroFormatNumber();
                break;
            case 2:
                setMainCalculatorMenuUSFormatNumber();
            case 3:
                setInitialCalculatorMenu();
            case 0:
                System.out.println("Calculator has been closed");
                System.exit(0);
        }
    }

    public void setMainCalculatorMenuEuroFormatNumber() {
        Scanner scanner = new Scanner(System.in);
        double numberOne = 0;
        double numberTwo = 0;
        calculatorPrint.displayMainMenu();
        int menu = scanner.nextInt();

        while (menu < 0 || menu > 5) {
            System.out.println("Error! Incorrect choice");
            calculatorPrint.displayMainMenu();
            menu = scanner.nextInt();
        }

            switch (menu) {
                case 1:
                    System.out.println("Add");
                    calculatorPrint.givingFirstNumbers();
                    numberOne = calculatorLogic.setEuropeanNumberFormat();
                    calculatorPrint.givingSecondNumbers();
                    numberTwo = calculatorLogic.setEuropeanNumberFormat();
                    System.out.println("The result of addition is: " +
                            calculatorLogic.add(numberOne, numberTwo));
                    actAfterCountRunner();
                    break;
                case 2:
                    System.out.println("Subtract");
                    calculatorPrint.givingFirstNumbers();
                    numberOne = calculatorLogic.setEuropeanNumberFormat();
                    calculatorPrint.givingSecondNumbers();
                    numberTwo = calculatorLogic.setEuropeanNumberFormat();
                    System.out.println("The result of subtraction is: " +
                            calculatorLogic.subtract(numberOne, numberTwo));
                    actAfterCountRunner();
                    break;
                case 3:
                    System.out.println("Multiply");
                    calculatorPrint.givingFirstNumbers();
                    numberOne = calculatorLogic.setEuropeanNumberFormat();
                    calculatorPrint.givingSecondNumbers();
                    numberTwo = calculatorLogic.setEuropeanNumberFormat();
                    System.out.println("The result of multiplication is: " +
                            calculatorLogic.multiply(numberOne, numberTwo));
                    actAfterCountRunner();
                    break;
                case 4:
                    System.out.println("Divide");
                    calculatorPrint.givingFirstNumbers();
                    numberOne = calculatorLogic.setEuropeanNumberFormat();
                    calculatorPrint.givingSecondNumbers();
                    numberTwo = calculatorLogic.setEuropeanNumberFormat();
                    System.out.println("The result of dividing is: " +
                            calculatorLogic.divide(numberOne, numberTwo));
                    actAfterCountRunner();
                    break;
                case 5:
                    setInitialCalculatorMenu();
                case 0:
                    System.out.println("The calculator has been closed");
                    System.exit(0);

        }
    }

    public void setMainCalculatorMenuUSFormatNumber() {
        Scanner scanner = new Scanner(System.in);
        double numberOne = 0;
        double numberTwo = 0;
        calculatorPrint.displayMainMenu();
        int menu = scanner.nextInt();

        while (menu < 1 || menu > 6) {
            System.out.println("Error! Incorrect choice");
            calculatorPrint.displayMainMenu();
            menu = scanner.nextInt();
        }

        switch (menu) {
            case 1:
                System.out.println("Add");
                calculatorPrint.givingFirstNumbers();
                numberOne = calculatorLogic.setUSNumberFormat();
                calculatorPrint.givingSecondNumbers();
                numberTwo = calculatorLogic.setUSNumberFormat();
                System.out.println("The result of addition is: " +
                        calculatorLogic.add(numberOne, numberTwo));
                actAfterCountRunner();
                break;
            case 2:
                System.out.println("Subtract");
                calculatorPrint.givingFirstNumbers();
                numberOne = calculatorLogic.setUSNumberFormat();
                calculatorPrint.givingSecondNumbers();
                numberTwo = calculatorLogic.setUSNumberFormat();
                System.out.println("The result of subtraction is: " +
                        calculatorLogic.subtract(numberOne, numberTwo));
                actAfterCountRunner();
                break;
            case 3:
                System.out.println("Multiply");
                calculatorPrint.givingFirstNumbers();
                numberOne = calculatorLogic.setUSNumberFormat();
                calculatorPrint.givingSecondNumbers();
                numberTwo = calculatorLogic.setUSNumberFormat();
                System.out.println("The result of multiplication is: " +
                        calculatorLogic.multiply(numberOne, numberTwo));
                actAfterCountRunner();
                break;
            case 4:
                System.out.println("Divide");
                calculatorPrint.givingFirstNumbers();
                numberOne = calculatorLogic.setUSNumberFormat();
                calculatorPrint.givingSecondNumbers();
                numberTwo = calculatorLogic.setUSNumberFormat();
                System.out.println("The result of dividing is: " +
                        calculatorLogic.divide(numberOne, numberTwo));
                actAfterCountRunner();
                break;
            case 5:
                setInitialCalculatorMenu();
            case 6:
                System.out.println("The calculator has been closed");
                System.exit(0);
        }
    }



    public void actAfterCountRunner() {
        Scanner scanner = new Scanner(System.in);
        calculatorPrint.actAfterCount();
        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                setMainCalculatorMenuEuroFormatNumber();
                break;
            case 2:
                setMainCalculatorMenuUSFormatNumber();
            case 3:
                setInitialCalculatorMenu();
                break;
            case 4:
                System.out.println("Calculator has been closed");
                System.exit(0);
        }
    }
}
