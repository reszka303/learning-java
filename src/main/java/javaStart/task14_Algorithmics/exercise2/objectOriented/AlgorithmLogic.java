package javaStart.task14_Algorithmics.exercise2.objectOriented;

import java.util.Scanner;

public class AlgorithmLogic {
    static int multi() {
        int multi = 1;
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < 5 ; index++) {
            System.out.println("Give an integer");
            int next = scanner.nextInt();
            multi *= next;
        }
        return multi;
    }

    static void printMulti(int multi) {
        if (multi >= 0) {
            System.out.println(multi + " non-negative");
        } else {
            System.out.println(multi + " negative");
        }
    }
}
