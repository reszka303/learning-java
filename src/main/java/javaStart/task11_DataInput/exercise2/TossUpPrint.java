package javaStart.task11_DataInput.exercise2;


public class TossUpPrint implements java.lang.Runnable {
    public void run() {
        this.run();
    }

    void printMainMenu() {
        System.out.println("==TossUp==");
        System.out.println("Main Menu");
        System.out.println("What do you choose?");
        partOfMenu();
    }

    void displayIncorrectChoice() {
        System.out.println("Error! Incorrect choice");
    }

    void chooseMenuAfterGame() {
        System.out.println("Maybe you want to play again?");
        partOfMenu();
    }

    private void partOfMenu() {
        System.out.println("1 - Heads");
        System.out.println("2 - Tails");
        System.out.println("0 - Close program");
    }

    void chooseHeads() {
        System.out.println("You have chosen a heads");
        beginningDraw();
    }

    void chooseTails() {
        System.out.println("You have chosen a tails");
        beginningDraw();
    }

    private void beginningDraw() {
        System.out.println("Draw has been begun and " +
                "you find out if you win or lose soon");
    }

    void displayCatchException() {
        System.out.println("You gave wrong number");
        System.out.println("Give integer number according to Menu");
        System.out.println("Try again...");
    }

    void win() {
        System.out.println("Congratulations! You won");
    }

    void lose() {
        System.out.println("Sorry! You lose");
    }

    void winHeads() {
        System.out.println("Heads has been randomly drawn");
    }

    void winTails() {
        System.out.println("Tails has been randomly drawn");
    }

    void closeProgram() {
        System.out.println("The program has been closed");
    }

    void runTimer() {
        int i = 10;
        while (i > 0) {
            System.out.println(i);
            try {
                i--;
                Thread.sleep(1000L);
            } catch (InterruptedException e) {

            }
        }
    }
}
