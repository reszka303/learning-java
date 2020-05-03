package javaStart.task10_DataInput.exercise2;

public class TossUpLogic {
    TossUpPrint tossUpPrint = new TossUpPrint();
    ChoiceLogic choiceLogic = new ChoiceLogic();
    DrawLogic drawLogic = new DrawLogic();

    private void playGame() {
        int choice = choiceLogic.chooseRightChoice();

        switch (choice) {
            case 1:
                tossUpPrint.chooseHeads();
                drawLogic.drawHeads();
                chooseMenuAfterGame();
                break;
            case 2:
                tossUpPrint.chooseTails();
                drawLogic.drawTails();
                chooseMenuAfterGame();
                break;
            case 0:
                tossUpPrint.closeProgram();
                System.exit(0);
        }
    }

    void chooseMainMenu() {
        tossUpPrint.chooseMainMenu();
        playGame();
    }

    void chooseMenuAfterGame() {
        tossUpPrint.chooseMenuAfterGame();
        playGame();
    }
}
