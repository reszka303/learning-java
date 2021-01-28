package javaStart.task39_Streams.lesson.TerminalMethod;

import java.util.stream.Stream;

public class TerminalReduce {
    public static void main(String[] args) {
        Stream<Course> courseStream = Stream.of(
                new Course(1L, "Java", 199, "Programowanie"),
                new Course(2L, "Sztuka pisania", 99, "Rozwój osobisty"),
                new Course(3L, "Tajniki Google", 299, "Marketing")
        );

        //Rozwiązanie z wyrażeniem lambda
//        Double sumPriceLambda = courseStream.map(Course::getPrice).reduce(0.0, (result, next) -> result + next);
//        System.out.println("Wszystkie kursy kosztują: " + sumPriceLambda);

        //Rozwiązanie z referencją do metody
        Double sumPriceReferenceMethod = courseStream.map(Course::getPrice).reduce(0.0, Double::sum);
        System.out.println("Wszystkie kursy kosztują: " + sumPriceReferenceMethod);

        Stream<String> names = Stream.of("Asia", "Kasia", "Basia");
        String allNames = names.reduce("", (result, next) -> result + next + " ");
        System.out.println(allNames);
    }
}
