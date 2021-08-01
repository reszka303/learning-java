package webTechnologies.task7_lottery;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumbersManager {
    static List<Integer> lottery(List<Integer> lotteryNumbers, List<Integer> playerNumbers) {
        return lotteryNumbers.stream()
                .filter(playerNumbers::contains)
                .collect(Collectors.toList());
    }

    static List<Integer> randomLottery() {
        return new Random().ints(6, 1,50)
                .boxed()
                .collect(Collectors.toList());
    }
}
