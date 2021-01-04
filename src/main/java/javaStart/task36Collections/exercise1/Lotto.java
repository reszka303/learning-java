package javaStart.task36Collections.exercise1;

import java.util.*;

public class Lotto {
    private final Scanner input = new Scanner(System.in);
    private final List<Integer> playerNumbers = new ArrayList<>();
    private final List<Integer> lotteryNumbers = new ArrayList<>();

    public void run() {
        generate();
        printLine("Your numbers: " + playerNumbers);
        randomize();
        printLine("Lottery result: " + lotteryNumbers);
        int result = checkResult();
        printLine("The numbers of hit is: " + result);
    }

    private void generate() {
        printLine("Welcome to Lotto lottery");
        printLine("Enter 6 numbers from 1 to 49");
        int lottoNumberLength = 6;
        int number;
        for (int i = 0; i < lottoNumberLength ; i++) {
            printLine("Enter number " + (i + 1));
            number = getLottoNumber();
            playerNumbers.add(number);
        }
    }

    private void randomize() {
        for (int i = 1; i < 50; i++) {
            lotteryNumbers.add(i);
        }
        Collections.shuffle(lotteryNumbers);
        lotteryNumbers.subList(6,49).clear();
    }

    private int checkResult() {
        int counter = 0;
        for (Integer playerNumber : playerNumbers) {
            for (Integer lotteryNumber : lotteryNumbers) {
                if (playerNumber.equals(lotteryNumber)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int getLottoNumber() {
        boolean lottoNumber = false;
        int number = 0;

        while (!lottoNumber) {
            try {
                number = getDigit();
                checkDuplicate(number, playerNumbers);
                lottoNumber = true;
            } catch (IncorrectNumberOutOfScope | DuplicateException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("Enter a digit, try again");
            } finally {
                clearBuffer();
            }
        }
        return number;
    }

    private int getDigit() {
        int one = 1;
        int fortyNine = 49;
        int number = input.nextInt();

        if (number >= one && number <= fortyNine) {
            return number;
        } else {
            throw new IncorrectNumberOutOfScope("Incorrect number out of scope, try again");
        }
    }

    private void checkDuplicate(Integer number, List<Integer> integers) {
        for (Integer integer : integers) {
            if (number.equals(integer)) {
                throw new DuplicateException("This number exists already, try again");
            }
        }
    }

    private void clearBuffer() {
        input.nextLine();
    }

    private void printLine(String text) {
        System.out.println(text);
    }

    private void printLineError(String text) {
        System.err.println(text);
    }
}
