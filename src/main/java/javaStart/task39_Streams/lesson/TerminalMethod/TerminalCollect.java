package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalCollect {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );

        //kolekcja jakieś listy List
//        List<Course> collectList = courseStream.collect(Collectors.toList());
//        System.out.println(collectList);

        //kolekcja listy ArrayList
//        ArrayList<Course> collectArrayList = courseStream.collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(collectArrayList);

        //kolekcja jakiegoś zbioru Set
//        Set<Course> collectSet = courseStream.collect(Collectors.toSet());
//        System.out.println(collectSet);

        //kolekcja zbiory TreeSet, nie uruchomi się bo nie ma implementacji comparable
        TreeSet<Course> collectTreeSet = courseStream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collectTreeSet);
    }
}
