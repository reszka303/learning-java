package javaStart.task40_CollectionProcessing.exercise1;

import java.util.List;

public class WordManager {
    String printStatsWord(List<String> list) {
        var builder = new StringBuilder();
        long firstLetterS = wordsStartingWithS(list);
        long lettersFiveLength = wordsWithLengthFiveLetter(list);
        builder.append("Number of words with first letter 's': ");
        builder.append(firstLetterS);
        builder.append("\n");
        builder.append("Number of words with 5 letters ");
        builder.append(lettersFiveLength);
        return builder.toString();
    }

    long wordsStartingWithS(List<String> list) {
        return list.stream()
                .filter(WordManager::wordsBySLetter)
                .peek(System.out::println)
                .count();
    }

    long wordsWithLengthFiveLetter(List<String> list) {
        return list.stream()
                .filter(WordManager::wordsByLengthLetter)
                .peek(System.out::println)
                .count();
    }

    private static boolean wordsByLengthLetter(String s) {
        return s.length() == 5;
    }

    private static boolean wordsBySLetter(String s) {
        return s.startsWith("s");
    }
}
