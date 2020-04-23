package javaStart.task10_DataInput.exercise1;

public class CalculatorPrint {
    public void displayInitialMenu() {
        System.out.println("==Calculator==");
        System.out.println("Initial Menu");
        System.out.println("1 - Initial a calculator");
        System.out.println("0 - End the program");
    }

    public void displayMainMenu() {
        System.out.println("==Calculator==");
        System.out.println("Main Menu");
        System.out.println("Push a suitable number to chose an instruction");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - Return to the Initial Menu");
        System.out.println("0 - End the program");

    }

    public void displayingSetNumberFormat() {
        System.out.println("1 - Chose  Main Menu - European format number*");
        System.out.println("2 - Chose Main Menu - U.S. number format*");
        System.out.println("3 - Return to the Initial Menu");
        System.out.println("0 - End the program");
    }

    public void actAfterCount() {
        System.out.println("What now?");
        System.out.println("1 - Chose the Main Menu - European Format Number");
        System.out.println("2 - Chose the Main Menu - U.S. Format Number");
        System.out.println("3 - Return to Initial Menu");
        System.out.println("4 - End the program");
    }

    public void givingFirstNumbers() {
        System.out.println("Give first number");
    }

    public void givingSecondNumbers() {
        System.out.println("Give second number");
    }
}
