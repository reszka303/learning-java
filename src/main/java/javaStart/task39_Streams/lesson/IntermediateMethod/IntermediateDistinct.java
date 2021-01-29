package javaStart.task39_Streams.lesson.IntermediateMethod;

import javaStart.task39_Streams.lesson.TerminalMethod.Course;

import java.util.stream.Stream;

public class IntermediateDistinct {
    public static void main(String[] args) {
        Stream<Course> courses = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(3L, "Tajniki Google", 299, "Marketing"),
                new Course(1L, "Java", 199, "Programowanie")
        );
        Stream<Course> uniqueStream = courses.distinct();
        uniqueStream.forEach(System.out::println);
    }
}
