package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.test;

import javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception.LengthNumberException;
import javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception.PositiveNumberNotFoundException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        printLine("Give an id");
        BigInteger id = readId();
        printLine("The id is: " + id.toString());
    }

    private static BigInteger readId() {
        Scanner input = new Scanner(System.in);
        BigInteger id = new BigInteger("-1");
        boolean idOk = false;

        while (!idOk) {
            while (id.signum() < 0 || id.toString().length() != 11) {
                try {
                    id = input.nextBigInteger();
                    if (id.signum() < 0) {
                        throw new PositiveNumberNotFoundException("The number must be positive, try again");
                    } else if (id.toString().length() != 11) {
                        throw new LengthNumberException("The number must be 11 digits, try again");
                    } else {
                        idOk = true;
                    }
                } catch (PositiveNumberNotFoundException e) {
                    e.getMessage();
                } catch (LengthNumberException e) {
                    e.getMessage();
                } catch (InputMismatchException e) {
                    printLineError("You didn't enter number, try again");
                } finally {
                    input.nextLine();
                }
            }
        }

        return id;
    }


    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
