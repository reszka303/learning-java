package javaStart.task40_CollectionProcessing.exercise1;

import java.util.List;

public class ConsolePrinter {
    WordManager wordManager = new WordManager();
    String printStatsWord(List<String> list) {
        var builder = new StringBuilder();
        long firstLetterS = wordManager.wordsStartingWithS(list);
        long lettersFiveLength = wordManager.wordsWithLengthFiveLetter(list);
        builder.append("Number of words with first letter 's': ");
        builder.append(firstLetterS);
        builder.append("\n");
        builder.append("Number of words with 5 letters ");
        builder.append(lettersFiveLength);
        return builder.toString();
    }

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
