package javaStart.task38_MethodReference.exercise1;

import java.util.*;

public class NameGenerator {
    public static void main(String[] args) {
        List<String> names = listOfNames();
        printLine("Lista oryginalna: " + "\n" + names.toString());
        System.out.println();

        printLine("Lista po sortowaniu bez uwzględnienia dużych liter: " + "\n" + names.toString());
        System.out.println();

        /*
        Rozwiązanie przed Javą 8
        Obiekt klasy anonimowej - ignoruje duże litery
        Comparator interface funkcyjny ma metodę compare z następującą sygnaturą:
        int compare(T o1, T o2)
        wyrażenie lambda z powyższą sygnaturą to:
        (String a, String b) -> int
        */
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareToIgnoreCase(name2);
            }
        });
        printLine("Lista po sortowaniu igorująca duże litery: " + "\n" + names.toString());
        System.out.println();

        //Rozwiązanie z wyrażeniem lambda
        Collections.sort(names, (name1, name2) -> name1.compareToIgnoreCase(name2));
        printLine("Lista + wyrażenie lambda" + "\n" + names.toString());
        System.out.println();

        //Rozwiązanie z referencją do metody
        names.sort(String::compareToIgnoreCase);
        printLine("Lista + referencja do metody" + "\n" + names.toString());
        System.out.println();

        printLine("Wyświetlenie listy za pomocą forEach()");
        names.forEach(System.out::println);

    }

    private static List<String> listOfNames() {
//        List<String> names = Arrays.asList("Peter", "peter", "Gregory", "Leonardo", "Tom", "Joseph", "gregory");
//        return names;
        // powyższy zapis to jest to samo co poniżej, tylko że krócej

        return Arrays.asList("Peter", "peter", "Gregory", "Leonardo", "Tom", "Joseph", "gregory");
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
