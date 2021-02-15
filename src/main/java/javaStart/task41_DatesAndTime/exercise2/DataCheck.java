package javaStart.task41_DatesAndTime.exercise2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DataCheck {
    public static void main(String[] args) {
        printLine("Enter two dates in the format: 'dd-MM-yyyy'");
        printLine("Enter first date");
        LocalDate firstDate = getDate();
        printLine("Enter second date");
        LocalDate secondDate = getDate();
        printLine("You entered the following dates: ");
        printAllGivenDates(firstDate, secondDate);
        isAfter(firstDate, secondDate);
        Period differ = getDiffer(firstDate, secondDate);
        printStats(differ.getYears(), differ.getMonths(), differ.getDays());
    }

    private static LocalDate getDate() {
        boolean parseOk = false;
        Scanner input = new Scanner(System.in);
        LocalDate parse = null;
        while (!parseOk) {
            try {
                DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String dateInput = input.nextLine();
                parse = LocalDate.parse(dateInput, datePattern);
                parseOk = true;
            } catch (DateTimeParseException e) {
                printLineError("Enter correct date format, try again");
            }
        }
        return parse;
    }

    private static void isAfter(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) {
            printLine("Later date: " + date1);
        } else {
            printLine("Later date: " + date2);
        }
    }

    private static Period getDiffer(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2);
    }

    private static int negativeToPositive(int number) {
         return number < 0 ? Math.abs(number) : number;
    }

    private static void printAllGivenDates(LocalDate date1, LocalDate date2) {
        printLine("" + date1);
        printLine("" + date2);
    }

    private static void printStats(int years, int months, int days) {
        years = negativeToPositive(years);
        months = negativeToPositive(months);
        days = negativeToPositive(days);
        printLine("Two dates are apart: " + years  + " years, " + months + " months, " +
                days + " days");
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
