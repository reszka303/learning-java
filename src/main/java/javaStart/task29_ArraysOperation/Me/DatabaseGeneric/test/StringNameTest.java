package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.LetterNotFoundException;

import java.util.Scanner;

public class StringNameTest {
    public static void main(String[] args) {
        printLine("Enter a name");
        String name = getName();
        printLine(name);
    }

    private static String getName() {
        boolean nameOk = false;
        String name = null;

        while (!nameOk) {
            try {
                name = getLetter();
                nameOk = true;
            } catch (LetterNotFoundException e) {
                e.getMessage();
            }
        }
        return name;
    }

    private static String getLetter() {
        Scanner input = new Scanner(System.in);
        String name;

        name = input.nextLine();
        if (name.matches("[a-zA-ZĄąĆćĘęŁłŃńÓóŚśŹźŻż]+")) {
            return name;
        } else {
            throw new LetterNotFoundException("Name must be letters only, try again");
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
