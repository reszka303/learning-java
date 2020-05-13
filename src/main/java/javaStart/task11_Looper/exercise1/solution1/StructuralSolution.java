package javaStart.task11_Looper.exercise1.solution1;

import java.util.Scanner;

public class StructuralSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Declare how many integers you provide");
        int declaredNumber = scanner.nextInt();
        System.out.println("You declared that you would provide: " + declaredNumber + " numbers");
        System.out.println("Give some integers as many times as you declared");

        int sumOfNumbers = 0;
        int numbers = 0;
        int count = 1;

        for (int i = 0; i < declaredNumber ; i++) {
            System.out.println("Give " + count + "number");
            numbers = scanner.nextInt();
            sumOfNumbers += numbers;
            count++;

        }
        System.out.println("The sum of the numbers you provided is as follows:" +
                " " + sumOfNumbers);
        scanner.close();
    }
}
