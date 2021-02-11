package javaStart.task40_CollectionProcessing.exercise1;

import java.util.List;

public class ConsolePrinter {

    void printList(List<String> list) {
        for (String string : list) {
            printNoLine(string + " ");
        }
    }

    void printLine(String text) {
        System.out.println(text);
    }

    void printNoLine(String text) {
        System.out.print(text);
    }
}
