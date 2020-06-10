package javaStart.task21_StringClass.exercise1.Me;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = enterNumber(scanner);
        List<Character> lastNumbers = lastLetter(number, scanner);
        getLastNumbers(lastNumbers);
    }

    private static int enterNumber(Scanner scanner) {
        System.out.println("Enter the integer");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter " + number + " words");
        return number;
    }

    private static List<Character> lastLetter(int number, Scanner scanner) {
        int stringLength;
        int count = 0;
        String word;
        List<Character> lastNumbers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        while(count < number) {
            word = scanner.nextLine();
            stringLength = word.length();
            stringBuilder.append(word.charAt(stringLength - 1));
            lastNumbers.add(word.charAt(stringLength - 1));
            count++;
        }
        scanner.close();
        return lastNumbers;
    }

    private static void getLastNumbers(List<Character> lastNumbers) {
        for (Character character:
                lastNumbers) {
            System.out.print(character);
        }
    }
}
