package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.IncorrectIdLengthException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.PositiveNumberNotFoundException;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BigIntegerTest {
    public static void main(String[] args) {
        printLine("Id");
        BigInteger id = getId();
        printLine(id.toString());

    }

    private static BigInteger getId() {
        boolean idOk = false;
        BigInteger id = new BigInteger("-1");

        while (!idOk) {
            try {
                id = checkId();
                idOk = true;
            } catch (PositiveNumberNotFoundException e) {
                e.getMessage();
            } catch (IncorrectIdLengthException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("Id must be digits, try again");
            }
        }
        return id;
    }

    private static BigInteger checkId() {
        Scanner input = new Scanner(System.in);
        int sizeId = 11;
        int negative = -1;
        BigInteger id;

        id = input.nextBigInteger();
        if (id.toString().length() == sizeId) {
            return id;
        } else if (id.signum() == negative){
            throw new PositiveNumberNotFoundException("Id must be positive, try again");
        } else if (id.toString().length() != sizeId) {
            throw new IncorrectIdLengthException("Id must be 11 characters, try again");
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
