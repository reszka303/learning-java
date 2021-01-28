package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.stream.Stream;

public class TerminalCount {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );
        long count = courseStream.count();
        System.out.println(count);
    }
}
