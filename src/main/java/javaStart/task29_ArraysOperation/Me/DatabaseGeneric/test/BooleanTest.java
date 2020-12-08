package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BooleanTest {
    public static void main(String[] args) {
        System.out.println("Damage? - true or false");
        boolean damage = getBoolean();
        System.out.println(damage);

    }

    private static boolean getBoolean() {
        Scanner input = new Scanner(System.in);
        boolean damagedOk = false;
        boolean damaged = false;

        while (!damagedOk) {
            try {
                damaged = input.nextBoolean();
                if (damaged) {
                    System.out.println("Damaged - true");
                    damagedOk = true;
                } else {
                    System.out.println("Undamaged - false");
                    damagedOk = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Valid input");
            } finally {
                input.nextLine();
            }
        }
        return damaged;
    }
}
