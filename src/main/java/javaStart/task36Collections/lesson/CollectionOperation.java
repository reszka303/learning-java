package javaStart.task36Collections.lesson;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionOperation {
    public static void main(String[] args) {
        String sentence = "Strona testowa służy dwóm celom: stanowi wizualne potwierdzenie "
                + "działania drukarki i może również zawierać informacje pomocne podczas "
                + "rozwiązywania problemów, takie jak szczegóły dotyczące sterownika drukarki.";
        List<String> words = Arrays.asList(sentence.split(" "));
        System.out.println("Lista oryginalna: ");
        printCollection(words);

        // wymieszanie słów
        Collections.shuffle(words);
        System.out.println("Lista shuffle");
        printCollection(words);

        // sortowanie
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Lista sort");
        printCollection(words);

        // wyszukiwanie binarne
        int position = Collections.binarySearch(words, "drukarki");
        System.out.println("Słowo \"drukarki\" jest w liście na " + position + " miejscu");
        // ilość wystąpień
        int freq = Collections.frequency(words, "Strona");
        System.out.println("Słowo \"Strona\" występuje na liście " + freq + " razy");
        // najmniejszy element w liście
        System.out.println("Najmniejszy element w liście to: " + Collections.min(words));
    }

    private static void printCollection(Collection<String> collection) {
        for (String s : collection) {
            System.out.print(s + "; ");
        }
        System.out.println();
    }
}
