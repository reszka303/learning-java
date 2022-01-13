package arraysTasks.Codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=a1o7w1UX93g

public class FindingMissingElementByStream {

    private static final int[] ints = new int[]{1,2,3,5,4,1};
//    private static final int[] ints = new int[]{1,2,4,2};

    public static void main(String[] args) {
        List<Integer> integers = Arrays.stream(ints)
                .boxed()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(integers);
        int missingNumber = getMissingNumber(integers);
        System.out.printf("Brakująca liczba to: %d\n", missingNumber);;
    }

    private static int getMissingNumber(List<Integer> integers) {
        int n = integers.size() + 1;
        int actualSum = (n * (n + 1)) / 2;
        int sum = integers.stream().reduce(0, Integer::sum);
        return actualSum - sum;
    }

}
