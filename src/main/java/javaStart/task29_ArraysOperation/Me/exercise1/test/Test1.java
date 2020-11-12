package javaStart.task29_ArraysOperation.Me.exercise1.test;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.LengthNumberException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.PositiveNumberNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        printLine("Give an id");
        int id = readId();
        printLine("The id is: " + id);
    }

    private static int readId() {
        Scanner input = new Scanner(System.in);
        int number = -1;
        while (number < 0 || String.valueOf(number).length() != 7) {
            try {
                number = input.nextInt();
                if (number < 0) {
                    throw new PositiveNumberNotFoundException("The number must be positive, try again");
                } else if (String.valueOf(number).length() != 7) {
                    throw new LengthNumberException("The number must be 7 digits, try again");
                }
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (LengthNumberException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("You didn't enter numbers or" +
                        " you entered too long integer, try again");
            } finally {
                input.nextLine();
            }
        }
        return number;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
