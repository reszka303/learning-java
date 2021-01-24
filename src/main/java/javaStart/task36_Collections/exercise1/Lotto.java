package javaStart.task36_Collections.exercise1;

import java.io.*;
import java.util.*;

public class Lotto {

    private static Scanner input = new Scanner(System.in);
    private static List<Integer> playerNumbers = new ArrayList<>();
    private static List<Integer> lottoNumbers = new ArrayList<>();
    private static int result;
    private static final String FILE_NAME = "D:\\INNE\\Programowanie\\Projects\\learning\\lotto.txt";
    private static final String HEADER = "Lotto lottery";

    public static void main(String[] args) {
       run();
    }

    private static void run() {
        try {
            readFile();
            printLine("The file data has been read");
        } catch (DataReadException e) {
            e.getMessage();
            printLine("The new database has been initiated");
        }
        enterLottoNumbersByPlayer();
        generate();
        randomize();
        result = checkResult();
        printLine("Your numbers: " + playerNumbers);
        printLine("Lottery result: "+ lottoNumbers);
        printLine("The numbers of hit is: " + result);
        try {
            writeFile();
            printLine("Data write into file has been finished successfully");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        printLine("End of program");
    }

    private static void readFile() {
        try (var br = new BufferedReader(new FileReader(FILE_NAME))){
            dataReadLogic(br);
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataReadException("Data read error " + FILE_NAME);
        }
    }

    private static void dataReadLogic(BufferedReader br) throws IOException {
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
//            printLine(line);
        }
    }

    private static void writeFile() {
        try (var bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            dataWriteLogic(bw);
        } catch (IOException e) {
            throw new DataWriteException("Data write error into file " + FILE_NAME);
        }
    }

    private static void dataWriteLogic(BufferedWriter bw) throws IOException {
        bw.write(HEADER);
        bw.newLine();
        bw.write("Your numbers: " + playerNumbers);
        bw.newLine();
        bw.write("Lottery result: " + lottoNumbers);
        bw.newLine();
        bw.write("The numbers of hit is: " + result);
        bw.newLine();
        bw.newLine();
    }

    private static void enterLottoNumbersByPlayer() {
        printLine("Welcome to Lotto lottery");
        printLine("Enter 6 numbers");
        int lottoNumber;
        int sixLottoNumbers = 6;
        for (int i = 0; i < sixLottoNumbers; i++) {
            printLine("Enter " + (i + 1) + " number");
            lottoNumber = getLottoNumber();
            playerNumbers.add(lottoNumber);
        }
    }

    private static void generate() {
        for (int i = 1; i < 50 ; i++) {
            lottoNumbers.add(i);
        }
    }

    private static void randomize() {
        Collections.shuffle(lottoNumbers);
        lottoNumbers.subList(6,49).clear();
    }

    private static int checkResult() {
        for (Integer playerNumber : playerNumbers) {
            for (Integer lottoNumber : lottoNumbers) {
                if (playerNumber.equals(lottoNumber)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int getLottoNumber() {
        boolean lottoNumberOk = false;
        int lottoNumber = 0;
        while (!lottoNumberOk) {
            try {
                lottoNumber = getInt();
                checkRangeLottoNumber(lottoNumber);
                checkDuplicateLottoNumber(lottoNumber, playerNumbers);
                lottoNumberOk = true;
            } catch (ExceedRangeLottoNumberException | DuplicateNumberLottoException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printLineError("Enter digit, try again");
            }
        }
        return lottoNumber;
    }

    private static void checkRangeLottoNumber(int lottoNumber) {
        int one = 1;
        int fortyNine = 49;
        if (lottoNumber < one || lottoNumber > fortyNine) {
            throw new ExceedRangeLottoNumberException("Number out of the range, try again");
        }
    }

    private static void checkDuplicateLottoNumber(Integer lottoNumber, List<Integer> numbers) {
        for (Integer number : numbers) {
            if (lottoNumber.equals(number)) {
                throw new DuplicateNumberLottoException("This number exists already, try again");
            }
        }
    }

    private static class ExceedRangeLottoNumberException extends RuntimeException {
        public ExceedRangeLottoNumberException(String message) {
            printLineError(message);
        }
    }

    private static class DuplicateNumberLottoException extends RuntimeException {
        public DuplicateNumberLottoException(String message) {
            printLineError(message);
        }
    }

    private static class DataReadException extends RuntimeException {
        public DataReadException(String message) {
            printLineError(message);
        }
    }

    private static class DataWriteException extends RuntimeException {
        public DataWriteException(String message) {
            printLineError(message);
        }
    }

    private static int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
