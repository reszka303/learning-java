package javaStart.task10_DataInput.exercise2;

import java.util.Random;

public class RandomProcess {
    TossUpPrint tossUpPrint = new TossUpPrint();

    private int randomise() {
        Random random = new Random();
        int randomizedTrial = random.nextInt(2) + 1;
        tossUpPrint.runTimer();

        if (randomizedTrial == 1) {
            tossUpPrint.win();
        } else {
            tossUpPrint.lose();
        }
        return randomizedTrial;
    }

    void randomHeads() {
        int resultOfRandomizedTrial = randomise();
        if (resultOfRandomizedTrial == 1) {
            tossUpPrint.winHeads();
        } else {
            tossUpPrint.winTails();
        }
    }

    void randomTails() {
        int resultOfRandomizedTrial = randomise();
        if (resultOfRandomizedTrial == 1) {
            tossUpPrint.winTails();
        } else {
            tossUpPrint.winHeads();
        }
    }
}
