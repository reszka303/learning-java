package javaStart.task39_Streams.lesson.IntroductionToStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Mapping {
    public static void main(String[] args) {
        Stream<String> letters = Stream.of("a", "b", "c");
        String[] strings = letters
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
