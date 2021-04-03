package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.Arrays;
import java.util.Scanner;

public class T7CapitalizeEveryNewWord {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        String letter = create();
        String letter = "real madryt";
//        letter = capitalizeFirstLetter(letter);
//        printLine(letter);
        letter = capitalizeFirstWord(letter);
        printLine(letter);
    }

    private static String create() {
        printLine("Enter some letter");
        return input.nextLine().trim();
    }

    private static String capitalizeFirstWord(String letter) {
        String[] arr = letter.split(" ");
        printLine("Array of String " + Arrays.toString(arr));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return builder.toString().trim();
    }

    private static String capitalizeFirstLetter(String letter) {
        return Character.toUpperCase(letter.charAt(0)) + letter.substring(1);
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
