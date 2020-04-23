package javaStart.task10_DataInput.exercise1;

import java.util.Scanner;

public class MenuLogic {
    CalculatorLogic calculatorLogic = new CalculatorLogic();
    CalculatorPrint calculatorPrint = new CalculatorPrint();

    public void protectRightChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        while (choice < 1 || choice > 2) {
            System.out.println("Error! Incorrect choice");
            calculatorPrint.displayingSetNumberFormat();
            choice = scanner.nextInt();
        }
    }

//    public void choseEuroOrUSFormatNumber(int choice) {
//        if (choice == 1) {
//            calculatorLogic.setEuropeanNumberFormat();
//        } if (choice == 2){
//            calculatorLogic.setUSNumberFormat();
//        }
//    }
}
