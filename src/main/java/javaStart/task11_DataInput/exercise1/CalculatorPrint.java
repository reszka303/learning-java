package javaStart.task11_DataInput.exercise1;

public class CalculatorPrint {
    void displayMainMenu() {
        System.out.println("==Calculator==");
        System.out.println("Main Menu");
        System.out.println("1 - Chose Main Menu - European format number");
        System.out.println("2 - Chose Main Menu - U.S. number format");
        System.out.println("0 - End the program");
    }

    void displayCalculationMenu() {
        System.out.println("==Calculator==");
        System.out.println("Calculation Menu");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - Return to Main Menu");
        System.out.println("0 - End the program");

    }

    void givingFirstNumbers() {
        System.out.println("Give first number...");
    }

    void givingSecondNumbers() {
        System.out.println("Give second number...");
    }

    void displayExceptionMessageForEuroFormatNumber() {
        System.out.println("Error! You gave the wrong number");
        System.out.println("If you want to give a floating point number," +
                " you should give it with comma ','");
        System.out.println("For example 1,5, not 1.5");
        System.out.println("Can't be given any letters too");
        System.out.println("Try again...");
    }

    void displayExceptionMessageForUSFormatNumber() {
        System.out.println("Error! You gave the wrong number");
        System.out.println("If you want to give a floating point number," +
                " you should give it with dot '.'");
        System.out.println("For example 1.5, not 1,5");
        System.out.println("Can't be given any letters too");
        System.out.println("Try again...");
    }

    void displayMenuAfterCalculation() {
        System.out.println("What now?");
        System.out.println("1 - Chose the Main Menu - European Format Number");
        System.out.println("2 - Chose the Main Menu - U.S. Format Number");
        System.out.println("0 - End the program");
    }

    void displayExceptionMessageForChoiceLogic() {
        System.out.println("You must give only an integer");
        System.out.println("A floating point number or letter cannot be given");
        System.out.println("Try again...");
    }
}
