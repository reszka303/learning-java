package javaStart.task39_Streams.lesson.IntermediateMethod;

import javaStart.task39_Streams.lesson.TerminalMethod.Course;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediatePeek {
    public static void main(String[] args) {
        Stream<Course> courses = Stream.of(
                new Course(1L, "Java", 249, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Java od podstaw", 159, "Programowanie"),
                new Course(4L, "Tajniki Google", 299, "Marketing")
        );
        List<String> javaTitles = courses.filter(course -> course.getName().toLowerCase().contains("java"))
                .peek(course -> System.out.println("Filtered stream: " + course))
                .map(Course::getName)
                .collect(Collectors.toList());
        System.out.println(javaTitles);
    }
}
