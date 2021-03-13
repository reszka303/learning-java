package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.exception.NumberPositiveException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private ConsolePrinter printer = new ConsolePrinter();
    private Scanner input = new Scanner(System.in);

    public int numbersTeams() {
        printer.printLine("Enter number of teams");
        return getNumber();
    }

    private int getNumber() {
        boolean numberOk = false;
        int number = 0;
        while (!numberOk) {
            try {
                number = input.nextInt();
                number = checkPositive(number);
                numberOk = true;
            } catch (InputMismatchException e) {
                printer.printLineError("Enter digit, try again");
            } catch (NumberPositiveException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return number;
    }

    private int checkPositive(int number) {
        if (number <= 0) {
            throw new NumberPositiveException("Enter positive number, try again");
        }
        return number;
    }

    public String createTeam() {
        printer.printLine("Enter the name of team");
        return input.nextLine();
    }

    public int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    void clearBuffer() {
        input.nextLine();
    }
}
