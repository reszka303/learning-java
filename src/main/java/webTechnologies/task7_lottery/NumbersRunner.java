package webTechnologies.task7_lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersRunner {
    public static void main(String[] args) {
        List<Integer> lotteryList = NumbersManager.randomLottery();
        List<Integer> playerList = new ArrayList<>(Arrays.asList(1, 11, 14, 23, 34, 49));
        System.out.println("Lista loteryjna: " + lotteryList);
        System.out.println("Lista zawodnika: " + playerList);
        lotteryList = NumbersManager.lottery(lotteryList, playerList);
        System.out.println("Liczba trafień: " + lotteryList.size());
        System.out.println(lotteryList);

    }
}
