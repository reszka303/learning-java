package javaStart.task35_Iterator.exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class WordsRemover {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter word number " + (i + 1));
            words.add(scanner.nextLine());
        }

        System.out.println("Enter some text to filter out:");
        String filterWord = scanner.nextLine();
        Iterator<String> iteratorWords = words.iterator();
        while (iteratorWords.hasNext()) {
            String next = iteratorWords.next();
            if (next.toLowerCase().contains(filterWord.toLowerCase())) {
                iteratorWords.remove();
            }
        }
        System.out.println(words);
    }
}


