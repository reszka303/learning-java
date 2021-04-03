package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.Scanner;

public class T6IgnoreWhitespace {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String letter = create();
        printLine(letter);
        int letterSize = String.valueOf(letter).length();
        printLine("Letter size: " + letterSize);
    }

    private static String create() {
        printLine("Enter some letter");
        return input.nextLine().trim();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
