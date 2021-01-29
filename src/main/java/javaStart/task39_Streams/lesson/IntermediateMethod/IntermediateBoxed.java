package javaStart.task39_Streams.lesson.IntermediateMethod;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateBoxed {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
