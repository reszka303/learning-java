package webTechnologies.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();
    int getDay() {
        printer.printLine("Enter a number with the range from 1 to 365");
        return getNumber();
    }

    private int getNumber() {
        boolean numberOk = false;
        int initialNumber;
        int number = 0;
        while (!numberOk) {
            try {
                initialNumber = clearBuffer();
                number = checkNumber(initialNumber);
                numberOk = true;
            } catch (NumberNotFoundRange e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("You need to enter digit, try again");
            }
        }
        return number;
    }

    private int checkNumber(int number) {
        if (number > 365 || number < 1) {
            throw new NumberNotFoundRange("You entered number beyond the range, try again");
        } else {
            return number;
        }
    }

    private int clearBuffer() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}
