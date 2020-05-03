package javaStart.task10_DataInput.exercise2;

import java.util.Random;

public class DrawLogic {
    TossUpPrint tossUpPrint = new TossUpPrint();
    CountdownLogic countdownLogic = new CountdownLogic();

    void drawHeads() {
        Random random = new Random();
        int draw = random.nextInt(2) + 1;
        countdownLogic.runTimer();

        if (draw == 1) {
            tossUpPrint.winHeads();
        } else {
            tossUpPrint.lose();
        }
    }

    void drawTails() {
        Random random = new Random();
        int draw = random.nextInt(2) + 1;
        countdownLogic.runTimer();

        if (draw == 2) {
            tossUpPrint.winTails();
        } else {
            tossUpPrint.lose();
        }
    }
}
