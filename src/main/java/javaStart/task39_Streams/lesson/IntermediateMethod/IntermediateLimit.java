package javaStart.task39_Streams.lesson.IntermediateMethod;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateLimit {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.iterate(1, integer -> integer + 1)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
