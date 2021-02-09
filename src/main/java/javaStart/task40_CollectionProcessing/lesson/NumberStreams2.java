package javaStart.task40_CollectionProcessing.lesson;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStreams2 {
    public static void main(String[] args) {
        List<Integer> squareNumbers = IntStream.range(0,  100)
                .map(NumberStreams2::square)
                .boxed()
                .collect(Collectors.toList());
        //zbiór kwadratów liczb
        Set<Integer> biggerThan5 = squareNumbers.stream()
                .filter(NumberStreams2::isDividedBy)
                .map(NumberStreams2::divide)
                .collect(Collectors.toCollection(TreeSet<Integer>::new));

        System.out.println("List");
        squareNumbers.forEach(x -> System.out.print(x + " ; "));
        System.out.println("\nSet");
        biggerThan5.forEach(x -> System.out.print(x + " ; "));
    }

    private static Integer square(Integer x) {
        return x * x;
    }

    private static boolean isDividedBy(Integer x) {
        return x % 10 == 0;
    }

    private static Integer divide(Integer x) {
        return x / 10;
    }
}
