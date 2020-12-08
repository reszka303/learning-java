package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.IncorrectIdLengthException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.PositiveNumberNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LongTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long id = getId();
        printLine("Id is: " + id);
    }

    private static long getId() {
        boolean idOk = false;
        long id = -1L;

        while (!idOk) {
            try {
                printLine("Give id");
                id = getNumber();
                idOk = true;
            } catch (InputMismatchException e) {
                printLineError("You need enter a number, try again");
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (IncorrectIdLengthException e) {
                e.getMessage();
            }
        }
        return id;
    }

    private static long getNumber() {
        Scanner input = new Scanner(System.in);
        int correctLengthId = 11;
        int negative = -1;
        long id = input.nextLong();
        long lengthId = String.valueOf(id).length();

        if (id <= negative) {
            throw new PositiveNumberNotFoundException("Id must be positive, try again");
        } else if (lengthId == correctLengthId) {
            return id;
        } else if (lengthId != correctLengthId) {
            throw new IncorrectIdLengthException("Incorrect length of id, try again");
        }
        return id;
    }

    static void printLine(String text) {
        System.out.println(text);
    }

    static void printLineError(String text) {
        System.err.println(text);
    }
}
