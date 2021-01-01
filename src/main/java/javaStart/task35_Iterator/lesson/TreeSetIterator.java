package javaStart.task35_Iterator.lesson;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetIterator {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(45);
        numbers.add(3);
        numbers.add(21);
        numbers.add(150);
        numbers.add(1);

        Iterator<Integer> numberIterator = numbers.iterator();
        while (numberIterator.hasNext()) {
            int number = numberIterator.next();
            System.out.println(number);
        }
    }
}
