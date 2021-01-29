package javaStart.task39_Streams.lesson.IntermediateMethod;

import javaStart.task39_Streams.lesson.TerminalMethod.Course;

import java.util.stream.Stream;

public class IntermediateFilter {
    public static void main(String[] args) {
        Stream<Course> courses = Stream.of(
                new Course(1L, "Java", 249, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Zarządznie zespołem", 159, "Biznes"),
                new Course(4L, "Tajniki Google", 299, "Marketing"),
                new Course(5L, "Python od podstaw", 169, "Programowanie")
        );

        courses.filter(course -> course.getPrice() > 200)
                .forEach(System.out::println);
    }
}
