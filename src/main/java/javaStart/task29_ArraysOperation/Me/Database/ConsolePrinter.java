package javaStart.task29_ArraysOperation.Me.Database;

import java.util.List;

public class ConsolePrinter {
    void printLetter(List<Letter> letters) {
        for (Letter letter : letters) {
            printLine(letter.toString());
        }
    }
    void printLine(String text) {
        System.out.println(text);
    }

    void printLineError(String text) {
        System.err.println(text);
    }
}
