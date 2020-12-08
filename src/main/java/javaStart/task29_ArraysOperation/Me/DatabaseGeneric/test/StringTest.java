package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.IncorrectCharacterException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.IncorrectStringLengthException;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
//        String vin = getString();
//        System.out.println(vin);

        String sex = getSex();
        System.out.println(sex);
    }

    private static String getString() {
        boolean vinOk = false;
        String vin = null;

        while (!vinOk) {
            try {
                System.out.println("Enter some writing");
                vin = checkStringLength();
                vinOk = true;
            } catch (IncorrectStringLengthException e) {
                e.getMessage();
            }
        }
        return vin;
    }

    private static String checkStringLength() {
        Scanner input = new Scanner(System.in);
        final int vinLength = 17;
        String vin = input.nextLine();
        if (vin.length() == vinLength) {
            return vin;
        } else {
            throw new IncorrectStringLengthException("Vin must be 17" +
                    " characters, try again");
        }
    }

    private static String getSex() {
        boolean sexOk = false;
        String sex = null;
        System.out.println("Owner's sex: men 'm' or women 'w'");

        while (!sexOk) {
            try {
                sex = getGender();
                sexOk = true;
            } catch (IncorrectCharacterException e) {
                e.getMessage();
            }
        }
        return sex;
    }

    private static String getGender() {
        Scanner input = new Scanner(System.in);
        final String male = "m";
        final String female = "f";
        String sex;

        sex = input.nextLine();
        if (sex.equals(male) || sex.equals(female)) {
            return sex;
        } else {
            throw new IncorrectCharacterException("Enter 'm' or 'w'");
        }
    }
}
