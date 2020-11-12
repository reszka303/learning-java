package javaStart.task29_ArraysOperation.Me.exercise1.test;

import java.math.BigInteger;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printLine("Give an id");
        BigInteger bigInteger1 = input.nextBigInteger();
        printLine("The id is: " + bigInteger1.toString());
    }
    private static void printLine(String text) {
        System.out.println(text);
    }
}
