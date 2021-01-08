package javaStart.task36Collections.exercise1.extended;

import java.io.*;
import java.util.*;

public class CsvFileManager {
    private static final String FILE_NAME = "D:\\INNE\\Programowanie\\Projects\\learning\\lotto.txt";
    private static final String HEADER = "Lotto lottery";
    private static Scanner input = new Scanner(System.in);
    private static List<Integer> playerNumbers = new ArrayList<>();
    private static List<Integer> lotteryNumbers = new ArrayList<>();

    public static void main(String[] args) {
        try {
            readFile();
            printLine("The file data has been read");
        } catch (DataReadException e) {
            e.getMessage();
            printLine("The new database has been initiated");
        }
        generate();
        printLine("Your numbers: " + playerNumbers);
        randomize();
        printLine("Lottery result: " + lotteryNumbers);
        int result = checkResult();
        printLine("The numbers of hit is: " + result);
        try {
            writeFile(result);
            printLine("Write data into file has been finished successfully");
        } catch (DataReadException e) {
            e.getMessage();
        }
        printLine("End of program");
    }

    public static List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public static List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    static void readFile() {
        String line;
        try (final var br = new BufferedReader(new FileReader(FILE_NAME))){
            while ((line = br.readLine()) != null) {
                printLine(line);
            }
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataReadException("Error data read " + FILE_NAME);
        }
    }

    static void writeFile(int result) {
        try (var bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            bw.write(HEADER);
            bw.newLine();
            bw.write("Your numbers: " + getPlayerNumbers());
            bw.newLine();
            bw.write("Lottery result: "+ getLotteryNumbers());
            bw.newLine();
            bw.write("The numbers of hit is: " + result);
            bw.newLine();
        } catch (IOException e) {
            throw new DataWriteException("Error data write into a file: " + FILE_NAME);
        }
    }

    private static void generate() {
        printLine("Enter 6 numbers from 1 to 49");
        int lottoNumberLength = 6;
        int number;
        for (int i = 0; i < lottoNumberLength ; i++) {
            printLine("Enter number " + (i + 1));
            number = getLottoNumber();
            playerNumbers.add(number);
        }
    }

    private static void randomize() {
        for (int i = 1; i < 50; i++) {
            lotteryNumbers.add(i);
        }
        Collections.shuffle(lotteryNumbers);
        lotteryNumbers.subList(6,49).clear();
    }

    private static int checkResult() {
        int result = 0;
        for (Integer playerNumber : playerNumbers) {
            for (Integer lotteryNumber : lotteryNumbers) {
                if (playerNumber.equals(lotteryNumber)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int getLottoNumber() {
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

    private static int getDigit() {
        int one = 1;
        int fortyNine = 49;
        int number = input.nextInt();
        if (number >= one && number <= fortyNine) {
            return number;
        } else {
            throw new IncorrectNumberOutOfScope("Incorrect number out of scope, try again");
        }
    }

    private static void checkDuplicate(Integer number, List<Integer> integers) {
        for (Integer integer : integers) {
            if (number.equals(integer)) {
                throw new DuplicateException("This number exists already, try again");
            }
        }
    }

    private static void clearBuffer() {
        input.nextLine();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static class DataWriteException extends RuntimeException {
        public DataWriteException(String message) {
            printLineError(message);
        }
    }

    private static class DataReadException extends RuntimeException {
        public DataReadException(String message) {
            printLineError(message);
        }
    }
}
