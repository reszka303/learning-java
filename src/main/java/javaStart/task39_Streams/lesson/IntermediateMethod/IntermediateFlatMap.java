package javaStart.task39_Streams.lesson.IntermediateMethod;

import javaStart.task39_Streams.lesson.TerminalMethod.Course;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntermediateFlatMap {
    public static void main(String[] args) {
        Course[] cheapCourses = {
                new Course(1L, "Java", 49, "Programowanie"),
                new Course(2L, "Sztuka pisania", 79, "Rozwój osobisty"),
        };

        Course[] expensiveCourses = {
                new Course(3L, "Tajniki Google", 299, "Marketing"),
                new Course(4L, "Python od podstaw", 169, "Programowanie")
        };

        //Metoda flatMap() przekształca strumień kolekcji na strumień pojedyńczych obiektów
        //W tym przypadku z dwóch obiektów tablicowych przekształciła w jedną tablicę obiektów
        Stream.of(cheapCourses, expensiveCourses)
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

    }
}
