package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.IncorrectCharacterException;

import java.util.Scanner;

public class CharTest {
    public static void main(String[] args) {
        char sex = getSex();
        printLine("" + sex);
    }

    private static char getSex() {
        boolean sexOk = false;
        char sex = ' ';

        printLine("Owner's sex: male 'm' or female 'f'");

        while (!sexOk) {
            try {
                sex = checkCharacter();
                sexOk = true;
            } catch (IncorrectCharacterException e) {
                e.getMessage();
            } catch (StringIndexOutOfBoundsException e) {
                printLineError("Character can't be empty, try again");
            }
        }
        return sex;
    }


    private static Character checkCharacter() {
        Scanner input = new Scanner(System.in);
        char male = 'm';
        char female = 'f';
        char sex;

        sex = input.nextLine().charAt(0);
        if (sex == male || sex == female) {
            return sex;
        } else {
            throw new IncorrectCharacterException("Enter 'm' or 'f'");
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
