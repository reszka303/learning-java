package javaStart.task14_Algorithmics.exercise1.structural;

import java.util.Scanner;

public class CheckSumStructural {
    public static void main(String[] args) {
        int next = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give an integer");
        while ((next = scanner.nextInt()) <= 100) {
            System.out.println("Give an integer");
                sum += next;
        }

        System.out.println(sum);
        if (sum % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
