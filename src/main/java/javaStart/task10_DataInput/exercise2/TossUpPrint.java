package javaStart.task10_DataInput.exercise2;

public class TossUpPrint {
    void chooseMainMenu() {
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
        System.out.println("Heads has been drawn");
    }

    void winTails() {
        System.out.println("Tails has been drawn");
    }

    void closeProgram() {
        System.out.println("The program has been closed");
    }
}
