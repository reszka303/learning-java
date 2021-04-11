package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T10CapitalizeFirstLetterEveryWord {
    private static final String SIGNS_TO_DELETE = "[ ,.?!/'\\\\<>@#$%^&*()|+={};:~`-]+";
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String letter = create();
//        letter = capitalizeFirstLetterEveryWordStream(letter);
        letter = capitalizeFirstLetterEveryWordCharBuilder(letter);
//        letter = capitalizeFirstLetterEveryWordBuilder(letter);
//        letter = capitalizeFirstLetterEveryWordCharacterBuilder(letter);
        printLine(letter);

    }

    private static String capitalizeFirstLetterEveryWordStream(String letter) {
        return Arrays.stream(letter.toLowerCase().trim().split(SIGNS_TO_DELETE))
                .map(String::toCharArray)
                .peek(arr -> arr[0] = Character.toUpperCase(arr[0]))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static String capitalizeFirstLetterEveryWordCharBuilder(String letter) {
        String[] words = letter.toLowerCase().trim().split(SIGNS_TO_DELETE);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            word[0] = Character.toUpperCase(word[0]);
            if (i != 0) {
                sb.append(" ");
            }
            sb.append(String.valueOf(word));
        }
        return sb.toString();
    }

    public static String capitalizeFirstLetterEveryWordBuilder(String letter){
        String[] words = letter.trim().split(SIGNS_TO_DELETE);
        StringBuilder capitalizeWord = new StringBuilder();
        for(String word : words){
            String first = word.substring(0,1);
            String afterFirst = word.substring(1);
            capitalizeWord.append(first.toUpperCase()).append(afterFirst).append(" ");
        }
        return capitalizeWord.toString();
    }

    private static String capitalizeFirstLetterEveryWordCharacterBuilder(String letter) {
        String[] array = letter.trim().split(SIGNS_TO_DELETE);
        var builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                builder.append(Character.toUpperCase(array[i].charAt(0)))
                        .append(array[i].substring(1)).append(" ");
            }
        }
        return builder.toString();
    }

    private static String create() {
        printLine("Enter some letter");
        return input.nextLine();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
