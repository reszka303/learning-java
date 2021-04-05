package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.exception.NumberPositiveException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

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
        String teamLetter = input.nextLine();
        teamLetter = capitalizeFirstLetterEverySingleWord(teamLetter);
        return teamLetter;
    }

    public String capitalizeFirstLetterEverySingleWord(String teamName) {
        String[] arr = teamName.split(" ");
        var builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return builder.toString().trim();
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

    public String toLowerCase() {
        return input.nextLine().toLowerCase();
    }
}
