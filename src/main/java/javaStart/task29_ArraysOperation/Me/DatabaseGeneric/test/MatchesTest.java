package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import java.util.Scanner;

public class MatchesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text="abcABC983";
        System.out.println(text.matches("^[a-zA-Z0-9]+$"));

        int vinLength = 4;
        System.out.println("Podaj vin");
        String vin = input.nextLine();

        if (vin.length() == vinLength) {
            System.out.println(vin);
        } else if (vin.length() != vinLength) {
            System.out.println("Vin musi zawierać 4 znaki");
        } else if (vin.matches("^[a-zA-Z0-9]+$")) {
            System.out.println(vin);
        } else if (!vin.matches("^[a-zA-Z0-9]+$")){
            System.out.println("Vin nie może zawierać minusów oraz double");
        }
    }
}
