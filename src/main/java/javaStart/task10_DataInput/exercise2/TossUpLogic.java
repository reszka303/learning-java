package javaStart.task10_DataInput.exercise2;

public class TossUpLogic {
    TossUpPrint tossUpPrint = new TossUpPrint();
    ChoiceLogic choiceLogic = new ChoiceLogic();
    RandomProcess randomProcess = new RandomProcess();

    void executeMainMenu() {
        tossUpPrint.printMainMenu();
        mainMenuLogic();
    }

    private void mainMenuLogic() {
        int choice = choiceLogic.chooseRightChoice();

        switch (choice) {
            case 1:
                tossUpPrint.chooseHeads();
                randomProcess.randomHeads();
                menuAfterRandomizedTrial();
                break;
            case 2:
                tossUpPrint.chooseTails();
                randomProcess.randomTails();
                menuAfterRandomizedTrial();
                break;
            case 0:
                tossUpPrint.closeProgram();
                System.exit(0);
        }
    }

    private void menuAfterRandomizedTrial() {
        tossUpPrint.chooseMenuAfterGame();
        mainMenuLogic();
    }
}
