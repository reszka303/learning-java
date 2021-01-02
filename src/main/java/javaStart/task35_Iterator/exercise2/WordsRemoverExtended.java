package javaStart.task35_Iterator.exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class WordsRemoverExtended {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> words = getFilledListOfWords();
        printLine(words.toString());
        words = filterOutWords(words);
        printLine(words.toString());

    }

    private static List<String> getFilledListOfWords() {
        int maxSize = 5;
        int counter = 0;
        ArrayList<String> words = new ArrayList<>();

        while (maxSize > counter) {
            counter++;
            printLine("Enter word number " + counter);
            String word = input.nextLine();
            words.add(word);
        }


//        for (int i = 0; i < maxSize; i++) {
//            printLine("Enter word " + (i + 1));
//            String word = input.nextLine();
//            words.add(word);
//        }
        return words;
    }

    private static List<String> filterOutWords(List<String> words) {
        printLine("Enter some text to filter out:");
        String filterWord = input.nextLine();
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.toLowerCase().contains(filterWord.toLowerCase())) {
                iterator.remove();
            }
        }
        return words;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
