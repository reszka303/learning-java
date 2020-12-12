package javaStart.task31_Lists.Me.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumNumbers {
    private static final String EXIT = "exit";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        fillList(doubles);
        printDoubles(doubles);
    }

    private static void fillList(List<Double> doubles) {
        String input;

        do {
            printLine("Give number or write 'exit'");
            input = SumNumbers.scanner.nextLine();
            try {
                if (!input.equalsIgnoreCase(EXIT)) {
                    Double number = Double.valueOf(input);
                    doubles.add(number);
                }
            } catch (NumberFormatException e) {
                printLineError("Incorrect number");
            }
        } while (!input.equalsIgnoreCase(EXIT));
    }

    private static void printDoubles(List<Double> doubles) {
        if (doubles.isEmpty()) {
            printLine("No number");
            return;
        }

        var sb = new StringBuilder();
        double sum = 0;
        for (Double singleDouble : doubles) {
            sb.append(singleDouble);
            sb.append(" + ");
            sum += singleDouble;
        }
        sb.replace(sb.length() - 2, sb.length(), "= ");
        sb.append(sum);
        printLine(sb.toString());

    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
