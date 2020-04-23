package javaStart;

import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            scanner.useLocale(Locale.GERMANY);
            System.out.println("First number");
            double a = scanner.nextDouble();
            System.out.println("Second number");
            double b = scanner.nextDouble();
            double result = a - b;

        System.out.println(result);
        System.out.println("Let's start learning JavaStart");
    }
}
