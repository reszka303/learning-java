package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.Arrays;
import java.util.stream.Stream;

public class TerminalToArray {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );
        //Lamdba
//        Course[] toArrayLambda = courseStream.toArray(course -> new Course[course]);
//        System.out.println(Arrays.toString(toArrayLambda));

        //Referencja do konstruktora
        Course[] toArrayReferenceToConstructor = courseStream.toArray(Course[]::new);
        System.out.println(Arrays.toString(toArrayReferenceToConstructor));

    }
}
