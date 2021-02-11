package javaStart.task40_CollectionProcessing.exercise1;

import java.util.List;

public class WordManager {
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
