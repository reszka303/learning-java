package javaStart.task21_StringClass.exercise2.Me;

import java.util.Scanner;

public class UpperLower {
    public static void main(String[] args) {
        String text = getWriting();
        text = transformation(text);
        printTextAfterTransformation(text);
    }

    private static String getWriting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some string");
        String writing = scanner.nextLine();
        scanner.close();
        return writing;
    }

    private static String transformation(String text) {
        if (Character.isUpperCase(text.charAt(0))) {
            text = text.toUpperCase();
        } else if (Character.isLowerCase(text.charAt(0))) {
            text = text.toLowerCase();
        }
        return text;
    }

    private static void printTextAfterTransformation(String text) {
        System.out.println("Text after transformation");
        System.out.println(text);
    }
}
