package javaStart.task14_Algorithmics.exercise2.structural;

import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        int multi = 1;
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < 5 ; index++) {
            System.out.println("Give an integer");
            int next = scanner.nextInt();
            multi *= next;
        }

        if (multi >= 0) {
            System.out.println(multi + " non-negative");
        } else {
            System.out.println(multi + " negative");
        }
    }
}
