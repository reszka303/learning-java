package javaStart.task39_Streams.lesson.IntroductionToStreams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamGenerator {
    public static void main(String[] args) {
        IntStream intStream = IntStream.iterate(0, integer -> integer + 1);
        IntStream limit = intStream.limit(101);
        int[] ints = limit.toArray();
        System.out.println("Metoda limit()");
        System.out.println(Arrays.toString(ints));
        System.out.println();

        IntStream intStream2 = IntStream.rangeClosed(0, 100);
        int[] ints2 = intStream2.toArray();
        System.out.println("Metoda rangeClosed()");
        System.out.println(Arrays.toString(ints2));
        System.out.println();

        int[] ints3 = IntStream.iterate(0, integer -> integer + 1)
                .limit(101)
                .map(integer -> integer * integer)
                .filter(integer -> integer % 2 == 0)
                .toArray();
        System.out.println("Liczby dodatnie, będące kwadratami liczb z przedziału <0, 100>");
        System.out.println(Arrays.toString(ints3));
    }
}
