package kodilla.modul2.calculateTheAverage.versionWithStream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayRandomRange {
    public void settingTheRandomRange() {
        List<Integer> numbers =  new Random().ints(1,100)
                .limit(20).boxed().collect(Collectors.toList());

        for (Object theIntegers:
                numbers) {
            System.out.println(theIntegers);
        }

        int counter = numbers.size();

        Double average = numbers.stream().mapToInt(value -> value).average().orElse(0.0);
        System.out.println("The ArrayList size is: " + counter);
        System.out.println("The ArrayList average is: " + average);
    }
}
