package javaStart.task39_Streams.lesson.IntroductionToStreams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Filtering {
    public static void main(String[] args) {
        IntStream numbers = IntStream.of(1,2,3,4,5);

        int[] evenNumbers = numbers
                .filter(number -> number % 2 == 0)
                .toArray();
        System.out.println(Arrays.toString(evenNumbers));

    }
}
