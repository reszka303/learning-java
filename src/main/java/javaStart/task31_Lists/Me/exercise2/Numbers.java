package javaStart.task31_Lists.Me.exercise2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillNumbers(numbers);
        printStats(numbers);
    }

    private static void fillNumbers(List<Integer> numbers) {
        int input = 0;

        do {
            try {
                printLine("Give a non-negative number, divisible by 5");
                input = scanner.nextInt();
                if (input >= 0 && input % 5 == 0) {
                    numbers.add(input);
                }
            } catch (InputMismatchException e) {
                printLineError("You need enter a number, try again");
            } finally {
                clearBuffer();
            }
        } while (input >= 0 && input % 5 == 0);
    }

    private static void printStats(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            printLine("No number");
            return;
        }

        var sb = new StringBuilder();
        double sum = sum(numbers);
        double average = average(numbers, sum);

        sb.append("How many is correct numbers: " + numbers.size());
        sb.append("\n");
        sb.append("Their sum is: " + sum);
        sb.append("\n");
        sb.append("The average is: " + average);
        printLine(sb.toString());
    }

    private static double sum(List<Integer> numbers) {
        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static double average(List<Integer> numbers, double sum) {
        double average = sum/numbers.size();
        return average;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static void clearBuffer() {
        scanner.nextLine();
    }
}

