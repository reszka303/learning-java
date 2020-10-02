package javaStart.task27_Wrapper.Me.exercise1.extra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumberReaderFlexible {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Mateusz\\Desktop\\numbers.txt";
        final int lengthNumber = 10;

        try {
            List<BigInteger> integers = fromStringToBigInteger(fileName);
            printLine("The file contains the following numbers: ");
            printNumbers(integers);
            printLine("");
            BigInteger sumShortNumber = sumShortNumbers(integers, lengthNumber);
            BigInteger sumLongNumber = sumLongNumbers(integers, lengthNumber);
            printLine("Sum of short numbers is: " + sumShortNumber );
            printLine("Sum of long numbers is: " + sumLongNumber);
        } catch (FileNotFoundException e) {
            printLineError("No file: " + fileName);
        } catch (IOException e) {
            printLineError("Error read file: " + fileName);
        } catch (NumberFormatException e) {
            printLineError("The file is empty or" +
                    " there is some empty line in the file: " + fileName);
        }
    }

    private static List<BigInteger> fromStringToBigInteger(String fileName) throws IOException {
        try (var bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<BigInteger> integers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                integers.add(new BigInteger(line));
            }
            return integers;
        }
    }

    private static BigInteger sumLongNumbers(List<BigInteger> integers, int lengthDigit) {
        BigInteger sum = new BigInteger("0");

        for (BigInteger integer: integers) {
            if (integer.toString().length() > lengthDigit)
                sum = sum.add(integer);
        }
        return sum;
    }

    private static BigInteger sumShortNumbers(List<BigInteger> integers, int lengthDigit) {
        BigInteger sum = new BigInteger("0");

        for (BigInteger integer: integers) {
            if (integer.toString().length() <= lengthDigit)
                sum = sum.add(integer);
        }
        return sum;
    }

    private static void printNumbers(List<BigInteger> integers) {
        for (BigInteger integer : integers) {
            printLine("" + integer);
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}

