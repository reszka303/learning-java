package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalMinMax {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );
        Optional<Course> courseOptional = courseStream.max(Comparator.comparing(Course::getPrice));
        courseOptional.ifPresent(System.out::println);

    }
}
