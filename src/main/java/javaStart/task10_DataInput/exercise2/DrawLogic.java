package javaStart.task10_DataInput.exercise2;

import java.util.Random;

public class DrawLogic {
    TossUpPrint tossUpPrint = new TossUpPrint();
    CountdownLogic countdownLogic = new CountdownLogic();

    private int draw() {
        Random random = new Random();
        int draw = random.nextInt(2) + 1;
        countdownLogic.runTimer();

        if (draw == 1) {
            tossUpPrint.win();
        } else {
            tossUpPrint.lose();
        }
        return draw;
    }

    void drawHeads() {
        int resultDraw = draw();
        if (resultDraw == 1) {
            tossUpPrint.winHeads();
        } else {
            tossUpPrint.winTails();
        }
    }

    void drawTails() {
        int resultDraw = draw();
        if (resultDraw == 1) {
            tossUpPrint.winTails();
        } else {
            tossUpPrint.winHeads();
        }
    }
}
