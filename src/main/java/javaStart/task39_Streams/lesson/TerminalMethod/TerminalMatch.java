package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.stream.Stream;

public class TerminalMatch {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );

//        boolean under100 = courseStream.anyMatch(course -> course.getPrice() < 100);
//        if (under100)
//            System.out.println("Co najmniej jeden z kursów jest tańszy niż 100 zł");
//
//        boolean above10 = courseStream.allMatch(course -> course.getPrice() > 10);
//        if (above10)
//            System.out.println("Wszystkie kursy są droższe niż 10 zł");

        boolean above300 = courseStream.noneMatch(course -> course.getPrice() > 300);
        if (above300)
            System.out.println("Żaden kurs nie jest droższy niż 300 zł");
    }
}
