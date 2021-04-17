package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.exception.NoSuchCharacterException;
import javaStart.task39_Streams.exercise2.combined.exception.TeamNameLengthException;
import javaStart.task39_Streams.exercise2.combined.exception.NumberPositiveException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataReader {
    private static Scanner inputStatic = new Scanner(System.in);
//    private static final String SIGNS_TO_DELETE = "[ ,.?!/'\\\\<>@#$%^&*()|+={};:~`-]+";
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
        boolean nameOk = false;
        String teamLetter = null;
        printer.printLine("Enter the name of team");
       while (!nameOk) {
           try {
               teamLetter = input.nextLine();
               teamLetter = capitalizeFirstLetterEverySingleWord(teamLetter);
               teamLetter = checkLength(teamLetter);
               nameOk = true;
           } catch (TeamNameLengthException e) {
               e.getMessage();
           }
       }
        return teamLetter;
    }

    private String checkLength(String teamLetter) {
        int maxLengthTeamName = 20;
        if (teamLetter.length() > maxLengthTeamName) {
            throw new TeamNameLengthException("Team name can be up to 20 digits long, please try again");
        } else {
            return teamLetter;
        }
    }

    public String capitalizeFirstLetterEverySingleWord(String teamName) {
        return Arrays.stream(teamName.trim().split(" "))
                .map(String::toCharArray)
                .peek(DataReader::getUpperCaseFirstLetter)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static void getUpperCaseFirstLetter(char[] array) {
        array[0] = Character.toUpperCase(array[0]);
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

    public void close() {
        input.close();
    }
}
