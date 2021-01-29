package javaStart.task39_Streams.exercise1;

import java.util.stream.IntStream;

public class NumberGenerator {
    public static void main(String[] args) {
        IntStream.iterate(0, integer -> integer + 1)
                .filter(integer -> integer > 100 && integer < 1000 && integer % 5 == 0)
                .limit(10)
                .map(integer -> integer * 3)
                .forEach(System.out::println);
    }
}
