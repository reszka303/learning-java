package javaStart.task40_CollectionProcessing.exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hoc autem tempore, " +
                "etsi multa in omni parte Athenarum sunt in ipsis locis indicia summorum virorum, " +
                "tamen ego illa moveor exhedra.";

        String[] separator = sentence.split(" ");

        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(separator));

//        for (String word : list) {
//            System.out.println(word);
//        }

        list.stream()
                .filter(word -> !word.contains(",") && !word.contains("."))
                .collect(Collectors.toList());

        for (String word : list) {
            System.out.println(word);
        }


    }
}
