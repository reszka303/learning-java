package javaStart.task35_Iterator.lesson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorRemoverException {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kasia");
        names.add("Basia");
        names.add("Basia");
        names.add("Kajtek");
        names.add("Wojtek");
        names.add("Maniek");
        System.out.println("Lista pierwotna " + names);

        int counter = 0;

        System.out.println("Pętla dodająca");
        for (int i = 0; i < names.size(); i++) {
            counter++;
            String name = names.get(i);
            System.out.println(name);
        }
        System.out.println(names.size());
        System.out.println(counter);
        if (names.size() == counter)
            names.add("Paweł");

        System.out.println("Lista po dodaniu: " + names);

        // pętla ok, bo nie korzystamy z iteratora
        System.out.println(">>> Pętla 1");
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
            if (name.equals("Basia")) {
                names.remove(name);
                i--;
            }
        }
        System.out.println(names);

        System.out.println(">>> Usuwanie obiektu z kolekcji metodą remove() iteratora");
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            String name = namesIterator.next();
            System.out.println(name);
            if (namesIterator.equals("Basia")) {
                namesIterator.remove();
            }
        }
    }
}
