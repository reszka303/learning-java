package javaStart.task29_ArraysOperation.Me.exercise1.test;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.LengthNumberException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.PositiveNumberNotFoundException;

import java.math.BigInteger;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printLine("Give a number");
        BigInteger number = input.nextBigInteger();
        if (number.signum() < 0) {
            throw new PositiveNumberNotFoundException("The number must be positive, try again");
        } if (number.toString().length() != 11) {
            throw new LengthNumberException("The number must be 11 digits, trt again");
        } else {
            printLine("The number is: " + number.toString());
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
