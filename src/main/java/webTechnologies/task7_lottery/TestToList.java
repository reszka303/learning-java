package webTechnologies.task7_lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestToList {
    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "5"};
        System.out.println(Arrays.toString(numbers));
        List<Integer> integers = Arrays.stream(numbers).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(integers);
    }
}
