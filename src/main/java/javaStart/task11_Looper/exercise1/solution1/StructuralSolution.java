package javaStart.task11_Looper.exercise1.solution1;

import java.util.Scanner;

public class StructuralSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Declare how many integers you provide");
        int numbers = scanner.nextInt();
        System.out.println("You declared that you would provide: " +
                numbers + " numbers, give them");

        int sum = 0;
        while (numbers > 0) {
            sum = sum + scanner.nextInt();
            System.out.println("Give next number");
            numbers--;
        }

        System.out.println("The sum of the numbers is as follows: " +
                sum);
        scanner.close();
    }
}
