package javaStart.task29_ArraysOperation.Me.Database;

import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

    Letter createLetter() {
        printer.printLine("Enter some text");
        String text = input.nextLine();

        return new Letter(text);
    }

    int getInt() {
        try {
            return input.nextInt();
        } finally {
            clearBuffer();
        }
    }

    void close() {
        input.close();
    }

    void clearBuffer() {
        input.nextLine();
    }
}
