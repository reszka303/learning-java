package javaStart.task27_Wrapper.Me.exercise2;

import java.util.Arrays;
import java.util.Scanner;

public class WordsReader {
    public static void main(String[] args) {
        String text = readerText();
        char[] marksInCharArray = text.toCharArray();
        String[] marksInStringArray = toStringArray(marksInCharArray);
        String marksInSingleString = toSingleString(marksInStringArray);
        String digitsInString = toStringWithOnlyDigits(marksInSingleString);
        int[] digitsInIntArray = toIntArray(digitsInString);
        int letter = counterLetters(marksInCharArray);
        int digit = counterDigits(marksInCharArray);
        int space = counterSpace(marksInCharArray);
        int otherMarks = counterOther(marksInCharArray);
        int allMarks = counterAllMarks(marksInStringArray);
        int maxDigit = highestDigit(digitsInIntArray);
        String messageText = printNumberLettersDigitsSpacesOthers(text,
                letter, digit, space, otherMarks, allMarks);
        printLine("" + messageText);
        try {
            String printArray = printArray(digitsInIntArray);
            String highestDigit = printHighestDigit(maxDigit);
            printLine(printArray);
            printLine(highestDigit);
        } catch (DigitNotFoundException e) {
            printLine("There is no digits, array is empty");
        }
    }

    private static String readerText() {
        var input = new Scanner(System.in);
        printLine("Enter any text with letters and digits or other marks if you want");
        String text = input.nextLine();
        close();
        return text;
    }

    private static String[] toStringArray(char[] marksInCharArray) {
        int size = marksInCharArray.length;
        String[] marksInStringArray = new String[size];
        for (int i = 0; i < marksInStringArray.length; i++) {
            marksInStringArray[i] = Character.toString(marksInCharArray[i]);
        }
        return marksInStringArray;
    }

    private static String toSingleString(String[] marksInStringArray) {
        int size = marksInStringArray.length;
        var marksInSingleString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            marksInSingleString.append(marksInStringArray[i]);
        }
        return marksInSingleString.toString();
    }

    private static String toStringWithOnlyDigits(String marksInSingleString) {
        int size = marksInSingleString.length();
        var digitsInString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char specifiedCharacter = marksInSingleString.charAt(i);
            if (Character.isDigit(specifiedCharacter)) {
                digitsInString.append(specifiedCharacter);
            }
        }
        return digitsInString.toString();
    }

    private static int[] toIntArray(String digitsInString) {
        int size = digitsInString.length();
        int[] digitsInIntArray = new int[size];
        String[] digits = digitsInString.split("");

        for (int i = 0; i < size; i++) {
            digitsInIntArray[i] = Integer.parseInt(digits[i]);
        }
        return digitsInIntArray;
    }

    private static int counterLetters(char[] marks) {
        int letter = 0;
        for (int i = 0; i < marks.length; i++) {
            if (Character.isLetter(marks[i]))
                letter++;
        }
        return letter;
    }

    private static int counterDigits(char[] marks) {
        int digit = 0;
        for (int i = 0; i < marks.length; i++) {
            if (Character.isDigit(marks[i])) {
                digit++;
            }
        }
        return digit;
    }

    private static int counterSpace(char[] marks) {
        int space = 0;
        for (int i = 0; i < marks.length; i++) {
            if (Character.isSpaceChar(marks[i])) {
                space++;
            }
        }
        return space;
    }

    private static int counterOther(char[] marks) {
        int other = 0;
        for (int i = 0; i < marks.length; i++) {
            if (Character.isLetter(marks[i]) || Character.isDigit(marks[i])
                    || Character.isSpaceChar(marks[i])) {
            } else {
                other++;
            }
        }
        return other;
    }

    private static int counterAllMarks(String[] marksInStringArray) {
        int allMarks = 0;
        for (int i = 0; i < marksInStringArray.length; i++) {
                allMarks++;
        }
        return allMarks;
    }

    private static int highestDigit(int[] digitsInIntArray) {
        int maxDigit = 0;
        for (int i = 0; i < digitsInIntArray.length; i++) {
            if (digitsInIntArray[i] > maxDigit) {
                maxDigit = digitsInIntArray[i];
            }
        }
        return maxDigit;
    }

    private static String printArray(int[] digitsInIntArray) {
        String printArray;
        if (digitsInIntArray.length != 0) {
            printArray = "" + Arrays.toString(digitsInIntArray);
        } else {
            throw new DigitNotFoundException();
        }
        return printArray;
    }

    private static String printHighestDigit(int maxDigit) {
        String printHighestDigit;
        if (maxDigit >= 0) {
            printHighestDigit = "The highest digit of array is: " + maxDigit;
        } else {
            printHighestDigit = "";
        }
        return printHighestDigit;
    }

    private static String printNumberLettersDigitsSpacesOthers(String text,
                                                               int letter,
                                                               int digit,
                                                               int space,
                                                               int other,
                                                               int total) {
        var messageText = new StringBuilder();
        messageText.append("The following text: ");
        messageText.append("'" + text + "'");
        messageText.append("\n");
        messageText.append("contains the following number of: ");
        messageText.append("\n");
        messageText.append("letters: " + letter);
        messageText.append("\n");
        messageText.append("digits: " + digit);
        messageText.append("\n");
        messageText.append("spaces: " + space);
        messageText.append("\n");
        messageText.append("other: " + other);
        messageText.append("\n");
        messageText.append("total: " + total);
        messageText.append("\n");
        messageText.append("The array contains the following digits: ");
        return messageText.toString();
    }

    private static void close() {
        var input = new Scanner(System.in);
        input.close();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static class DigitNotFoundException extends RuntimeException{}
}

