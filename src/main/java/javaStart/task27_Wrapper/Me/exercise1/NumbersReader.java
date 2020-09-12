package javaStart.task27_Wrapper.Me.exercise1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumbersReader {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Mateusz\\Desktop\\numbers.txt";

        try {
            List<BigInteger> integers = fromStringToBigInteger(fileName);
            printNumbers(integers);
            BigInteger sumShortNumbers = addShortNumbers(integers);
            printLine("" + sumShortNumbers);
            BigInteger sumLongNumbers = addLongNumbers(integers);
            printLine("" + sumLongNumbers);
        } catch (FileNotFoundException e) {
            printLineError("No file: " + fileName);
        } catch (IOException e) {
            printLineError("Error read file: " + fileName);
        }
    }

    static void printLine(String text) {
        System.out.println(text);
    }

    static void printLineError(String text) {
        System.err.println(text);
    }

    static List<BigInteger> fromStringToBigInteger(String fileName) throws IOException {
        try (var bR = new BufferedReader(new FileReader(fileName))) {
            List<BigInteger> integers = new ArrayList<>();
            String line;
            while ((line = bR.readLine()) != null) {
                var bigInteger = new BigInteger(line);
                integers.add(bigInteger);
            }
         return integers;
        }
    }

    static void printNumbers(List<BigInteger> integers) {
        for (BigInteger integer :
                integers) {
            printLine("" + integer);
        }
    }

    static BigInteger addShortNumbers(List<BigInteger> integers) {
        BigInteger sum = null;
        for (BigInteger integer:
             integers) {
            sum = integers.get(0).add(integers.get(1).add(integers.get(2)));
        }
        return sum;
    }

    static BigInteger addLongNumbers(List<BigInteger> integers) {
        BigInteger sum = null;
        for (BigInteger integer:
             integers) {
            sum = integers.get(3).add(integers.get(4));
        }
        return sum;
    }
}

