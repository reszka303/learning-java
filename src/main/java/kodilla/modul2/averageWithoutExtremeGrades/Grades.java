package kodilla.modul2.averageWithoutExtremeGrades;

import java.util.*;
import java.util.stream.Collectors;

public class Grades {

    public List<Integer> random(List<Integer> grades) {
        Random randomSize = new Random();
        Random randomGrades = new Random();

        for (int i = 0; i < randomSize.nextInt(15) + 3 ; i++) {
            int item = randomGrades.nextInt(6) + 1;
            grades.add(item);
        }
        return grades;
    }

    public  List<Integer> skipMinMax(List<Integer> grades) {
        return grades
                .stream()
                .filter(g -> g != Collections.min(grades))
                .filter(g -> g != Collections.max(grades))
                .collect(Collectors.toList());
    }

    public double calculateAverageStreamWithoutMinMax(List<Integer> grades) {
        return grades
                .stream()
                .filter(g -> g != Collections.min(grades))
                .filter(g -> g != Collections.max(grades))
                .mapToInt(g -> g)
                .average().getAsDouble();
    }

    public double calculateAverageLoop(List<Integer> grades) {
        Integer sum = 0;
        if (!grades.isEmpty()) {
            for (int i:
                 grades) {
                sum += i;
            }
            return sum.doubleValue() / grades.size();
        }
        return sum;
    }
}
