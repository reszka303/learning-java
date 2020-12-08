package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.PositiveNumberNotFoundException;

import java.util.Scanner;

public class LongPositiveNumberTest {
    public static void main(String[] args) {
        System.out.println("Give id");
        long id = getId();

    }

    private static long getId() {
        Scanner input = new Scanner(System.in);
        long id = input.nextLong();

        if (id < 0) {
            throw new PositiveNumberNotFoundException("Id must be positive, try again");
        } else {
            System.out.println("It's ok: " + id);
        }
        return id;
    }
}
