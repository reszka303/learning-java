package javaStart.task39_Streams.lesson.IntermediateMethod;

import javaStart.task39_Streams.lesson.TerminalMethod.Course;

import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateSkip {
    public static void main(String[] args) {
        Stream<Course> courses = Stream.of(
                new Course(1L, "Java", 249, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing"),
                new Course(4L, "Java od podstaw", 159, "Programowanie"),
                new Course(5L, "Python od podstaw", 139, "Programowanie")
        );
        courses.sorted(Comparator.comparingDouble(Course::getPrice))
                .skip(3)
                .forEach(System.out::println);
    }
}
