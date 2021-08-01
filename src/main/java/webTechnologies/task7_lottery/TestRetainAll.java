package webTechnologies.task7_lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestRetainAll {
    public static void main(String[] args) {
        List<Integer> source = List.of(1,2,3,4,5,12);
        System.out.println("source: " + source);
        List<Integer> target = List.of(7,8,9,10,11,12);
//        List<Integer> sourceCopy = getCommonElements(source, target);
        List<Integer> sourceCopy = new ArrayList<>(source);
        System.out.println("sourceCopy: " + sourceCopy);
//        System.out.println(sourceCopy);

        target = getRandomNumbers();
        System.out.println("target: " + target);

    }

    private static List<Integer> getCommonElements(List<Integer> source, List<Integer> target) {
        List<Integer> sourceCopy = new ArrayList<>(source);
        sourceCopy.retainAll(target);
        return sourceCopy;
    }

    private static List<Integer> getRandomNumbers() {
        List<Integer> numberList = IntStream.rangeClosed(1,49)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList.subList(0,6);
    }
}
