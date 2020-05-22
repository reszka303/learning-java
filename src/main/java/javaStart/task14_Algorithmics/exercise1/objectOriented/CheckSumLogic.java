package javaStart.task14_Algorithmics.exercise1.objectOriented;

import java.util.Scanner;

public class CheckSumLogic {
    static int sum() {
        int sum = 0;
        int next = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give an integer");
        while ((next = scanner.nextInt()) <= 100) {
            System.out.println("Give an integer");
            sum += next;
        }
        return sum;
    }

    static void printEvenOrOdd(int sum) {
        if (sum % 2 == 0) {
            System.out.println("Sum is " + sum + "and is even");
        } else {
            System.out.println("Sum is " + sum + " and is odd");
        }
    }
}
